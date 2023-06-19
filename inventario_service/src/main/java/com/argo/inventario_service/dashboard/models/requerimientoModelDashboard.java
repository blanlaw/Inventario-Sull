package com.argo.inventario_service.dashboard.models;

import java.util.Date;

/**
 * The interface Requerimiento model dashboard.
 */
public interface requerimientoModelDashboard {


    /**
     * Gets codigo.
     *
     * @return the codigo
     */
    String getCodigo();

    /**
     * Gets fecha emision.
     *
     * @return the fecha emision
     */
    Date getFechaEmision();

    /**
     * Gets almacen requiere.
     *
     * @return the almacen requiere
     */
    String getAlmacenRequiere();
}
