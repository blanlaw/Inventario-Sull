package com.argo.product_service.product.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "caracteristicas_producto")
public class features implements Serializable {


    @Id
    private String idProducto;



    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_product",nullable = false)
    @MapsId
    private Product idProduct;

    @Column(name = "modelo", length = 40)
    private String modelo;

    @Column(name = "marca", length = 30)
    private String marca;


    @Column(name = "color", length = 15)
    private String color;

    @Column(name = "talla", length = 10)
    private String talla;

    public features(Product idProduct, String modelo, String marca, String color, String talla) {
        this.idProduct = idProduct;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.talla = talla;
    }

    public features(String idProducto, String modelo, String marca, String color, String talla) {
        this.idProducto = idProducto;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.talla = talla;
    }

    public features(String idProducto, Product idProduct, String modelo, String marca, String color, String talla) {
        this.idProducto = idProducto;
        this.idProduct = idProduct;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.talla = talla;
    }

    public features() {
    }

    public String getIdProducto() {
        return idProducto;
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

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
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

    public void setIdProduct(Product idProduct) {

        this.idProduct = idProduct;


    }

    @Override
    public String toString() {
        return "features{" +
                "idProducto=" + this.getIdProducto() +


                ", modelo='" + this.getModelo() + '\'' +
                ", marca='" + this.getMarca() + '\'' +
                ", color='" + this.getColor() + '\'' +
                ", talla='" + this.getTalla() + '\'' +
                '}';
    }
}
