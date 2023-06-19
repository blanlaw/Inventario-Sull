package com.argo.inventario_service.requerimiento.application.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * The type Requerimiento model.
 */
public class RequerimientoModel {


    private Date fechaEntrega;
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

    private List<DetallesRequerimientoModel> detalles;


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
     * Gets detalles.
     *
     * @return the detalles
     */
    public List<DetallesRequerimientoModel> getDetalles() {
        return detalles;
    }

    /**
     * Sets detalles.
     *
     * @param detalles the detalles
     */
    public void setDetalles(List<DetallesRequerimientoModel> detalles) {
        this.detalles = detalles;
    }

    /**
     * Instantiates a new Requerimiento model.
     */
    public RequerimientoModel() {
    }

    /**
     * Instantiates a new Requerimiento model.
     *
     * @param fechaEntrega  the fecha entrega
     * @param observaciones the observaciones
     * @param detalles      the detalles
     */
    public RequerimientoModel(Date fechaEntrega, String observaciones, List<DetallesRequerimientoModel> detalles) {
        this.fechaEntrega = fechaEntrega;
        this.observaciones = observaciones;
        this.detalles = detalles;
    }
}
