package com.argo.product_service.product.application.dto;

import java.math.BigDecimal;

public class createProduct {

    public String codigo;
    public String descripcion;
    public String modelo;
    public String marca;
    public String color;
    public String talla;
    public int tipoProducto;
    public BigDecimal precioUnitarioActualizado;

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public String getTalla() {
        return talla;
    }

    public int getTipoProducto() {
        return tipoProducto;
    }

    public BigDecimal getPrecioUnitarioActualizado() {
        return precioUnitarioActualizado;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public void setPrecioUnitarioActualizado(BigDecimal precioUnitarioActualizado) {
        this.precioUnitarioActualizado = precioUnitarioActualizado;
    }
}
