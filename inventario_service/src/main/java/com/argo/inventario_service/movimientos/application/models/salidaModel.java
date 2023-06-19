package com.argo.inventario_service.movimientos.application.models;

/**
 * The type Salida model.
 */
public class salidaModel {


    /**
     * The Id user entrega.
     */
    public String idUserEntrega;

    private String combustible;
    private String empresa;

    private String eequipo;

    private String placa;
    private String modelo;
    private String valeIngreso;


    /**
     * Gets id user entrega.
     *
     * @return the id user entrega
     */
    public String getIdUserEntrega() {
        return idUserEntrega;
    }

    /**
     * Sets id user entrega.
     *
     * @param idUserEntrega the id user entrega
     */
    public void setIdUserEntrega(String idUserEntrega) {
        this.idUserEntrega = idUserEntrega;
    }

    /**
     * Gets combustible.
     *
     * @return the combustible
     */
    public String getCombustible() {
        return combustible;
    }

    /**
     * Sets combustible.
     *
     * @param combustible the combustible
     */
    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    /**
     * Gets empresa.
     *
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Sets empresa.
     *
     * @param empresa the empresa
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * Gets eequipo.
     *
     * @return the eequipo
     */
    public String getEequipo() {
        return eequipo;
    }

    /**
     * Sets eequipo.
     *
     * @param eequipo the eequipo
     */
    public void setEequipo(String eequipo) {
        this.eequipo = eequipo;
    }

    /**
     * Gets placa.
     *
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Sets placa.
     *
     * @param placa the placa
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * Gets modelo.
     *
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Sets modelo.
     *
     * @param modelo the modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
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
}
