package com.argo.inventario_service.producto.application.models.detalles;

import com.argo.inventario_service.producto.domain.enm.moneda;
import com.argo.inventario_service.requerimiento.domain.enm.EstadoRequerimiento;

import java.util.Date;
import java.util.List;

/**
 * The type Orden compramodelo detalles.
 */
public class ordenCompramodeloDetalles {


    /**
     * The Codigo.
     */
    String codigo;
    /**
     * The Condicion pago.
     */
    String condicionPago;
    /**
     * The Correo.
     */
    String correo;
    /**
     * The Direccion entrega.
     */
    String direccionEntrega;
    /**
     * The Estado orden.
     */
    EstadoRequerimiento estadoOrden;
    /**
     * The Fecha entrega.
     */
    Date fechaEntrega;
    /**
     * The Fecha orden.
     */
    Date fechaOrden;
    /**
     * The Moneda.
     */
    moneda moneda;
    /**
     * The Proveedor.
     */
    String proveedor;
    /**
     * The Numero comprobante.
     */
    String numeroComprobante;
    /**
     * The Observaciones.
     */
    String observaciones;
    /**
     * The Telefono.
     */
    String  telefono;
    /**
     * The Ruc.
     */
    String ruc;
    /**
     * The Almacen.
     */
    String almacen;
    /**
     * The Codigo requerimiento.
     */
    String codigoRequerimiento;
    /**
     * The Usuario emite.
     */
    String usuarioEmite;
    /**
     * The Direccion.
     */
    String direccion;
    /**
     * The Forma pago.
     */
    String formaPago;
    /**
     * The Detalles.
     */
    List<detallesordenmodelo> detalles;

    /**
     * Instantiates a new Orden compramodelo detalles.
     *
     * @param codigo              the codigo
     * @param condicionPago       the condicion pago
     * @param correo              the correo
     * @param direccionEntrega    the direccion entrega
     * @param estadoOrden         the estado orden
     * @param fechaEntrega        the fecha entrega
     * @param fechaOrden          the fecha orden
     * @param moneda              the moneda
     * @param proveedor           the proveedor
     * @param numeroComprobante   the numero comprobante
     * @param observaciones       the observaciones
     * @param telefono            the telefono
     * @param ruc                 the ruc
     * @param almacen             the almacen
     * @param codigoRequerimiento the codigo requerimiento
     * @param usuarioEmite        the usuario emite
     * @param direccion           the direccion
     * @param formaPago           the forma pago
     */
    public ordenCompramodeloDetalles(String codigo, String condicionPago, String correo, String direccionEntrega, EstadoRequerimiento estadoOrden, Date fechaEntrega, Date fechaOrden, com.argo.inventario_service.producto.domain.enm.moneda moneda, String proveedor, String numeroComprobante, String observaciones, String telefono, String ruc, String almacen, String codigoRequerimiento, String usuarioEmite, String direccion, String formaPago) {
        this.codigo = codigo;
        this.condicionPago = condicionPago;
        this.correo = correo;
        this.direccionEntrega = direccionEntrega;
        this.estadoOrden = estadoOrden;
        this.fechaEntrega = fechaEntrega;
        this.fechaOrden = fechaOrden;
        this.moneda = moneda;
        this.proveedor = proveedor;
        this.numeroComprobante = numeroComprobante;
        this.observaciones = observaciones;
        this.telefono = telefono;
        this.ruc = ruc;
        this.almacen = almacen;
        this.codigoRequerimiento = codigoRequerimiento;
        this.usuarioEmite = usuarioEmite;
        this.direccion = direccion;
        this.formaPago = formaPago;
    }

    /**
     * Gets codigo.
     *
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets codigo.
     *
     * @param codigo the codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Gets condicion pago.
     *
     * @return the condicion pago
     */
    public String getCondicionPago() {
        return condicionPago;
    }

    /**
     * Sets condicion pago.
     *
     * @param condicionPago the condicion pago
     */
    public void setCondicionPago(String condicionPago) {
        this.condicionPago = condicionPago;
    }

    /**
     * Gets correo.
     *
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Sets correo.
     *
     * @param correo the correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Gets direccion entrega.
     *
     * @return the direccion entrega
     */
    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    /**
     * Sets direccion entrega.
     *
     * @param direccionEntrega the direccion entrega
     */
    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    /**
     * Gets estado orden.
     *
     * @return the estado orden
     */
    public EstadoRequerimiento getEstadoOrden() {
        return estadoOrden;
    }

    /**
     * Sets estado orden.
     *
     * @param estadoOrden the estado orden
     */
    public void setEstadoOrden(EstadoRequerimiento estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

    /**
     * Gets fecha entrega.
     *
     * @return the fecha entrega
     */
    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * Sets fecha entrega.
     *
     * @param fechaEntrega the fecha entrega
     */
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    /**
     * Gets fecha orden.
     *
     * @return the fecha orden
     */
    public Date getFechaOrden() {
        return fechaOrden;
    }

    /**
     * Sets fecha orden.
     *
     * @param fechaOrden the fecha orden
     */
    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    /**
     * Gets moneda.
     *
     * @return the moneda
     */
    public com.argo.inventario_service.producto.domain.enm.moneda getMoneda() {
        return moneda;
    }

    /**
     * Sets moneda.
     *
     * @param moneda the moneda
     */
    public void setMoneda(com.argo.inventario_service.producto.domain.enm.moneda moneda) {
        this.moneda = moneda;
    }

    /**
     * Gets proveedor.
     *
     * @return the proveedor
     */
    public String getProveedor() {
        return proveedor;
    }

    /**
     * Sets proveedor.
     *
     * @param proveedor the proveedor
     */
    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * Gets numero comprobante.
     *
     * @return the numero comprobante
     */
    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    /**
     * Sets numero comprobante.
     *
     * @param numeroComprobante the numero comprobante
     */
    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    /**
     * Gets observaciones.
     *
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Sets observaciones.
     *
     * @param observaciones the observaciones
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Gets telefono.
     *
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Sets telefono.
     *
     * @param telefono the telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Gets ruc.
     *
     * @return the ruc
     */
    public String getRuc() {
        return ruc;
    }

    /**
     * Sets ruc.
     *
     * @param ruc the ruc
     */
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    /**
     * Gets almacen.
     *
     * @return the almacen
     */
    public String getAlmacen() {
        return almacen;
    }

    /**
     * Sets almacen.
     *
     * @param almacen the almacen
     */
    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    /**
     * Gets codigo requerimiento.
     *
     * @return the codigo requerimiento
     */
    public String getCodigoRequerimiento() {
        return codigoRequerimiento;
    }

    /**
     * Sets codigo requerimiento.
     *
     * @param codigoRequerimiento the codigo requerimiento
     */
    public void setCodigoRequerimiento(String codigoRequerimiento) {
        this.codigoRequerimiento = codigoRequerimiento;
    }

    /**
     * Gets usuario emite.
     *
     * @return the usuario emite
     */
    public String getUsuarioEmite() {
        return usuarioEmite;
    }

    /**
     * Sets usuario emite.
     *
     * @param usuarioEmite the usuario emite
     */
    public void setUsuarioEmite(String usuarioEmite) {
        this.usuarioEmite = usuarioEmite;
    }

    /**
     * Gets direccion.
     *
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Sets direccion.
     *
     * @param direccion the direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Gets forma pago.
     *
     * @return the forma pago
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Sets forma pago.
     *
     * @param formaPago the forma pago
     */
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * Gets detalles.
     *
     * @return the detalles
     */
    public List<detallesordenmodelo> getDetalles() {
        return detalles;
    }

    /**
     * Sets detalles.
     *
     * @param detalles the detalles
     */
    public void setDetalles(List<detallesordenmodelo> detalles) {
        this.detalles = detalles;
    }
}
