package com.argo.inventario_service.producto.domain.embd;

import com.argo.inventario_service.movimientos.domain.Entrada;
import com.argo.inventario_service.producto.domain.OrdenDeCompra;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Embd orden entrada.
 */
@Entity(name = "orden_entrada")
public class embdOrdenEntrada implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToOne(targetEntity = OrdenDeCompra.class)
    @JoinColumn
    private OrdenDeCompra idOrden;

    @OneToOne(targetEntity = Entrada.class)
    @JoinColumn
    private Entrada idEntrada;


    /**
     * Instantiates a new Embd orden entrada.
     *
     * @param idOrden   the id orden
     * @param idEntrada the id entrada
     */
    public embdOrdenEntrada(OrdenDeCompra idOrden, Entrada idEntrada) {
        this.idOrden = idOrden;
        this.idEntrada = idEntrada;
    }

    /**
     * Instantiates a new Embd orden entrada.
     */
    public embdOrdenEntrada() {

    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets id orden.
     *
     * @return the id orden
     */
    public OrdenDeCompra getIdOrden() {
        return idOrden;
    }

    /**
     * Sets id orden.
     *
     * @param idOrden the id orden
     */
    public void setIdOrden(OrdenDeCompra idOrden) {
        this.idOrden = idOrden;
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
}
