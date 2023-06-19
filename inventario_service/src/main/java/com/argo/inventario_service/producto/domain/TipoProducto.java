package com.argo.inventario_service.producto.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The type Tipo producto.
 */
@Entity(name = "tipo_producto")
public class TipoProducto {

    @Id
    private int idTipo;

    private String tipo;

    /**
     * Gets id tipo.
     *
     * @return the id tipo
     */
    public int getIdTipo() {
        return idTipo;
    }

    /**
     * Sets id tipo.
     *
     * @param idTipo the id tipo
     */
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    /**
     * Gets tipo.
     *
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets tipo.
     *
     * @param tipo the tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
