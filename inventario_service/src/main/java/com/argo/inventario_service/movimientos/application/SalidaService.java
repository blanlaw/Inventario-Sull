package com.argo.inventario_service.movimientos.application;

import com.argo.inventario_service.area.domain.repository.IAlmacen;
import com.argo.inventario_service.movimientos.application.models.salidaModel;
import com.argo.inventario_service.movimientos.domain.Entrada;
import com.argo.inventario_service.movimientos.domain.EntradaDetalles;
import com.argo.inventario_service.movimientos.domain.Salida;
import com.argo.inventario_service.movimientos.domain.SalidaDetalles;
import com.argo.inventario_service.movimientos.domain.enm.TipoEntrada;
import com.argo.inventario_service.movimientos.domain.enm.estadoMovimiento;
import com.argo.inventario_service.movimientos.domain.repository.IEntrada;
import com.argo.inventario_service.movimientos.domain.repository.IEntradaDetalles;
import com.argo.inventario_service.movimientos.domain.repository.ISalida;
import com.argo.inventario_service.movimientos.domain.repository.ISalidaDetalles;
import com.argo.inventario_service.producto.domain.ProductoAlmacen;
import com.argo.inventario_service.producto.domain.embd.embIdProduct;
import com.argo.inventario_service.producto.domain.repository.ICodigoProducto;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Salida service.
 */
@Service
public class SalidaService {
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
    @Autowired
    private obtenerusuario getUser;

    /**
     * Instantiates a new Salida service.
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
     */
    @Autowired
    public SalidaService(IEntradaDetalles iEntradaDetalles, IEntrada iEntrada, IProduct iProduct, IRequerimiento iRequerimiento, IDetallesRequerimiento iDetallesRequerimiento, transformarFecha fecha, ICodigoProducto iCodigoProducto, IAlmacen iAlmacen, ISalida iSalida, ISalidaDetalles iSalidaDetalles) {
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
    }


    /**
     * Confirmar salida.
     *
     * @param modelo   the modelo
     * @param idSalida the id salida
     * @param token    the token
     */
    @Transactional(rollbackFor = Exception.class)
    public void confirmarSalida(salidaModel modelo, int idSalida,String token) {

        User empleado = this.getUser.getEmpleado(modelo.getIdUserEntrega(), token);
        try {
            Salida salida = this.iSalida.findById(idSalida).orElseThrow(RuntimeException::new);
            salida.setMovimiento(estadoMovimiento.EN_CAMINO);
            salida.setCombustible(modelo.getCombustible());
            salida.setEmpresa(modelo.getEmpresa());
            salida.setEquipo(modelo.getEequipo());
            salida.setPlaca(modelo.getPlaca());
            salida.setModelo(modelo.getModelo());
            salida.setValeSalida(modelo.getValeIngreso());
            salida.setUsuarioEntrega(empleado);
            salida.setFechaSalida(new Date());
            this.iSalida.save(salida);
            List detallesEntrada = new ArrayList<>();
            Almacen almacenOrigen = salida.getAlmacenOrigen();
            List<SalidaDetalles> byIdSalida = this.iSalidaDetalles.findByIdSalida(salida);
            byIdSalida.forEach(salidaDetalles -> {

                int cantidad = salidaDetalles.getCantidad();

                embIdProduct id = new embIdProduct(almacenOrigen, salidaDetalles.getIdProducto());

                ProductoAlmacen productoAlmacen = this.iProduct.findById(id).orElseThrow(RuntimeException::new);
                if (productoAlmacen.getStock() < cantidad) {
                    throw  new RuntimeException("error en el stock");

                }
                productoAlmacen.setStock(productoAlmacen.getStock() - cantidad);

                ProductoAlmacen save = this.iProduct.save(productoAlmacen);



            });
            //se genera una entrada
            Entrada entrada = new Entrada(

                    estadoMovimiento.EN_CAMINO, null, null, null, salida.getRequerimiento(), salida.getAlmacenDestino(), salida.getAlmacenOrigen(), null, TipoEntrada.TRASLADO,null);
            Entrada save = this.iEntrada.save(entrada);

            List<EntradaDetalles> listaEntrada = byIdSalida.stream().map(salidaDetalles -> {

                EntradaDetalles entradaDetalles = new EntradaDetalles(salidaDetalles.getIdProducto(), salidaDetalles.getCantidad(), save,salidaDetalles.getIdProducto().getPrecioUnitario());
                return entradaDetalles;
            }).collect(Collectors.toList());
            List<EntradaDetalles> entradaDetalles = this.iEntradaDetalles.saveAll(listaEntrada);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error salida");


        }


    }


    /**
     * Mis salidas list.
     *
     * @param token the token
     * @return the list
     */
    public List misSalidas(String token) {

        User user = this.getUser.getUser(token);
        Almacen idAlmacen = user.getIdAlmacen();

        return this.iSalida.findByAlmacenOrigen(idAlmacen);


    }

    /**
     * Detalle salida salida.
     *
     * @param token    the token
     * @param idsalida the idsalida
     * @return the salida
     */
    public Salida detalleSalida(String token,int idsalida){

        return this.iSalida.findById(idsalida).get();

    }

}
