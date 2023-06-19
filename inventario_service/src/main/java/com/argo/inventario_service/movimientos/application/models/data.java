package com.argo.inventario_service.movimientos.application.models;

import java.math.BigDecimal;

/**
 * The type Data.
 */
public class data{

    private String descripcion;
    private String talla;
    private String marca;
    private String color;
    private String modelo;
    private String unidadMedida;
    private int cantidad;
    private BigDecimal total;

    /**
     * Instantiates a new Data.
     *
     * @param descripcion  the descripcion
     * @param talla        the talla
     * @param marca        the marca
     * @param color        the color
     * @param modelo       the modelo
     * @param unidadMedida the unidad medida
     * @param cantidad     the cantidad
     * @param total        the total
     */
    public data(String descripcion, String talla, String marca, String color, String modelo, String unidadMedida, int cantidad, BigDecimal total) {
        this.descripcion = descripcion;
        this.talla = talla;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.unidadMedida = unidadMedida;
        this.cantidad = cantidad;
        this.total = total;
    }

    /**
     * Gets descripcion.
     *
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets descripcion.
     *
     * @param descripcion the descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Gets talla.
     *
     * @return the talla
     */
    public String getTalla() {
        return talla;
    }

    /**
     * Sets talla.
     *
     * @param talla the talla
     */
    public void setTalla(String talla) {
        this.talla = talla;
    }

    /**
     * Gets marca.
     *
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Sets marca.
     *
     * @param marca the marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(String color) {
        this.color = color;
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
     * Gets unidad medida.
     *
     * @return the unidad medida
     */
    public String getUnidadMedida() {
        return unidadMedida;
    }

    /**
     * Sets unidad medida.
     *
     * @param unidadMedida the unidad medida
     */
    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    /**
     * Gets cantidad.
     *
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Sets cantidad.
     *
     * @param cantidad the cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Gets total.
     *
     * @return the total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Sets total.
     *
     * @param total the total
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
