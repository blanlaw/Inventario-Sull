package com.argo.product_service.product.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tipo_producto")
public class TypeProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tipo")
    private int idTipo;

    @Column(name="tipo_producto",length = 40)
    private String tipoProducto;


    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    @Override
    public String toString() {
        return "TipoProducto{" +
                "idTipo=" + idTipo +
                ", tipoProducto='" + tipoProducto + '\'' +
                '}';
    }
}
