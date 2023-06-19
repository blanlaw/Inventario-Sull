package com.argo.inventario_service.producto.application.models;

import com.argo.inventario_service.producto.domain.enm.moneda;

import java.util.Date;
import java.util.List;

/**
 * The type Orden compra model.
 */
public class ordenCompraModel {



    private String numeroComprobante;
    private detallesProveedorModel proveedor;
    private List<ordenCompraDetallesModel> detalles;
    private Date fechaEntrega;
    private String direccionEntrega;
    private moneda monedas;
    private String condicionPago;
    private String formaPago;
    private String observaciones;
    private int idAlmacen;

    /**
     * Gets id almacen.
     *
     * @return the id almacen
     */
    public int getIdAlmacen() {
        return idAlmacen;
    }

    /**
     * Sets id almacen.
     *
     * @param idAlmacen the id almacen
     */
    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
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
     * Gets proveedor.
     *
     * @return the proveedor
     */
    public detallesProveedorModel getProveedor() {
        return proveedor;
    }

    /**
     * Sets proveedor.
     *
     * @param proveedor the proveedor
     */
    public void setProveedor(detallesProveedorModel proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * Gets detalles.
     *
     * @return the detalles
     */
    public List<ordenCompraDetallesModel> getDetalles() {
        return detalles;
    }

    /**
     * Sets detalles.
     *
     * @param detalles the detalles
     */
    public void setDetalles(List<ordenCompraDetallesModel> detalles) {
        this.detalles = detalles;
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
     * Gets monedas.
     *
     * @return the monedas
     */
    public moneda getMonedas() {
        return monedas;
    }

    /**
     * Sets monedas.
     *
     * @param monedas the monedas
     */
    public void setMonedas(moneda monedas) {
        this.monedas = monedas;
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

}
