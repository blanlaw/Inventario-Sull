package com.argo.inventario_service.producto.application.models.detalles;

import java.math.BigDecimal;

/**
 * The type Detallesordenmodelo.
 */
public class detallesordenmodelo {
    /**
     * The Id detalles.
     */
    int idDetalles;
    /**
     * The Codigo producto.
     */
    String codigoProducto;
    /**
     * The Nombre.
     */
    String nombre;
    /**
     * The Talla.
     */
    String talla;
    /**
     * The Color.
     */
    String  color;
    /**
     * The Modelo.
     */
    String modelo;
    /**
     * The Marca.
     */
    String marca;
    /**
     * The Id tipo.
     */
    String idTipo;
    /**
     * The Cantidad.
     */
    int cantidad;
    /**
     * The Unidad medida.
     */
    String unidadMedida;
    /**
     * The Precio unitario.
     */
    BigDecimal precioUnitario;
    /**
     * The Descuento.
     */
    BigDecimal descuento;
    /**
     * The Sub total.
     */
    BigDecimal subTotal;

    /**
     * Gets id detalles.
     *
     * @return the id detalles
     */
    public int getIdDetalles() {
        return idDetalles;
    }

    /**
     * Sets id detalles.
     *
     * @param idDetalles the id detalles
     */
    public void setIdDetalles(int idDetalles) {
        this.idDetalles = idDetalles;
    }

    /**
     * Gets codigo producto.
     *
     * @return the codigo producto
     */
    public String getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * Sets codigo producto.
     *
     * @param codigoProducto the codigo producto
     */
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    /**
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets nombre.
     *
     * @param nombre the nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * Gets id tipo.
     *
     * @return the id tipo
     */
    public String getIdTipo() {
        return idTipo;
    }

    /**
     * Sets id tipo.
     *
     * @param idTipo the id tipo
     */
    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
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
     * Gets sub total.
     *
     * @return the sub total
     */
    public BigDecimal getSubTotal() {
        return subTotal;
    }

    /**
     * Sets sub total.
     *
     * @param subTotal the sub total
     */
    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * Instantiates a new Detallesordenmodelo.
     *
     * @param idDetalles     the id detalles
     * @param codigoProducto the codigo producto
     * @param nombre         the nombre
     * @param talla          the talla
     * @param color          the color
     * @param modelo         the modelo
     * @param marca          the marca
     * @param idTipo         the id tipo
     * @param cantidad       the cantidad
     * @param unidadMedida   the unidad medida
     * @param precioUnitario the precio unitario
     * @param descuento      the descuento
     * @param subTotal       the sub total
     */
    public detallesordenmodelo(int idDetalles, String codigoProducto, String nombre, String talla, String color, String modelo, String marca, String idTipo, int cantidad, String unidadMedida, BigDecimal precioUnitario, BigDecimal descuento, BigDecimal subTotal) {
        this.idDetalles = idDetalles;
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.talla = talla;
        this.color = color;
        this.modelo = modelo;
        this.marca = marca;
        this.idTipo = idTipo;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
        this.subTotal = subTotal;
    }
}
