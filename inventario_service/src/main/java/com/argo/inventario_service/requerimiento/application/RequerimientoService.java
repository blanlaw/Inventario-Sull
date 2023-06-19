package com.argo.inventario_service.requerimiento.application;


import com.argo.inventario_service.area.domain.repository.IAccess;
import com.argo.inventario_service.area.domain.repository.IAlmacen;
import com.argo.inventario_service.movimientos.domain.Salida;
import com.argo.inventario_service.movimientos.domain.SalidaDetalles;
import com.argo.inventario_service.movimientos.domain.enm.estadoMovimiento;
import com.argo.inventario_service.movimientos.domain.repository.ISalida;
import com.argo.inventario_service.movimientos.domain.repository.ISalidaDetalles;
import com.argo.inventario_service.producto.domain.repository.ICodigoProducto;
import com.argo.inventario_service.producto.domain.repository.IProduct;
import com.argo.inventario_service.requerimiento.application.models.*;
import com.argo.inventario_service.requerimiento.domain.DetallesRequerimiento;
import com.argo.inventario_service.requerimiento.domain.Requerimiento;
import com.argo.inventario_service.requerimiento.domain.enm.EstadoRequerimiento;
import com.argo.inventario_service.requerimiento.domain.enm.TipoRequerimiento;
import com.argo.inventario_service.requerimiento.domain.repository.IDetallesRequerimiento;
import com.argo.inventario_service.requerimiento.domain.repository.IRequerimiento;
import com.argo.inventario_service.requerimiento.infrastructure.api.dto.RequerimientoDTO;
import com.argo.inventario_service.util.enviarNotificacion;
import com.argo.inventario_service.util.obtenerusuario;
import com.argo.inventario_service.util.transformarFecha;
import com.commons.user.models.entity.accessUser.domain.Access;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The type Requerimiento service.
 */
@Service
public class RequerimientoService {


    private final enviarNotificacion simpMessagingTemplate;


    private final IProduct iProduct;
    private final IRequerimiento iRequerimiento;
    private final IDetallesRequerimiento iDetallesRequerimiento;
    private final obtenerusuario getUser;
    private final transformarFecha fecha;
    private final ICodigoProducto iCodigoProducto;
    private final IAlmacen iAlmacen;
    private final ISalida iSalida;
    private final ISalidaDetalles iSalidaDetalles;
    private final IAccess iAccess;

    /**
     * Instantiates a new Requerimiento service.
     *
     * @param simpMessagingTemplate  the simp messaging template
     * @param iProduct               the product
     * @param iRequerimiento         the requerimiento
     * @param iDetallesRequerimiento the detalles requerimiento
     * @param getUser                the get user
     * @param fecha                  the fecha
     * @param iCodigoProducto        the codigo producto
     * @param iAlmacen               the almacen
     * @param iSalida                the salida
     * @param iSalidaDetalles        the salida detalles
     * @param iAccess                the access
     */
    @Autowired
    public RequerimientoService(enviarNotificacion simpMessagingTemplate, IProduct iProduct, IRequerimiento iRequerimiento, IDetallesRequerimiento iDetallesRequerimiento, obtenerusuario getUser, transformarFecha fecha, ICodigoProducto iCodigoProducto, IAlmacen iAlmacen, ISalida iSalida, ISalidaDetalles iSalidaDetalles, IAccess iAccess) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.iProduct = iProduct;
        this.iRequerimiento = iRequerimiento;
        this.iDetallesRequerimiento = iDetallesRequerimiento;
        this.getUser = getUser;
        this.fecha = fecha;
        this.iCodigoProducto = iCodigoProducto;
        this.iAlmacen = iAlmacen;
        this.iSalida = iSalida;
        this.iSalidaDetalles = iSalidaDetalles;

        this.iAccess = iAccess;
    }

    /**
     * Crear requerimiento general requerimiento.
     *
     * @param modelo the modelo
     * @param token  the token
     * @return the requerimiento
     */
    @Transactional(rollbackFor = Exception.class)
    public Requerimiento crearRequerimientoGeneral(RequerimientoModel modelo, String token) {

        try {

            User user = this.getUser.getUser(token);
            Almacen almacen = this.iAlmacen.findById(modelo.getIdAlmacen()).orElseThrow(RuntimeException::new);
            User jefe = this.getUser.getJefe(almacen.getIdAlmacen(), token);

            String codigoRequerimiento = this.getCodigoRequerimiento(almacen);


            Requerimiento requerimiento = new Requerimiento(codigoRequerimiento, almacen, almacen, TipoRequerimiento.NECESIDAD,
                    modelo.getFechaEntrega(), modelo.getObservaciones(), user, jefe);

            Requerimiento save = this.iRequerimiento.save(requerimiento);


            List<DetallesRequerimiento> collect = modelo.getDetalles().stream().map(detallesRequerimientoModel -> new DetallesRequerimiento(this.iCodigoProducto.findById(detallesRequerimientoModel.getCodigo()).get(), save, detallesRequerimientoModel.getCantidad())).collect(Collectors.toList());

            List<DetallesRequerimiento> detallesGuardados = this.iDetallesRequerimiento.saveAll(collect);

            RequerimientoDTO requerimientoDTO = new RequerimientoDTO(requerimiento.getCodigoRequerimiento(), requerimiento.getAlmacenRecibe().getIdAlmacen(), requerimiento.getTipoRequerimiento());


            this.sendNotification(requerimientoDTO, 1, token);
            return save;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());

        }


    }

    /**
     * Crear requermiento traslado requerimiento.
     *
     * @param modelo the modelo
     * @param token  the token
     * @return the requerimiento
     */
    @Transactional(rollbackFor = Exception.class)
    public Requerimiento crearRequermientoTraslado(RequerimientoModelTraslado modelo, String token) {


        try {


            User user = this.getUser.getUser(token);
            Almacen almacen = user.getIdAlmacen();


            Almacen almacenEntrega = this.iAlmacen.findById(modelo.getIdAlmacenEnvia()).get();

            User jefeEntrega = this.getUser.getJefe(almacenEntrega.getIdAlmacen(), token);


            String codigoRequerimiento = this.getCodigoRequerimiento(almacen);

            Requerimiento requerimiento = new Requerimiento(codigoRequerimiento, almacen, almacenEntrega, TipoRequerimiento.NOSTOCK,
                    modelo.getFechaEntrega(), modelo.getObservaciones(), user, jefeEntrega);
            Requerimiento save = this.iRequerimiento.save(requerimiento);

            List<DetallesRequerimiento> collect = modelo.getDetalles().stream().map(detallesRequerimientoModel -> new DetallesRequerimiento(this.iCodigoProducto.findById(detallesRequerimientoModel.getCodigo()).get(), save, detallesRequerimientoModel.getCantidad())).collect(Collectors.toList());


            List<DetallesRequerimiento> detallesRequerimientos = this.iDetallesRequerimiento.saveAll(collect);

            return save;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());


        }


    }

    private String getCodigoRequerimiento(Almacen almacen) {

        String codigo = "RIN-" + almacen.getAlmacen().substring(0, 4);

        long l = this.iRequerimiento.countByCodigoRequerimientoStartingWith(codigo);


        return codigo + "-" + l;


    }

    /**
     * Confirmar requerimiento requerimiento.
     *
     * @param token     the token
     * @param codigoReq the codigo req
     * @return the requerimiento
     */
    @Transactional(rollbackFor = Exception.class)
    public Requerimiento confirmarRequerimiento(String token, String codigoReq) {


        try {
/*
            Requerimiento requerimiento = this.iRequerimiento.findById(codigoReq).orElseThrow(RuntimeException::new);

            requerimiento.setEstadoRequerimiento(EstadoRequerimiento.ACEPTADO);

            Requerimiento save = this.iRequerimiento.save(requerimiento);*/
            Requerimiento requerimiento = this.iRequerimiento.findById(codigoReq).orElseThrow(RuntimeException::new);
            requerimiento.setEstadoRequerimiento(EstadoRequerimiento.REVISADO_CONFIRMADO);
            Requerimiento save = this.iRequerimiento.save(requerimiento);
            RequerimientoDTO requerimientoDTO = new RequerimientoDTO(requerimiento.getCodigoRequerimiento(), requerimiento.getAlmacenRecibe().getIdAlmacen(), requerimiento.getTipoRequerimiento());

            this.sendNotification(requerimientoDTO, 2, token);
            return save;


        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Usted no cuenta con estos productos en su almacen");

        }


    }

    /**
     * Confirmar traslado requerimiento.
     *
     * @param token     the token
     * @param codigoReq the codigo req
     * @return the requerimiento
     */
    @Transactional(rollbackFor = Exception.class)
    public Requerimiento confirmarTraslado(String token, String codigoReq) {


        try {


            User user = this.getUser.getUser(token);


            Requerimiento requerimiento = this.iRequerimiento.findById(codigoReq).orElseThrow(RuntimeException::new);


            if (requerimiento.getAlmacenRecibe().getIdAlmacen() == user.getIdAlmacen().getIdAlmacen()) {
                requerimiento.setEstadoRequerimiento(EstadoRequerimiento.ACEPTADO);

                Requerimiento save1 = this.iRequerimiento.save(requerimiento);

                Salida salida = new Salida(
                        null, null, null, estadoMovimiento.ESPERA_CONFIRMACION,
                        null, null, null, null, requerimiento.getAlmacenPide(), requerimiento.getAlmacenRecibe(), null, null);
                salida.setRequerimiento(requerimiento);

                Salida save = this.iSalida.save(salida);
                List<SalidaDetalles> detalles = this.iDetallesRequerimiento.findByIdRequerimiento(requerimiento).stream().map(detallesRequerimiento -> new SalidaDetalles(detallesRequerimiento.getCantidad(), save, detallesRequerimiento.getCodigo(), detallesRequerimiento.getCodigo().getPrecioUnitario())).collect(Collectors.toList());
                List<SalidaDetalles> salidaDetalles = this.iSalidaDetalles.saveAll(detalles);
                RequerimientoDTO requerimientoDTO = new RequerimientoDTO(requerimiento.getCodigoRequerimiento(), requerimiento.getAlmacenRecibe().getIdAlmacen(), requerimiento.getTipoRequerimiento());


                this.sendNotification(requerimientoDTO, 3, token);
                return save1;
            } else {

                throw new RuntimeException("error usted no puede aceptar un requerimiento ajeno");

            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("error usted no puede aceptar un requerimiento ajeno");


        }


    }

    /**
     * Mis requermientos list.
     *
     * @param token the token
     * @return the list
     */
    public List misRequermientos(String token) {

        User user = this.getUser.getUser(token);
        List<Requerimiento> byRequeridoPor = this.iRequerimiento.findByRequeridoPor(user);
        List<RequerimientoModelo> collect1 = byRequeridoPor.stream().map(requerimiento -> {

            RequerimientoModelo req = new RequerimientoModelo(requerimiento.getEstadoRequerimiento().name(),
                    requerimiento.getFechaEmision(), requerimiento.getFechaEntrega(), requerimiento.getObservaciones(),
                    requerimiento.getAlmacenPide().getAlmacen(), requerimiento.getAlmacenRecibe().getAlmacen(), requerimiento.getRequeridoPor().getEmail());


            List<DetallesRequerimientoModelo> collect = requerimiento.getDetallesRequerimientoList().stream().map(detallesRequerimiento -> {


                DetallesRequerimientoModelo et = new DetallesRequerimientoModelo(detallesRequerimiento.getCodigo().getCodigo(), detallesRequerimiento.getCodigo().getDescripcion(), detallesRequerimiento.getCantidad()

                        , detallesRequerimiento.getCodigo().getColor(), detallesRequerimiento.getCodigo().getTalla(), detallesRequerimiento.getCodigo().getModelo(), detallesRequerimiento.getCodigo().getMarca()

                );
                return et;

            }).collect(Collectors.toList());
            req.setDetalles(collect);
            return req;
        }).collect(Collectors.toList());


        return collect1;

    }

    /**
     * Mis peticiones map.
     *
     * @param token the token
     * @return the map
     */
    public Map misPeticiones(String token) {


        User user = this.getUser.getUser(token);
        Almacen almacen = user.getIdAlmacen();


        Map mapa = new HashMap();

        List<RequerimientoQuery> collect1 = this.iRequerimiento.misRequerimientos(almacen).stream().filter(requerimientoQuery -> requerimientoQuery.getEstadoRequerimiento() != EstadoRequerimiento.RECHAZADO).collect(Collectors.toList());
        mapa.put("misreq", collect1);

        List<RequerimientoQuery> collect = this.iRequerimiento.misPeticiones(almacen, TipoRequerimiento.NOSTOCK).stream().filter(requerimientoQuery -> requerimientoQuery.getEstadoRequerimiento() == EstadoRequerimiento.REVISADO_CONFIRMADO).collect(Collectors.toList());


        mapa.put("mispet", collect);


        return mapa;

    }

    /**
     * Detalles requerimiento requerimiento.
     *
     * @param token     the token
     * @param codigoreq the codigoreq
     * @return the requerimiento
     */
    public Requerimiento detallesRequerimiento(String token, String codigoreq) {


        Requerimiento requerimiento = this.iRequerimiento.findById(codigoreq).get();
        return requerimiento;

    }

    /**
     * Rechazar requerimiento boolean.
     *
     * @param codigoReq the codigo req
     * @return the boolean
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean rechazarRequerimiento(String codigoReq) {


        try {
            Requerimiento requerimiento = this.iRequerimiento.findById(codigoReq).orElseThrow(RuntimeException::new);
            if (requerimiento.getEstadoRequerimiento() != EstadoRequerimiento.ESPERA) {
                return false;
            }
            requerimiento.setEstadoRequerimiento(EstadoRequerimiento.RECHAZADO);
            return true;

        } catch (Exception ex) {
            throw new RuntimeException("error al rechazar requerimiento");
        }


    }

    /**
     * Rechazar requerimiento traslado boolean.
     *
     * @param codigoReq the codigo req
     * @return the boolean
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean rechazarRequerimientoTraslado(String codigoReq) {

        try {
            Requerimiento requerimiento = this.iRequerimiento.findById(codigoReq).orElseThrow(RuntimeException::new);
            if (requerimiento.getEstadoRequerimiento() == EstadoRequerimiento.REVISADO_CONFIRMADO && requerimiento.getAlmacenPide().getIdAlmacen() != requerimiento.getAlmacenRecibe().getIdAlmacen()) {
                requerimiento.setEstadoRequerimiento(EstadoRequerimiento.RECHAZADO);
                return true;
            }
            return false;

        } catch (Exception ex) {
            throw new RuntimeException("error al rechazar requerimiento");
        }

    }

    /**
     * Send notification.
     *
     * @param requerimientoDTO the requerimiento dto
     * @param op               the op
     * @param token            the token
     */
    @Async("poolnotification")
    public void sendNotification(RequerimientoDTO requerimientoDTO, int op, String token) {
        this.simpMessagingTemplate.enviarNotificacion(requerimientoDTO, op, token);
    }

    /**
     * Buscar usuarios por requerimiento list.
     *
     * @param codigo the codigo
     * @return the list
     */
    public List<Access> buscarUsuariosPorRequerimiento(String codigo) {

        Requerimiento requerimiento = this.iRequerimiento.findById(codigo).orElseThrow(RuntimeException::new);


        User requeridoPor = requerimiento.getRequeridoPor();

        return this.iAccess.findBySub(requeridoPor.getIdUser());


    }

    /**
     * Buscar requerimiento requerimiento modelo.
     *
     * @param id the id
     * @return the requerimiento modelo
     */
    public RequerimientoModelo buscarRequerimiento(String id) {

        return Arrays.asList(this.iRequerimiento.findById(id).orElseThrow(RuntimeException::new)).

                stream().map(requerimiento -> {

            RequerimientoModelo req = new RequerimientoModelo(requerimiento.getEstadoRequerimiento().name(),
                    requerimiento.getFechaEmision(), requerimiento.getFechaEntrega(), requerimiento.getObservaciones(),
                    requerimiento.getAlmacenPide().getAlmacen(), requerimiento.getAlmacenRecibe().getAlmacen(), requerimiento.getRequeridoPor().getEmail());


            List<DetallesRequerimientoModelo> collect = requerimiento.getDetallesRequerimientoList().stream().map(detallesRequerimiento -> {


                DetallesRequerimientoModelo et = new DetallesRequerimientoModelo(detallesRequerimiento.getCodigo().getCodigo(), detallesRequerimiento.getCodigo().getDescripcion(), detallesRequerimiento.getCantidad()

                        , detallesRequerimiento.getCodigo().getColor(), detallesRequerimiento.getCodigo().getTalla(), detallesRequerimiento.getCodigo().getModelo(), detallesRequerimiento.getCodigo().getMarca()

                );
                return et;

            }).collect(Collectors.toList());
            req.setDetalles(collect);
            return req;
        }).collect(Collectors.toList()).get(0);


    }
}
