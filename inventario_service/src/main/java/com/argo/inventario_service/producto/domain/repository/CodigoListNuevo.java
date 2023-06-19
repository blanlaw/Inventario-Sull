package com.argo.inventario_service.producto.domain.repository;

import java.math.BigDecimal;

/**
 * The interface Codigo list nuevo.
 */
public interface CodigoListNuevo {

    /**
     * Gets codigo.
     *
     * @return the codigo
     */
    String getCodigo();


    /**
     * Gets descripcion.
     *
     * @return the descripcion
     */
    String getDescripcion();


    /**
     * Gets modelo.
     *
     * @return the modelo
     */
    String getModelo();


    /**
     * Gets marca.
     *
     * @return the marca
     */
    String getMarca();


    /**
     * Gets color.
     *
     * @return the color
     */
    String getColor();


    /**
     * Gets talla.
     *
     * @return the talla
     */
    String getTalla();


    /**
     * Gets tipo.
     *
     * @return the tipo
     */
    String getTipo();

    /**
     * Gets precio.
     *
     * @return the precio
     */
    BigDecimal getPrecio();

    /**
     * Gets cantidad.
     *
     * @return the cantidad
     */
    int getCantidad();
}
