package com.argo.inventario_service.requerimiento.application.models;

import com.argo.inventario_service.requerimiento.domain.enm.EstadoRequerimiento;
import com.argo.inventario_service.requerimiento.domain.enm.TipoRequerimiento;

import java.util.Date;

/**
 * The interface Requerimiento query.
 */
public interface RequerimientoQuery {

    /**
     * Gets codigo.
     *
     * @return the codigo
     */
    String getCodigo();

    /**
     * Gets remitente.
     *
     * @return the remitente
     */
    String getRemitente();

    /**
     * Gets fecha emision.
     *
     * @return the fecha emision
     */
    Date getFechaEmision();

    /**
     * Gets tipo requerimiento.
     *
     * @return the tipo requerimiento
     */
    TipoRequerimiento getTipoRequerimiento();

    /**
     * Gets estado requerimiento.
     *
     * @return the estado requerimiento
     */
    EstadoRequerimiento getEstadoRequerimiento();

    /**
     * Gets empleado.
     *
     * @return the empleado
     */
    String getEmpleado();
}
