package com.argo.inventario_service.requerimiento.application.models;

/**
 * The type Detalles requerimiento modelo.
 */
public class DetallesRequerimientoModelo {


    private String codigo;
    private String descripcion;
    private  int cantidad;

    private String color;
    private String talla;
    private String modelo;
    private String marca;

    /**
     * Instantiates a new Detalles requerimiento modelo.
     *
     * @param codigo      the codigo
     * @param descripcion the descripcion
     * @param cantidad    the cantidad
     * @param color       the color
     * @param talla       the talla
     * @param modelo      the modelo
     * @param marca       the marca
     */
    public DetallesRequerimientoModelo(String codigo, String descripcion, int cantidad, String color, String talla, String modelo, String marca) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.color = color;
        this.talla = talla;
        this.modelo = modelo;
        this.marca = marca;
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
     * Gets codigo.
     *
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets codigo.
     *
     * @param codigo the codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * Gets cantidad.
     *
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }
}
