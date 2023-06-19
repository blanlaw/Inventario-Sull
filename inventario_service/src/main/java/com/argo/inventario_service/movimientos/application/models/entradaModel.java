package com.argo.inventario_service.movimientos.application.models;

/**
 * The type Entrada model.
 */
public class entradaModel {
    private String observaciones;
    private String tipoComprobante;
    private String valeIngreso;
    private String idUsuarioRecibe;

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
     * Gets tipo comprobante.
     *
     * @return the tipo comprobante
     */
    public String getTipoComprobante() {
        return tipoComprobante;
    }

    /**
     * Sets tipo comprobante.
     *
     * @param tipoComprobante the tipo comprobante
     */
    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    /**
     * Gets vale ingreso.
     *
     * @return the vale ingreso
     */
    public String getValeIngreso() {
        return valeIngreso;
    }

    /**
     * Sets vale ingreso.
     *
     * @param valeIngreso the vale ingreso
     */
    public void setValeIngreso(String valeIngreso) {
        this.valeIngreso = valeIngreso;
    }

    /**
     * Gets id usuario recibe.
     *
     * @return the id usuario recibe
     */
    public String getIdUsuarioRecibe() {
        return idUsuarioRecibe;
    }

    /**
     * Sets id usuario recibe.
     *
     * @param idUsuarioRecibe the id usuario recibe
     */
    public void setIdUsuarioRecibe(String idUsuarioRecibe) {
        this.idUsuarioRecibe = idUsuarioRecibe;
    }
}
