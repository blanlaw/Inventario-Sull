package com.argo.product_service.product.application.dto;

import java.math.BigDecimal;

public class updateProduct {

    public String descripcion;
    public String modelo;
    public String marca;
    public String color;
    public String talla;
    public int tipoProducto;
    public BigDecimal precioUnitarioActualizado;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public int getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public BigDecimal getPrecioUnitarioActualizado() {
        return precioUnitarioActualizado;
    }

    public void setPrecioUnitarioActualizado(BigDecimal precioUnitarioActualizado) {
        this.precioUnitarioActualizado = precioUnitarioActualizado;
    }
}
