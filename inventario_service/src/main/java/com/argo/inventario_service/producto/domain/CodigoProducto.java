package com.argo.inventario_service.producto.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * The type Codigo producto.
 */
@Entity(name = "lista_productos")
public class CodigoProducto {


    @Id
    private String codigo;


    @Column
    private String descripcion;

    @Column
    private String modelo;

    @Column
    private String marca;

    @Column
    private String color;

    @Column
    private String talla;

    @ManyToOne(targetEntity = TipoProducto.class)
    @JoinColumn(name = "id_tipo")
    private TipoProducto tipo;


    @Column
    private BigDecimal precioUnitario;

    @Column
    private String unidadMedida;

    /**
     * Instantiates a new Codigo producto.
     *
     * @param codigo         the codigo
     * @param descripcion    the descripcion
     * @param modelo         the modelo
     * @param marca          the marca
     * @param color          the color
     * @param talla          the talla
     * @param tipo           the tipo
     * @param precioUnitario the precio unitario
     * @param unidadMedida   the unidad medida
     */
    public CodigoProducto(String codigo, String descripcion, String modelo, String marca, String color, String talla, TipoProducto tipo, BigDecimal precioUnitario, String unidadMedida) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.talla = talla;
        this.tipo = tipo;
        this.precioUnitario = precioUnitario;
        this.unidadMedida = unidadMedida;
    }

    /**
     * Instantiates a new Codigo producto.
     */
    public CodigoProducto() {

    }

    /**
     * Gets unidad medida.
     *
     * @return the unidad medida
     */
    public String getUnidadMedida() {
        return unidadMedida;
    }

    /**
     * Sets unidad medida.
     *
     * @param unidadMedida the unidad medida
     */
    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    /**
     * Gets codigo.
     *
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets codigo.
     *
     * @param codigo the codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Gets descripcion.
     *
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets descripcion.
     *
     * @param descripcion the descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Gets modelo.
     *
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Sets modelo.
     *
     * @param modelo the modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Gets marca.
     *
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Sets marca.
     *
     * @param marca the marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets talla.
     *
     * @return the talla
     */
    public String getTalla() {
        return talla;
    }

    /**
     * Sets talla.
     *
     * @param talla the talla
     */
    public void setTalla(String talla) {
        this.talla = talla;
    }

    /**
     * Gets tipo.
     *
     * @return the tipo
     */
    public TipoProducto getTipo() {
        return tipo;
    }

    /**
     * Sets tipo.
     *
     * @param idTipo the id tipo
     */
    public void setTipo(TipoProducto idTipo) {
        this.tipo = idTipo;
    }

    /**
     * Gets precio unitario.
     *
     * @return the precio unitario
     */
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Sets precio unitario.
     *
     * @param precioUnitario the precio unitario
     */
    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "CodigoProducto{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", talla='" + talla + '\'' +
                ", tipo=" + tipo +
                ", precioUnitario=" + precioUnitario +
                ", unidadMedida='" + unidadMedida + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodigoProducto that = (CodigoProducto) o;
        return Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(modelo, that.modelo) &&
                Objects.equals(marca, that.marca) &&
                Objects.equals(color, that.color) &&
                Objects.equals(talla, that.talla) &&
                Objects.equals(tipo, that.tipo) &&

                Objects.equals(unidadMedida, that.unidadMedida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion, modelo, marca, color, talla, tipo, precioUnitario, unidadMedida);
    }
}
