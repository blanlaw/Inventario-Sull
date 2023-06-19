package com.argo.inventario_service.producto.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The type Detalles orden.
 */
@Entity
public class DetallesOrden implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalles;

    @Column()
    private String codigo_producto;
    @Column()
    private String color;

    @Column()
    private String marca;
    @Column()
    private String modelo;
    @Column()
    private String nombre;

    @Column()
    private String talla;

    @ManyToOne(targetEntity = TipoProducto.class)
    @JoinColumn(name = "tipo_producto")
    private TipoProducto tipoProducto;


    @ManyToOne(targetEntity = OrdenDeCompra.class)
    @JoinColumn
    private OrdenDeCompra idOrden;

    @Column
    private BigDecimal descuento;

    @Column()
    private BigDecimal precioUnitario;

    @Column
    private int cantidad;


    @Column
    private String unidadMedida;

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

    @Transient
    private BigDecimal subTotal;

    /**
     * Instantiates a new Detalles orden.
     */
    public DetallesOrden() {

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
     * Gets descuento.
     *
     * @return the descuento
     */
    public BigDecimal getDescuento() {
        return descuento;
    }

    /**
     * Sets descuento.
     *
     * @param descuento the descuento
     */
    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
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

    /**
     * Gets sub total.
     *
     * @return the sub total
     */
    public BigDecimal getSubTotal() {
        return (this.getPrecioUnitario().multiply(new BigDecimal(this.getCantidad()))).subtract(this.getDescuento());
    }


    /**
     * Gets codigo producto.
     *
     * @return the codigo producto
     */
    public String getCodigo_producto() {
        return codigo_producto;
    }

    /**
     * Sets codigo producto.
     *
     * @param codigo_producto the codigo producto
     */
    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
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
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets nombre.
     *
     * @param nombre the nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * Sets sub total.
     *
     * @param subTotal the sub total
     */
    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * Instantiates a new Detalles orden.
     *
     * @param codigo_producto the codigo producto
     * @param color           the color
     * @param marca           the marca
     * @param modelo          the modelo
     * @param nombre          the nombre
     * @param talla           the talla
     * @param idOrden         the id orden
     * @param descuento       the descuento
     * @param precioUnitario  the precio unitario
     * @param cantidad        the cantidad
     * @param tipo            the tipo
     * @param unidadMedida    the unidad medida
     */
    public DetallesOrden(String codigo_producto, String color, String marca, String modelo, String nombre, String talla, OrdenDeCompra idOrden, BigDecimal descuento, BigDecimal precioUnitario, int cantidad,TipoProducto tipo
        ,String unidadMedida


    ) {
        this.codigo_producto = codigo_producto;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.nombre = nombre;
        this.talla = talla;
        this.idOrden = idOrden;
        this.descuento = descuento;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.tipoProducto=tipo;
        this.unidadMedida=unidadMedida;
    }


    /**
     * Gets tipo producto.
     *
     * @return the tipo producto
     */
    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    /**
     * Sets tipo producto.
     *
     * @param tipoProducto the tipo producto
     */
    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }


}
