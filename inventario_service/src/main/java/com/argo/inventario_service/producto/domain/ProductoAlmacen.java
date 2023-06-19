package com.argo.inventario_service.producto.domain;

import com.argo.inventario_service.producto.domain.embd.embIdProduct;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

/**
 * The type Producto almacen.
 */
@Entity(name = "producto_almacen")
public class ProductoAlmacen {


    @EmbeddedId
    private embIdProduct id;

    @Column
    private int stock;


    /**
     * Gets id.
     *
     * @return the id
     */
    public embIdProduct getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(embIdProduct id) {
        this.id = id;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Instantiates a new Producto almacen.
     *
     * @param id    the id
     * @param stock the stock
     */
    public ProductoAlmacen(embIdProduct id, int stock) {
        this.id = id;
        this.stock = stock;
    }

    /**
     * Instantiates a new Producto almacen.
     */
    public ProductoAlmacen() {
    }

    @Override
    public String toString() {
        return "ProductoAlmacen{" +
                "id=" + id +
                ", stock=" + stock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoAlmacen that = (ProductoAlmacen) o;
        return stock == that.stock &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stock);
    }
}
