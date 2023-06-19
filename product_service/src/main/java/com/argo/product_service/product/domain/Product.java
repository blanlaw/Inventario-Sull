package com.argo.product_service.product.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name = "producto")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product implements Serializable {


    @Id
    @Column(name = "codigo",nullable = false,length = 20,unique = true)
    private String codigo;

    @Column(name="producto",length = 100,nullable = false)
    private String producto;

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Column(name = "descripcion", length = 100,nullable = false)
    private String descripcion;


    @OneToOne(fetch = FetchType.LAZY,mappedBy = "idProduct",cascade = CascadeType.ALL)
    private features idFeatures;
    @ManyToOne(targetEntity = TypeProduct.class)
    @JoinColumn(name = "id_tipo_producto",nullable = false)
    private TypeProduct idTypeProduct;
    @Column(name = "precio_unitario",nullable = false)
    private BigDecimal precioUnitario;



    public Product() {
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


    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public features getIdFeatures() {
        return idFeatures;
    }

    public TypeProduct getIdTypeProduct() {
        return idTypeProduct;
    }

    public void setIdTypeProduct(TypeProduct idTypeProduct) {
        this.idTypeProduct = idTypeProduct;
    }

    public void setIdFeatures(features idFeatures) {

        this.idFeatures = idFeatures;


    }


}
