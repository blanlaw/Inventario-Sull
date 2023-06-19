package com.argo.inventario_service.producto.infrastructure.api;

import java.math.BigDecimal;

/**
 * The type Precio modelo.
 */
public class precioModelo {

    /**
     * The Precio.
     */
    BigDecimal precio;

    /**
     * Gets precio.
     *
     * @return the precio
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * Sets precio.
     *
     * @param precio the precio
     */
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
