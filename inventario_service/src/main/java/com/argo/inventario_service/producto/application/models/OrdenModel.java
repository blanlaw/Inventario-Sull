package com.argo.inventario_service.producto.application.models;

import com.argo.inventario_service.requerimiento.domain.enm.EstadoRequerimiento;

import java.util.Date;

/**
 * The interface Orden model.
 */
public interface OrdenModel {


    /**
     * Gets codigo.
     *
     * @return the codigo
     */
    String getCodigo();

    /**
     * Gets fecha orden.
     *
     * @return the fecha orden
     */
    Date getFechaOrden();

    /**
     * Gets estado orden.
     *
     * @return the estado orden
     */
    EstadoRequerimiento getEstadoOrden();

    /**
     * Gets proveedor.
     *
     * @return the proveedor
     */
    String getProveedor();


}
