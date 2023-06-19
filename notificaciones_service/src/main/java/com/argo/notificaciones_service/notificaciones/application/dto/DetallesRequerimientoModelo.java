package com.argo.notificaciones_service.notificaciones.application.dto;

public class DetallesRequerimientoModelo {
    private String codigo;
    private String descripcion;
    private  int cantidad;

    private String color;
    private String talla;
    private String modelo;
    private String marca;




    public DetallesRequerimientoModelo(String codigo, String descripcion, int cantidad, String color, String talla, String modelo, String marca) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.color = color;
        this.talla = talla;
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    public DetallesRequerimientoModelo() {
    }
}
