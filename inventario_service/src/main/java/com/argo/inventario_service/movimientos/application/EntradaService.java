package com.argo.inventario_service.movimientos.application;

import com.argo.inventario_service.area.domain.repository.IAlmacen;
import com.argo.inventario_service.movimientos.application.models.data;
import com.argo.inventario_service.movimientos.application.models.detallesEntradaModel;
import com.argo.inventario_service.movimientos.application.models.entradaModel;
import com.argo.inventario_service.movimientos.domain.Entrada;
import com.argo.inventario_service.movimientos.domain.EntradaDetalles;
import com.argo.inventario_service.movimientos.domain.Salida;
import com.argo.inventario_service.movimientos.domain.enm.TipoEntrada;
import com.argo.inventario_service.movimientos.domain.enm.estadoMovimiento;
import com.argo.inventario_service.movimientos.domain.repository.IEntrada;
import com.argo.inventario_service.movimientos.domain.repository.IEntradaDetalles;
import com.argo.inventario_service.movimientos.domain.repository.ISalida;
import com.argo.inventario_service.movimientos.domain.repository.ISalidaDetalles;
import com.argo.inventario_service.producto.domain.CodigoProducto;
import com.argo.inventario_service.producto.domain.DetallesOrden;
import com.argo.inventario_service.producto.domain.ProductoAlmacen;
import com.argo.inventario_service.producto.domain.embd.embIdProduct;
import com.argo.inventario_service.producto.domain.embd.embdOrdenEntrada;
import com.argo.inventario_service.producto.domain.repository.ICodigoProducto;
import com.argo.inventario_service.producto.domain.repository.IOrdenEntrada;
import com.argo.inventario_service.producto.domain.repository.IProduct;
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
 * The type Entrada service.
 */
@Service
public class EntradaService {

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
    @Autowired
    private obtenerusuario getUser;

    /**
     * Instantiates a new Entrada service.
     *
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
     */
    public EntradaService(IEntradaDetalles iEntradaDetalles, IEntrada iEntrada, IProduct iProduct, IRequerimiento iRequerimiento, IDetallesRequerimiento iDetallesRequerimiento, transformarFecha fecha, ICodigoProducto iCodigoProducto, IAlmacen iAlmacen, ISalida iSalida, ISalidaDetalles iSalidaDetalles, IOrdenEntrada iOrdenEntrada) {
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
    }


    /**
     * Confirmar entrada.
     *
     * @param codigoEntrada the codigo entrada
     * @param modelo        the modelo
     * @param token         the token
     */
    @Transactional(rollbackFor = Exception.class)
    public void confirmarEntrada(int codigoEntrada, entradaModel modelo, String token) {

        try {

            User user = this.getUser.getUser(token);
            Almacen idAlmacen = user.getIdAlmacen();

            Entrada entrada = this.iEntrada.findById(codigoEntrada).orElseThrow(RuntimeException::new);
            entrada.setFechaEntrada(new Date());
            entrada.setMovimiento(estadoMovimiento.ENTREGADO);
            entrada.setObservaciones(modelo.getObservaciones());
            entrada.setTipoComprobante(modelo.getTipoComprobante());
            entrada.setValeIngreso(modelo.getValeIngreso());
            User empleado = this.getUser.getEmpleado(modelo.getIdUsuarioRecibe(), token);

            entrada.setIdUser(empleado);
            Entrada save1 = this.iEntrada.save(entrada);
            if (save1.getTipoEntrada() == TipoEntrada.TRASLADO) {
                Salida salida = this.iSalida.findByRequerimiento(entrada.getIdRequerimiento()).orElseThrow(RuntimeException::new);
                salida.setUsuarioRecibe(empleado);
                salida.setMovimiento(estadoMovimiento.ENTREGADO);
                Salida save2 = this.iSalida.save(salida);
                this.iEntradaDetalles.findByIdEntrada(entrada).forEach(entradaDetalles -> {


                    CodigoProducto codigoProducto = entradaDetalles.getIdProduct();
                    embIdProduct idProduct = new embIdProduct(idAlmacen, codigoProducto);

                    ProductoAlmacen productoAlmacen = this.iProduct.findById(idProduct).orElseGet(() -> {



                        ProductoAlmacen pr =new ProductoAlmacen(idProduct,0);
                         ProductoAlmacen save = this.iProduct.save(pr);
                        return save;
                    });
                    productoAlmacen.setStock(productoAlmacen.getStock() + entradaDetalles.getCantidad());

                    ProductoAlmacen save = this.iProduct.save(productoAlmacen);

                });
            }

            if (save1.getTipoEntrada() == TipoEntrada.COMPRA) {


                embdOrdenEntrada ordenEntrada = this.iOrdenEntrada.buscarEntrada(entrada.getIdEntrada()).orElseThrow(RuntimeException::new);
                List<EntradaDetalles> collect = ordenEntrada.getIdOrden().getDetallesOrden().stream().map(detallesOrden -> {


                    CodigoProducto codigoProducto = this.iCodigoProducto.findByCodigoStartingWith(detallesOrden.getCodigo_producto()).orElseGet(() -> this.iCodigoProducto.save(new CodigoProducto(detallesOrden.getCodigo_producto(), detallesOrden.getNombre(), detallesOrden.getModelo(), detallesOrden.getMarca(), detallesOrden.getColor(), detallesOrden.getTalla(), detallesOrden.getTipoProducto(), detallesOrden.getPrecioUnitario(), detallesOrden.getUnidadMedida())));
//                    CodigoProducto save = this.iCodigoProducto.save(codigoProducto);//actualizar o crear uno nuevo forzamos para la creacion de uno nuevo

                    if (!codigoProducto.getPrecioUnitario().equals(detallesOrden.getPrecioUnitario())) {

                        String nuevoCodigo = this.generarNuevoCodigo(detallesOrden, codigoProducto);


                        CodigoProducto codigo = new CodigoProducto(nuevoCodigo, detallesOrden.getNombre(), detallesOrden.getModelo(), detallesOrden.getMarca(), detallesOrden.getColor(), detallesOrden.getTalla(), detallesOrden.getTipoProducto(), detallesOrden.getPrecioUnitario(), detallesOrden.getUnidadMedida());
                        CodigoProducto save2 = this.iCodigoProducto.save(codigo);
                        embIdProduct idProduct = new embIdProduct(entrada.getIdAlmacenRecibe(), save2);
                        ProductoAlmacen producto = new ProductoAlmacen(idProduct, detallesOrden.getCantidad());

                        ProductoAlmacen save3 = this.iProduct.save(producto);

                        return new EntradaDetalles(save2, detallesOrden.getCantidad(), save1, codigoProducto.getPrecioUnitario());


                    }
                    embIdProduct idProduct = new embIdProduct(entrada.getIdAlmacenRecibe(), codigoProducto);
                    Optional<ProductoAlmacen> byId = this.iProduct.findById(idProduct);

                    byId.ifPresent(productoAlmacen -> {


                        productoAlmacen.setStock(productoAlmacen.getStock() + detallesOrden.getCantidad());

                        ProductoAlmacen save3 = this.iProduct.save(productoAlmacen);

                    });

                    if (!byId.isPresent()) {
                        ProductoAlmacen producto = new ProductoAlmacen(idProduct, detallesOrden.getCantidad());

                        ProductoAlmacen save3 = this.iProduct.save(producto);
                    }


                    return new EntradaDetalles(codigoProducto, detallesOrden.getCantidad(), save1, codigoProducto.getPrecioUnitario());


                }).collect(Collectors.toList());
                List<EntradaDetalles> entradaDetalles = this.iEntradaDetalles.saveAll(collect);

            }


        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }


    private String generarNuevoCodigo(DetallesOrden detallesOrden, CodigoProducto codigoProducto) {


        String[] split = this.iCodigoProducto.findByCodigoStartingWith(codigoProducto.getCodigo()).get().getCodigo().split("-");
        String codigo = split[0];
        int i = Integer.parseInt(split[1]);
        i++;
        String nuevoCodigo = codigo + "-" + i;
        return nuevoCodigo;
    }


    /**
     * Mis entradas list.
     *
     * @param token the token
     * @return the list
     */
    public List misEntradas(String token) {

        User user = this.getUser.getUser(token);
        Almacen idAlmacen = user.getIdAlmacen();


        return this.iEntrada.almacenRecibeEntrada(idAlmacen);

    }

    /**
     * Detalle entrada detalles entrada model.
     *
     * @param token     the token
     * @param idEntrada the id entrada
     * @return the detalles entrada model
     */
    public detallesEntradaModel detalleEntrada(String token, int idEntrada) {

        return Arrays.asList(this.iEntrada.findById(idEntrada).get()).stream().map(entrada -> {

            String empleado="";
            if(entrada.getIdUser()==null){
                empleado="sin definir";
            }else{

                empleado=entrada.getIdUser().getEmail();
            }


            detallesEntradaModel entradaModel = new detallesEntradaModel(
                    entrada.getMovimiento(),
                    entrada.getTipoComprobante(),
                    entrada.getValeIngreso(),
                    entrada.getIdAlmacenEntrega().getAlmacen(),

                    entrada.getObservaciones(),
                    entrada.getTipoEntrada(),
                    empleado


            );

            if (entrada.getTipoEntrada() == TipoEntrada.TRASLADO) {
                entradaModel.setDetalles(entrada.getDetalles().stream().map(entradaDetalles -> new data(entradaDetalles.getIdProduct().getDescripcion(), entradaDetalles.getIdProduct().getTalla()
                        , entradaDetalles.getIdProduct().getMarca(), entradaDetalles.getIdProduct().getColor(), entradaDetalles.getIdProduct().getModelo(),
                        entradaDetalles.getIdProduct().getUnidadMedida(), entradaDetalles.getCantidad(), entradaDetalles.getTotal()


                )).collect(Collectors.toList()));
            }
            if (entrada.getTipoEntrada() == TipoEntrada.COMPRA) {

                embdOrdenEntrada ordenEntrada = this.iOrdenEntrada.buscarEntrada(entrada.getIdEntrada()).get();

                entradaModel.setDetalles(ordenEntrada.getIdOrden().getDetallesOrden().stream().map(detallesOrden -> new data(detallesOrden.getNombre(), detallesOrden.getTalla()
                        , detallesOrden.getMarca(), detallesOrden.getColor(), detallesOrden.getModelo(),
                        detallesOrden.getUnidadMedida(), detallesOrden.getCantidad(), detallesOrden.getSubTotal())).collect(Collectors.toList()));


            }


            return entradaModel;

        }).collect(Collectors.toList()).get(0);
    }

}
