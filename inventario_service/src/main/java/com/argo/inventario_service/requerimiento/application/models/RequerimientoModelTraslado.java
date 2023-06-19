package com.argo.inventario_service.requerimiento.application.models;

import java.util.Date;
import java.util.List;

/**
 * The type Requerimiento model traslado.
 */
public class RequerimientoModelTraslado {


    private int idAlmacenEnvia;
    private Date fechaEntrega;
    private String observaciones;


    private List<DetallesRequerimientoModel> detalles;


    /**
     * Gets id almacen envia.
     *
     * @return the id almacen envia
     */
    public int getIdAlmacenEnvia() {
        return idAlmacenEnvia;
    }

    /**
     * Sets id almacen envia.
     *
     * @param idAlmacenEnvia the id almacen envia
     */
    public void setIdAlmacenEnvia(int idAlmacenEnvia) {
        this.idAlmacenEnvia = idAlmacenEnvia;
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
     * Instantiates a new Requerimiento model traslado.
     *
     * @param idAlmacenEnvia the id almacen envia
     * @param fechaEntrega   the fecha entrega
     * @param observaciones  the observaciones
     * @param detalles       the detalles
     */
    public RequerimientoModelTraslado(int idAlmacenEnvia, Date fechaEntrega, String observaciones, List<DetallesRequerimientoModel> detalles) {
        this.idAlmacenEnvia = idAlmacenEnvia;
        this.fechaEntrega = fechaEntrega;
        this.observaciones = observaciones;
        this.detalles = detalles;
    }
}
