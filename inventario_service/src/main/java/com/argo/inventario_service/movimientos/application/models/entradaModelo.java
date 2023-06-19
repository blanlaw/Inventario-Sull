package com.argo.inventario_service.movimientos.application.models;

import com.argo.inventario_service.movimientos.domain.enm.estadoMovimiento;

import java.util.Date;

/**
 * The interface Entrada modelo.
 */
public interface entradaModelo {

    /**
     * Gets id entrada.
     *
     * @return the id entrada
     */
    int getIdEntrada();

    /**
     * Gets fecha entrada.
     *
     * @return the fecha entrada
     */
    Date getFechaEntrada();

    /**
     * Gets estado movimiento.
     *
     * @return the estado movimiento
     */
    String getEstadoMovimiento();

    /**
     * Gets tipo comprobante.
     *
     * @return the tipo comprobante
     */
    String getTipoComprobante();

    /**
     * Gets tipo entrada.
     *
     * @return the tipo entrada
     */
    String getTipoEntrada();
}
