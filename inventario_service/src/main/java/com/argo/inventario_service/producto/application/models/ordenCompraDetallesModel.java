package com.argo.inventario_service.producto.application.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * The type Orden compra detalles model.
 */
public class ordenCompraDetallesModel {

    @JsonProperty(required = false)
    private String codigo;


    @JsonProperty(required = false)
    private int tipo;

    private String color;
    private String marca;
    private String modelo;
    private String descripcion;
    private String talla;
    private String unidadMedida;
    private BigDecimal precioUnitario;
    private BigDecimal descuento;
    private int cantidad;

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
     * Gets tipo.
     *
     * @return the tipo
     */
    @JsonProperty(required = false)
    public int getTipo() {
        return tipo;
    }

    /**
     * Sets tipo.
     *
     * @param tipo the tipo
     */
    @JsonProperty(required = false)
    public void setTipo(int tipo) {
        this.tipo = tipo;
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
     * Gets codigo.
     *
     * @return the codigo
     */
    @JsonProperty(required = false)
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets codigo.
     *
     * @param codigo the codigo
     */
    @JsonProperty(required = false)
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets precio unitario.
     *
     * @return the precio unitario
     */
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Sets precio unitario.
     *
     * @param precioUnitario the precio unitario
     */
    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * Gets descuento.
     *
     * @return the descuento
     */
    public BigDecimal getDescuento() {
        return descuento;
    }

    /**
     * Sets descuento.
     *
     * @param descuento the descuento
     */
    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
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
}
