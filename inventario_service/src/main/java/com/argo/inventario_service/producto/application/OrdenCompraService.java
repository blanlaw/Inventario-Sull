package com.argo.inventario_service.producto.application;

import com.argo.inventario_service.area.domain.repository.IAlmacen;
import com.argo.inventario_service.movimientos.domain.Entrada;
import com.argo.inventario_service.movimientos.domain.enm.TipoEntrada;
import com.argo.inventario_service.movimientos.domain.enm.estadoMovimiento;
import com.argo.inventario_service.movimientos.domain.repository.IEntrada;
import com.argo.inventario_service.movimientos.domain.repository.IEntradaDetalles;
import com.argo.inventario_service.movimientos.domain.repository.ISalida;
import com.argo.inventario_service.movimientos.domain.repository.ISalidaDetalles;
import com.argo.inventario_service.producto.application.models.detalles.detallesordenmodelo;
import com.argo.inventario_service.producto.application.models.detalles.ordenCompramodeloDetalles;
import com.argo.inventario_service.producto.application.models.detallesProveedorModel;
import com.argo.inventario_service.producto.application.models.ordenCompraModel;
import com.argo.inventario_service.producto.domain.CodigoProducto;
import com.argo.inventario_service.producto.domain.DetallesOrden;
import com.argo.inventario_service.producto.domain.OrdenDeCompra;
import com.argo.inventario_service.producto.domain.embd.embdOrdenEntrada;
import com.argo.inventario_service.producto.domain.repository.*;
import com.argo.inventario_service.requerimiento.domain.enm.EstadoRequerimiento;
import com.argo.inventario_service.requerimiento.domain.repository.IDetallesRequerimiento;
import com.argo.inventario_service.requerimiento.domain.repository.IRequerimiento;
import com.argo.inventario_service.util.obtenerusuario;
import com.argo.inventario_service.util.transformarFecha;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Orden compra service.
 */
@Service
public class OrdenCompraService {
    /**
     * The constant CODEREQ.
     */
    public static final String CODEREQ = "OC-ALM-";
    private final IOrdenDetalles iOrdenDetalles;
    private final IOrden iOrden;
    private final IEntradaDetalles iEntradaDetalles;
    private final IEntrada iEntrada;
    private final IProduct iProduct;
    private final IRequerimiento iRequerimiento;
    private final IDetallesRequerimiento iDetallesRequerimiento;
    private final transformarFecha fecha;
    private final ICodigoProducto iCodigoProducto;
    private final IAlmacen iAlmacen;
    private final ISalida iSalida;
    private final ISalidaDetalles iSalidaDetalles;
    private final IOrdenEntrada iOrdenEntrada;
    private final IType iType;
    @Autowired
    private obtenerusuario getUser;

    /**
     * Instantiates a new Orden compra service.
     *
     * @param iOrdenDetalles         the orden detalles
     * @param iOrden                 the orden
     * @param iEntradaDetalles       the entrada detalles
     * @param iEntrada               the entrada
     * @param iProduct               the product
     * @param iRequerimiento         the requerimiento
     * @param iDetallesRequerimiento the detalles requerimiento
     * @param fecha                  the fecha
     * @param iCodigoProducto        the codigo producto
     * @param iAlmacen               the almacen
     * @param iSalida                the salida
     * @param iSalidaDetalles        the salida detalles
     * @param iOrdenEntrada          the orden entrada
     * @param iType                  the type
     */
    public OrdenCompraService(IOrdenDetalles iOrdenDetalles, IOrden iOrden, IEntradaDetalles iEntradaDetalles, IEntrada iEntrada, IProduct iProduct, IRequerimiento iRequerimiento, IDetallesRequerimiento iDetallesRequerimiento, transformarFecha fecha, ICodigoProducto iCodigoProducto, IAlmacen iAlmacen, ISalida iSalida, ISalidaDetalles iSalidaDetalles, IOrdenEntrada iOrdenEntrada, IType iType) {
        this.iOrdenDetalles = iOrdenDetalles;
        this.iOrden = iOrden;
        this.iEntradaDetalles = iEntradaDetalles;
        this.iEntrada = iEntrada;
        this.iProduct = iProduct;
        this.iRequerimiento = iRequerimiento;
        this.iDetallesRequerimiento = iDetallesRequerimiento;
        this.fecha = fecha;
        this.iCodigoProducto = iCodigoProducto;
        this.iAlmacen = iAlmacen;
        this.iSalida = iSalida;
        this.iSalidaDetalles = iSalidaDetalles;
        this.iOrdenEntrada = iOrdenEntrada;
        this.iType = iType;
    }

    /**
     * Crear orden compra nuevo.
     *
     * @param token  the token
     * @param modelo the modelo
     */
//orden de compra producto ya existente
    @Transactional(rollbackFor = Exception.class)
    public void crearOrdenCompraNuevo(String token, ordenCompraModel modelo) {


        User usuario = this.getUser.getUser(token);
        Almacen almacen = this.iAlmacen.findById(1).orElseThrow(RuntimeException::new);


        try {

            long count = this.iOrden.count();


            detallesProveedorModel proveedor = modelo.getProveedor();

            OrdenDeCompra compra = new OrdenDeCompra(
                    modelo.getNumeroComprobante(), usuario, CODEREQ + count, new Date(), modelo.getFechaEntrega(),
                    modelo.getDireccionEntrega(), modelo.getMonedas(), modelo.getCondicionPago(),
                    modelo.getFormaPago(), proveedor.getRuc(), proveedor.getNombre(), proveedor.getDireccion(), proveedor.getCorreo(), proveedor.getTelefono(),
                    modelo.getObservaciones(), almacen);
            OrdenDeCompra save = this.iOrden.save(compra);


            List<DetallesOrden> detallesOrdenes = modelo.getDetalles().stream().map(det -> {

                String tipo = this.iType.findById(det.getTipo()).get().getTipo();


                Optional<CodigoProducto> byData = this.iCodigoProducto.findByData(tipo, det.getDescripcion(), det.getTalla(), det.getModelo(), det.getMarca(), det.getColor(), det.getPrecioUnitario(), det.getUnidadMedida());

                if (byData.isPresent()) {

                    CodigoProducto codigoProducto = byData.get();

                    return new DetallesOrden(codigoProducto.getCodigo(), codigoProducto.getColor(), codigoProducto.getMarca(), codigoProducto.getModelo(), codigoProducto.getDescripcion(),
                            codigoProducto.getTalla(), save, det.getDescuento(), det.getPrecioUnitario(), det.getCantidad(), codigoProducto.getTipo(), codigoProducto.getUnidadMedida());


                } else {

                    String codigo = det.getDescripcion() + tipo.substring(0, 4) + "-" + 0;


                    List<String> strings = this.iCodigoProducto.todoLista(det.getDescripcion());


                    if (strings.size() != 0) {


                        String[] cod = strings.get(0).split("-");

                        String nuevocod = cod[0] + "-" + (strings.size());


                        return new DetallesOrden(nuevocod, det.getColor(), det.getMarca(), det.getModelo(), det.getDescripcion(),
                                det.getTalla(), save, det.getDescuento(), det.getPrecioUnitario(), det.getCantidad(), this.iType.getOne(det.getTipo()), det.getUnidadMedida());


                    } else {
                        return new DetallesOrden(codigo, det.getColor(), det.getMarca(), det.getModelo(), det.getDescripcion(),
                                det.getTalla(), save, det.getDescuento(), det.getPrecioUnitario(), det.getCantidad(), this.iType.getOne(det.getTipo()), det.getUnidadMedida());
                    }


                }


                // todos son iguales obtengo el codigo


            }).collect(Collectors.toList());
            List<DetallesOrden> detallesOrdens = this.iOrdenDetalles.saveAll(detallesOrdenes);


        } catch (Exception ex) {

            ex.printStackTrace();
            throw new RuntimeException("error al hacer orden de compra");

        }


    }


    /**
     * Confirmar orden compra.
     *
     * @param idorden the idorden
     * @param token   the token
     */
    @Transactional(rollbackFor = Exception.class)
    public void confirmarOrdenCompra(String idorden, String token) {


        try {
            User usuario = this.getUser.getUser(token);
            Almacen almacen = usuario.getIdAlmacen();


            OrdenDeCompra ordenDeCompra = this.iOrden.findById(idorden).orElseThrow(RuntimeException::new);
            ordenDeCompra.setEstadoOrden(EstadoRequerimiento.ACEPTADO);
            Entrada entrada = new Entrada(estadoMovimiento.ESPERA_CONFIRMACION, null, null, null, null, almacen, almacen, usuario, TipoEntrada.COMPRA, null);
            Entrada save1 = this.iEntrada.save(entrada);

            /*List<EntradaDetalles> collect = ordenDeCompra.getDetallesOrden().stream().map(detallesOrden -> {


                CodigoProducto codigoProducto = this.iCodigoProducto.findById(detallesOrden.getCodigo_producto()).orElseGet(() -> new CodigoProducto(detallesOrden.getCodigo_producto(),detallesOrden.getNombre(),detallesOrden.getModelo(),detallesOrden.getMarca(),detallesOrden.getColor(),detallesOrden.getTalla(),detallesOrden.getTipoProducto(),detallesOrden.getPrecioUnitario(),detallesOrden.getUnidadMedida()));

                EntradaDetalles entradaDetalles = new EntradaDetalles(codigoProducto, detallesOrden.getCantidad(), save1, codigoProducto.getPrecioUnitario());

                return entradaDetalles;


            }).collect(Collectors.toList());*/

            //List<EntradaDetalles> entradaDetalles = this.iEntradaDetalles.saveAll(collect);

            this.iOrdenEntrada.save(new embdOrdenEntrada(ordenDeCompra, save1));
        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }


    /**
     * Mis ordenes list.
     *
     * @param token the token
     * @return the list
     */
    public List misOrdenes(String token) {


        User user = this.getUser.getUser(token);
        Almacen almacen = user.getIdAlmacen();


        return this.iOrden.misOrdenes(almacen);


    }

    /**
     * Detales orden orden compramodelo detalles.
     *
     * @param token the token
     * @param id    the id
     * @return the orden compramodelo detalles
     */
    public ordenCompramodeloDetalles detalesOrden(String token, String id) {

        ordenCompramodeloDetalles no_tiene = Arrays.asList(this.iOrden.findById(id).get()).stream().map(ordenDeCompra -> {

            ordenCompramodeloDetalles detalles = new ordenCompramodeloDetalles(
                    ordenDeCompra.getNumeroOrden(), ordenDeCompra.getCondicionPago(),
                    ordenDeCompra.getCorreo(), ordenDeCompra.getDireccionEntrega(),
                    ordenDeCompra.getEstadoOrden(), ordenDeCompra.getFechaEntrega(), ordenDeCompra.getFechaOrden(),
                    ordenDeCompra.getMonedas(), ordenDeCompra.getNombreProveedor(),
                    ordenDeCompra.getNumeroComprobante(), ordenDeCompra.getObservaciones(),
                    ordenDeCompra.getPhone(), ordenDeCompra.getRuc(), ordenDeCompra.getIdAlmacen().getAlmacen(),
                    "NO TIENE", ordenDeCompra.getIdUser().getEmail(), ordenDeCompra.getDireccion(),
                    ordenDeCompra.getFormaPago());

            detalles.setDetalles(ordenDeCompra.getDetallesOrden().stream().map(detallesOrden -> {


                return new detallesordenmodelo(
                        detallesOrden.getIdDetalles(),
                        detallesOrden.getCodigo_producto(), detallesOrden.getNombre(),
                        detallesOrden.getTalla(), detallesOrden.getColor(),
                        detallesOrden.getModelo(), detallesOrden.getMarca(),
                        detallesOrden.getTipoProducto().getTipo(),
                        detallesOrden.getCantidad(), detallesOrden.getUnidadMedida(),
                        detallesOrden.getPrecioUnitario(), detallesOrden.getDescuento(),
                        detallesOrden.getSubTotal()


                );


            }).collect(Collectors.toList()));
            return detalles;

        }).collect(Collectors.toList()).get(0);
        return no_tiene;

    }
}
