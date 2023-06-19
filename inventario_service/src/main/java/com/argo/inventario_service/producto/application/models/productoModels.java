package com.argo.inventario_service.producto.application.models;

import java.math.BigDecimal;

/**
 * The interface Producto models.
 */
public interface productoModels {


    /**
     * Gets codigo.
     *
     * @return the codigo
     */
    String getCodigo();

    /**
     * Gets nombre.
     *
     * @return the nombre
     */
    String getNombre();

    /**
     * Gets precio unitario.
     *
     * @return the precio unitario
     */
    BigDecimal getPrecioUnitario();

    /**
     * Gets cantidad.
     *
     * @return the cantidad
     */
    int getCantidad();
}
