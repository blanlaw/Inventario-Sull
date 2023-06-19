package com.argo.inventario_service.reporte.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The type Detalles reporte modelo.
 */
public class DetallesReporteModelo {

    /**
     * The Codigo.
     */
    String codigo;
    /**
     * The Descripcion.
     */
    String descripcion;
    /**
     * The Modelo.
     */
    String modelo;
    /**
     * The Marca.
     */
    String marca;
    /**
     * The Color.
     */
    String color;
    /**
     * The Talla.
     */
    String talla;
    /**
     * The Tipo.
     */
    String tipo;
    /**
     * The Unidad medida.
     */
    String unidadMedida;
    /**
     * The Entrada.
     */
    int entrada;
    /**
     * The Salidas.
     */
    int salidas;
    /**
     * The Stock.
     */
    int stock;
    /**
     * The Suma totales.
     */
    BigDecimal sumaTotales;

    /**
     * The Mes.
     */
    String mes="";

    /**
     * The Logo.
     */
    String logo="C:\\Users\\loser\\Downloads\\sull\\logo.jpg";

    /**
     * The Precio unitario kardex.
     */
    BigDecimal precioUnitarioKardex;
    /**
     * The Existencias entradas.
     */
    BigDecimal existenciasEntradas;
    /**
     * The Existencias salidas.
     */
    BigDecimal existenciasSalidas;
    /**
     * The Total existencias.
     */
    BigDecimal totalExistencias;

    /**
     * Instantiates a new Detalles reporte modelo.
     *
     * @param codigo               the codigo
     * @param descripcion          the descripcion
     * @param modelo               the modelo
     * @param marca                the marca
     * @param color                the color
     * @param talla                the talla
     * @param tipo                 the tipo
     * @param unidadMedida         the unidad medida
     * @param entrada              the entrada
     * @param salidas              the salidas
     * @param stock                the stock
     * @param sumaTotales          the suma totales
     * @param precioUnitarioKardex the precio unitario kardex
     * @param existenciasEntradas  the existencias entradas
     * @param existenciasSalidas   the existencias salidas
     * @param totalExistencias     the total existencias
     */
    public DetallesReporteModelo(String codigo, String descripcion, String modelo, String marca, String color, String talla, String tipo, String unidadMedida, int entrada, int salidas, int stock, BigDecimal sumaTotales, BigDecimal precioUnitarioKardex, BigDecimal existenciasEntradas, BigDecimal existenciasSalidas, BigDecimal totalExistencias) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.talla = talla;
        this.tipo = tipo;
        this.unidadMedida = unidadMedida;
        this.entrada = entrada;
        this.salidas = salidas;
        this.stock = stock;
        this.sumaTotales = sumaTotales;
        this.precioUnitarioKardex = precioUnitarioKardex;
        this.existenciasEntradas = existenciasEntradas;
        this.existenciasSalidas = existenciasSalidas;
        this.totalExistencias = totalExistencias;
        this.mes=this.buscarMes();
    }

    /**
     * Instantiates a new Detalles reporte modelo.
     */
    public DetallesReporteModelo() {

        this.mes=this.buscarMes();

    }
    private String buscarMes(){

        String mesencontrado="";
        int month = new Date().getMonth();
        switch (month){

            case 0: mesencontrado="ENERO"; break;
            case 1: mesencontrado="FEBRERO"; break;
            case 2: mesencontrado="MARZO"; break;
            case 3: mesencontrado="ABRIL"; break;
            case 4: mesencontrado="MAYO"; break;
            case 5: mesencontrado="JUNIO"; break;
            case 6: mesencontrado="JULIO"; break;
            case 7: mesencontrado="AGOSTO"; break;
            case 8: mesencontrado="SETIEMBRE"; break;
            case 9: mesencontrado="OCTUBRE"; break;
            case 10: mesencontrado="NOVIEMBRE"; break;
            case 11: mesencontrado="DICIEMBRE"; break;

        }

        return mesencontrado;


    }

    /**
     * Gets logo.
     *
     * @return the logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * Sets logo.
     *
     * @param logo the logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
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
     * Gets entrada.
     *
     * @return the entrada
     */
    public int getEntrada() {
        return entrada;
    }

    /**
     * Sets entrada.
     *
     * @param entrada the entrada
     */
    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    /**
     * Gets salidas.
     *
     * @return the salidas
     */
    public int getSalidas() {
        return salidas;
    }

    /**
     * Sets salidas.
     *
     * @param salidas the salidas
     */
    public void setSalidas(int salidas) {
        this.salidas = salidas;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Gets suma totales.
     *
     * @return the suma totales
     */
    public BigDecimal getSumaTotales() {
        return sumaTotales;
    }

    /**
     * Sets suma totales.
     *
     * @param sumaTotales the suma totales
     */
    public void setSumaTotales(BigDecimal sumaTotales) {
        this.sumaTotales = sumaTotales;
    }

    /**
     * Gets precio unitario kardex.
     *
     * @return the precio unitario kardex
     */
    public BigDecimal getPrecioUnitarioKardex() {
        return precioUnitarioKardex;
    }

    /**
     * Sets precio unitario kardex.
     *
     * @param precioUnitarioKardex the precio unitario kardex
     */
    public void setPrecioUnitarioKardex(BigDecimal precioUnitarioKardex) {
        this.precioUnitarioKardex = precioUnitarioKardex;
    }

    /**
     * Gets existencias entradas.
     *
     * @return the existencias entradas
     */
    public BigDecimal getExistenciasEntradas() {
        return existenciasEntradas;
    }

    /**
     * Sets existencias entradas.
     *
     * @param existenciasEntradas the existencias entradas
     */
    public void setExistenciasEntradas(BigDecimal existenciasEntradas) {
        this.existenciasEntradas = existenciasEntradas;
    }

    /**
     * Gets existencias salidas.
     *
     * @return the existencias salidas
     */
    public BigDecimal getExistenciasSalidas() {
        return existenciasSalidas;
    }

    /**
     * Sets existencias salidas.
     *
     * @param existenciasSalidas the existencias salidas
     */
    public void setExistenciasSalidas(BigDecimal existenciasSalidas) {
        this.existenciasSalidas = existenciasSalidas;
    }

    /**
     * Gets total existencias.
     *
     * @return the total existencias
     */
    public BigDecimal getTotalExistencias() {
        return totalExistencias;
    }

    /**
     * Sets total existencias.
     *
     * @param totalExistencias the total existencias
     */
    public void setTotalExistencias(BigDecimal totalExistencias) {
        this.totalExistencias = totalExistencias;
    }

    /**
     * Gets mes.
     *
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * Sets mes.
     *
     * @param mes the mes
     */
    public void setMes(String mes) {
        this.mes = mes;
    }
}
