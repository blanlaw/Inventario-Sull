package com.argo.product_service.product.application.dto;

import java.math.BigDecimal;

public interface findProduct {


    public String getCodigo();

    public String getDescripcion();

    public String getModelo() ;

    public String getColor() ;

    public String getMarca() ;

    public String getTalla() ;

    public typeProduct getTipo();

    public BigDecimal getPrecio();
}
