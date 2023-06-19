package com.argo.inventario_service.requerimiento.domain;

import com.argo.inventario_service.producto.domain.CodigoProducto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Detalles requerimiento.
 */
@Entity(name = "detalles_requerimiento")
public class DetallesRequerimiento implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalle;

    @ManyToOne(targetEntity = CodigoProducto.class)
    @JoinColumn()
    private  CodigoProducto codigo;

    @JsonIgnore
    @ManyToOne(targetEntity = Requerimiento.class)
    @JoinColumn()
    private  Requerimiento idRequerimiento;


    @Column
    private  int cantidad;

    /**
     * Instantiates a new Detalles requerimiento.
     *
     * @param codigo          the codigo
     * @param idRequerimiento the id requerimiento
     * @param cantidad        the cantidad
     */
    public DetallesRequerimiento(CodigoProducto codigo, Requerimiento idRequerimiento, int cantidad) {
        this.codigo = codigo;
        this.idRequerimiento = idRequerimiento;
        this.cantidad = cantidad;
    }

    /**
     * Instantiates a new Detalles requerimiento.
     */
    public DetallesRequerimiento() {

    }

    /**
     * Gets id detalle.
     *
     * @return the id detalle
     */
    public int getIdDetalle() {
        return idDetalle;
    }

    /**
     * Sets id detalle.
     *
     * @param idDetalle the id detalle
     */
    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    /**
     * Gets codigo.
     *
     * @return the codigo
     */
    public CodigoProducto getCodigo() {
        return codigo;
    }

    /**
     * Gets id requerimiento.
     *
     * @return the id requerimiento
     */
    public Requerimiento getIdRequerimiento() {
        return idRequerimiento;
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
