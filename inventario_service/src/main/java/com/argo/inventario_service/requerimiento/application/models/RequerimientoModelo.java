package com.argo.inventario_service.requerimiento.application.models;

import java.util.Date;
import java.util.List;

/**
 * The type Requerimiento modelo.
 */
public class RequerimientoModelo {

    private String estado;
    private Date fechaEmision;
    private Date fechaEntrega;
    private String observaciones;
    private String almacenPideRequerimiento;
    private String almacenRecibeRequerimiento;
    private String requeridoPor;
    private List<DetallesRequerimientoModelo> detalles;


    /**
     * Instantiates a new Requerimiento modelo.
     *
     * @param estado                     the estado
     * @param fechaEmision               the fecha emision
     * @param fechaEntrega               the fecha entrega
     * @param observaciones              the observaciones
     * @param almacenPideRequerimiento   the almacen pide requerimiento
     * @param almacenRecibeRequerimiento the almacen recibe requerimiento
     * @param requeridoPor               the requerido por
     */
    public RequerimientoModelo(String estado, Date fechaEmision, Date fechaEntrega, String observaciones, String almacenPideRequerimiento, String almacenRecibeRequerimiento, String requeridoPor) {
        this.estado = estado;
        this.fechaEmision = fechaEmision;
        this.fechaEntrega = fechaEntrega;
        this.observaciones = observaciones;
        this.almacenPideRequerimiento = almacenPideRequerimiento;
        this.almacenRecibeRequerimiento = almacenRecibeRequerimiento;
        this.requeridoPor = requeridoPor;
    }

    /**
     * Gets detalles.
     *
     * @return the detalles
     */
    public List<DetallesRequerimientoModelo> getDetalles() {
        return detalles;
    }

    /**
     * Sets detalles.
     *
     * @param detalles the detalles
     */
    public void setDetalles(List<DetallesRequerimientoModelo> detalles) {
        this.detalles = detalles;
    }

    /**
     * Gets estado.
     *
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets estado.
     *
     * @param estado the estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Gets fecha emision.
     *
     * @return the fecha emision
     */
    public Date getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Sets fecha emision.
     *
     * @param fechaEmision the fecha emision
     */
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
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
     * Gets almacen pide requerimiento.
     *
     * @return the almacen pide requerimiento
     */
    public String getAlmacenPideRequerimiento() {
        return almacenPideRequerimiento;
    }

    /**
     * Sets almacen pide requerimiento.
     *
     * @param almacenPideRequerimiento the almacen pide requerimiento
     */
    public void setAlmacenPideRequerimiento(String almacenPideRequerimiento) {
        this.almacenPideRequerimiento = almacenPideRequerimiento;
    }

    /**
     * Gets almacen recibe requerimiento.
     *
     * @return the almacen recibe requerimiento
     */
    public String getAlmacenRecibeRequerimiento() {
        return almacenRecibeRequerimiento;
    }

    /**
     * Sets almacen recibe requerimiento.
     *
     * @param almacenRecibeRequerimiento the almacen recibe requerimiento
     */
    public void setAlmacenRecibeRequerimiento(String almacenRecibeRequerimiento) {
        this.almacenRecibeRequerimiento = almacenRecibeRequerimiento;
    }

    /**
     * Gets requerido por.
     *
     * @return the requerido por
     */
    public String getRequeridoPor() {
        return requeridoPor;
    }

    /**
     * Sets requerido por.
     *
     * @param requeridoPor the requerido por
     */
    public void setRequeridoPor(String requeridoPor) {
        this.requeridoPor = requeridoPor;
    }
}
