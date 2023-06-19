package com.argo.inventario_service.movimientos.domain;

import com.argo.inventario_service.producto.domain.CodigoProducto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The type Salida detalles.
 */
@Entity(name = "salida_detalles")
public class SalidaDetalles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalles;

    @Column
    private int cantidad;


    private BigDecimal precioUnitario;

    @JsonIgnore
    @ManyToOne(targetEntity = Salida.class)
    @JoinColumn(name = "id_salida")
    private Salida idSalida;


    @ManyToOne(targetEntity = CodigoProducto.class)
    @JoinColumn(name = "id_producto")
    private CodigoProducto idProducto;

    @Column
    private BigDecimal total;

    /**
     * Gets total.
     *
     * @return the total
     */
    public BigDecimal getTotal() {
        return this.getIdProducto().getPrecioUnitario().multiply(new BigDecimal(this.getCantidad()));
    }


    /**
     * Instantiates a new Salida detalles.
     */
    public SalidaDetalles() {



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
     * Gets id salida.
     *
     * @return the id salida
     */
    public Salida getIdSalida() {
        return idSalida;
    }

    /**
     * Sets id salida.
     *
     * @param idSalida the id salida
     */
    public void setIdSalida(Salida idSalida) {
        this.idSalida = idSalida;
    }

    /**
     * Gets id producto.
     *
     * @return the id producto
     */
    public CodigoProducto getIdProducto() {
        return idProducto;
    }


    /**
     * Sets id producto.
     *
     * @param idProducto the id producto
     */
    public void setIdProducto(CodigoProducto idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Instantiates a new Salida detalles.
     *
     * @param cantidad       the cantidad
     * @param idSalida       the id salida
     * @param idProducto     the id producto
     * @param precioUnitario the precio unitario
     */
    public SalidaDetalles(int cantidad, Salida idSalida, CodigoProducto idProducto,BigDecimal precioUnitario) {
        this.cantidad = cantidad;
        this.idSalida = idSalida;
        this.idProducto = idProducto;
        this.precioUnitario = precioUnitario;
        this.total = this.idProducto.getPrecioUnitario().multiply(new BigDecimal(this.cantidad));
    }

    @Override
    public String toString() {
        return "SalidaDetalles{" +
                "idDetalles=" + idDetalles +
                ", cantidad=" + cantidad +
                ", idSalida=" + idSalida +
                ", idProducto=" + idProducto +
                '}';
    }
}
