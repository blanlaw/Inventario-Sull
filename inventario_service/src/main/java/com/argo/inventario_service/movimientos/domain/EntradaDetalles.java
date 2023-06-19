package com.argo.inventario_service.movimientos.domain;

import com.argo.inventario_service.producto.domain.CodigoProducto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The type Entrada detalles.
 */
@Entity(name = "entrada_detalles")
public class EntradaDetalles {

    /**
     * The Id product.
     */
    @ManyToOne(targetEntity = CodigoProducto.class)
    @JoinColumn(name = "id_product")
    CodigoProducto idProduct;

    private BigDecimal precioUnitario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalles;
    @Column
    private int cantidad;

    @JsonIgnore
    @ManyToOne(targetEntity = Entrada.class)
    @JoinColumn(name = "id_entrada")
    private Entrada idEntrada;


    @Column
    private BigDecimal total;

    /**
     * Instantiates a new Entrada detalles.
     */
    public EntradaDetalles() {

    }

    /**
     * Instantiates a new Entrada detalles.
     *
     * @param idProduct      the id product
     * @param cantidad       the cantidad
     * @param idEntrada      the id entrada
     * @param precioUnitario the precio unitario
     */
    public EntradaDetalles(CodigoProducto idProduct, int cantidad, Entrada idEntrada, BigDecimal precioUnitario) {
        this.idProduct = idProduct;
        this.cantidad = cantidad;
        this.idEntrada = idEntrada;
        this.precioUnitario = precioUnitario;
        this.total = this.idProduct.getPrecioUnitario().multiply(new BigDecimal(this.cantidad));
    }

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
     * Gets id entrada.
     *
     * @return the id entrada
     */
    public Entrada getIdEntrada() {
        return idEntrada;
    }

    /**
     * Sets id entrada.
     *
     * @param idEntrada the id entrada
     */
    public void setIdEntrada(Entrada idEntrada) {
        this.idEntrada = idEntrada;
    }

    /**
     * Gets id product.
     *
     * @return the id product
     */
    public CodigoProducto getIdProduct() {
        return idProduct;
    }

    /**
     * Sets id product.
     *
     * @param idProduct the id product
     */
    public void setIdProduct(CodigoProducto idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * Gets total.
     *
     * @return the total
     */
    public BigDecimal getTotal() {


        return this.getIdProduct().getPrecioUnitario().multiply(new BigDecimal(this.getCantidad()));


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
}
