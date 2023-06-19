package com.argo.inventario_service.dashboard.models;

import com.argo.inventario_service.producto.application.models.productoModels;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Dashboard model.
 */
public class dashboardModel {


    private int reqespera;
    private int entradaProductos;
    private int salidaProductos;
    private int cantidadProductos;

    /**
     * The Lista requerimientos espera.
     */
    List<requerimientoModelDashboard> listaRequerimientosEspera;
    /**
     * The Lista requerimientos aceptado.
     */
    List<requerimientoModelDashboard> listaRequerimientosAceptado;
    /**
     * The Lista requerimientos rechazado.
     */
    List<requerimientoModelDashboard> listaRequerimientosRechazado;
    /**
     * The Lista entradas semanales.
     */
    List<entradasSemanales> listaEntradasSemanales;
    /**
     * The Lista salidas semanales.
     */
    List<SalidasSemanales> listaSalidasSemanales;
    /**
     * The Lista total existencias mensuales.
     */
    List<TotalExistenciasMensuales> listaTotalExistenciasMensuales=new ArrayList<>();


    /**
     * Gets lista requerimientos espera.
     *
     * @return the lista requerimientos espera
     */
    public List<requerimientoModelDashboard> getListaRequerimientosEspera() {
        return listaRequerimientosEspera;
    }

    /**
     * Sets lista requerimientos espera.
     *
     * @param listaRequerimientosEspera the lista requerimientos espera
     */
    public void setListaRequerimientosEspera(List<requerimientoModelDashboard> listaRequerimientosEspera) {
        this.listaRequerimientosEspera = listaRequerimientosEspera;
    }

    /**
     * Gets lista requerimientos aceptado.
     *
     * @return the lista requerimientos aceptado
     */
    public List<requerimientoModelDashboard> getListaRequerimientosAceptado() {
        return listaRequerimientosAceptado;
    }

    /**
     * Sets lista requerimientos aceptado.
     *
     * @param listaRequerimientosAceptado the lista requerimientos aceptado
     */
    public void setListaRequerimientosAceptado(List<requerimientoModelDashboard> listaRequerimientosAceptado) {
        this.listaRequerimientosAceptado = listaRequerimientosAceptado;
    }

    /**
     * Gets lista requerimientos rechazado.
     *
     * @return the lista requerimientos rechazado
     */
    public List<requerimientoModelDashboard> getListaRequerimientosRechazado() {
        return listaRequerimientosRechazado;
    }

    /**
     * Sets lista requerimientos rechazado.
     *
     * @param listaRequerimientosRechazado the lista requerimientos rechazado
     */
    public void setListaRequerimientosRechazado(List<requerimientoModelDashboard> listaRequerimientosRechazado) {
        this.listaRequerimientosRechazado = listaRequerimientosRechazado;
    }

    /**
     * The Lista productos.
     */
    List<productoModels>  listaProductos;


    /**
     * Gets reqespera.
     *
     * @return the reqespera
     */
    public int getReqespera() {
        return reqespera;
    }

    /**
     * Sets reqespera.
     *
     * @param reqespera the reqespera
     */
    public void setReqespera(int reqespera) {
        this.reqespera = reqespera;
    }

    /**
     * Gets entrada productos.
     *
     * @return the entrada productos
     */
    public int getEntradaProductos() {
        return entradaProductos;
    }

    /**
     * Sets entrada productos.
     *
     * @param entradaProductos the entrada productos
     */
    public void setEntradaProductos(int entradaProductos) {
        this.entradaProductos = entradaProductos;
    }

    /**
     * Gets salida productos.
     *
     * @return the salida productos
     */
    public int getSalidaProductos() {
        return salidaProductos;
    }

    /**
     * Sets salida productos.
     *
     * @param salidaProductos the salida productos
     */
    public void setSalidaProductos(int salidaProductos) {
        this.salidaProductos = salidaProductos;
    }

    /**
     * Gets cantidad productos.
     *
     * @return the cantidad productos
     */
    public int getCantidadProductos() {
        return cantidadProductos;
    }

    /**
     * Sets cantidad productos.
     *
     * @param cantidadProductos the cantidad productos
     */
    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    /**
     * Gets lista productos.
     *
     * @return the lista productos
     */
    public List<productoModels> getListaProductos() {
        return listaProductos;
    }

    /**
     * Sets lista productos.
     *
     * @param listaProductos the lista productos
     */
    public void setListaProductos(List<productoModels> listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * Gets lista entradas semanales.
     *
     * @return the lista entradas semanales
     */
    public List<entradasSemanales> getListaEntradasSemanales() {
        return listaEntradasSemanales;
    }

    /**
     * Sets lista entradas semanales.
     *
     * @param listaEntradasSemanales the lista entradas semanales
     */
    public void setListaEntradasSemanales(List<entradasSemanales> listaEntradasSemanales) {
        this.listaEntradasSemanales = listaEntradasSemanales;
    }

    /**
     * Gets lista salidas semanales.
     *
     * @return the lista salidas semanales
     */
    public List<SalidasSemanales> getListaSalidasSemanales() {
        return listaSalidasSemanales;
    }

    /**
     * Sets lista salidas semanales.
     *
     * @param listaSalidasSemanales the lista salidas semanales
     */
    public void setListaSalidasSemanales(List<SalidasSemanales> listaSalidasSemanales) {
        this.listaSalidasSemanales = listaSalidasSemanales;
    }

    /**
     * Gets lista total existencias mensuales.
     *
     * @return the lista total existencias mensuales
     */
    public List<TotalExistenciasMensuales> getListaTotalExistenciasMensuales() {
        return listaTotalExistenciasMensuales;
    }

    /**
     * Sets lista total existencias mensuales.
     *
     * @param listaTotalExistenciasMensuales the lista total existencias mensuales
     */
    public void setListaTotalExistenciasMensuales(List<TotalExistenciasMensuales> listaTotalExistenciasMensuales) {
        this.listaTotalExistenciasMensuales = listaTotalExistenciasMensuales;
    }
}
