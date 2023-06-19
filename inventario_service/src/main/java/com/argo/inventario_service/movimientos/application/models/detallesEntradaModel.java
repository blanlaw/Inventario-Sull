package com.argo.inventario_service.movimientos.application.models;

import com.argo.inventario_service.movimientos.domain.enm.TipoEntrada;
import com.argo.inventario_service.movimientos.domain.enm.estadoMovimiento;

import java.math.BigDecimal;
import java.util.List;

/**
 * The type Detalles entrada model.
 */
public class detallesEntradaModel {

    private estadoMovimiento movimiento;
private String tipoComprobante;
private String valeIngreso;
private String almacen;
private String observaciones;
private List<data> detalles;
private TipoEntrada tipoMovimiento;
private String empleadoIngreso;


    /**
     * Instantiates a new Detalles entrada model.
     *
     * @param movimiento      the movimiento
     * @param tipoComprobante the tipo comprobante
     * @param valeIngreso     the vale ingreso
     * @param almacen         the almacen
     * @param observaciones   the observaciones
     * @param tipoMovimiento  the tipo movimiento
     * @param empleadoIngreso the empleado ingreso
     */
    public detallesEntradaModel(estadoMovimiento movimiento, String tipoComprobante, String valeIngreso, String almacen, String observaciones, TipoEntrada tipoMovimiento, String empleadoIngreso) {
        this.movimiento = movimiento;
        this.tipoComprobante = tipoComprobante;
        this.valeIngreso = valeIngreso;
        this.almacen = almacen;
        this.observaciones = observaciones;
        this.tipoMovimiento=tipoMovimiento;
        this.empleadoIngreso=empleadoIngreso;
    }

    /**
     * Gets movimiento.
     *
     * @return the movimiento
     */
    public estadoMovimiento getMovimiento() {
        return movimiento;
    }

    /**
     * Sets movimiento.
     *
     * @param movimiento the movimiento
     */
    public void setMovimiento(estadoMovimiento movimiento) {
        this.movimiento = movimiento;
    }

    /**
     * Gets tipo comprobante.
     *
     * @return the tipo comprobante
     */
    public String getTipoComprobante() {
        return tipoComprobante;
    }

    /**
     * Sets tipo comprobante.
     *
     * @param tipoComprobante the tipo comprobante
     */
    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    /**
     * Gets vale ingreso.
     *
     * @return the vale ingreso
     */
    public String getValeIngreso() {
        return valeIngreso;
    }

    /**
     * Sets vale ingreso.
     *
     * @param valeIngreso the vale ingreso
     */
    public void setValeIngreso(String valeIngreso) {
        this.valeIngreso = valeIngreso;
    }

    /**
     * Gets almacen.
     *
     * @return the almacen
     */
    public String getAlmacen() {
        return almacen;
    }

    /**
     * Sets almacen.
     *
     * @param almacen the almacen
     */
    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    /**
     * Gets observaciones.
     *
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Sets observaciones.
     *
     * @param observaciones the observaciones
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Gets detalles.
     *
     * @return the detalles
     */
    public List<data> getDetalles() {
        return detalles;
    }

    /**
     * Sets detalles.
     *
     * @param detalles the detalles
     */
    public void setDetalles(List<data> detalles) {
        this.detalles = detalles;
    }

    /**
     * Gets tipo movimiento.
     *
     * @return the tipo movimiento
     */
    public TipoEntrada getTipoMovimiento() {
        return tipoMovimiento;
    }

    /**
     * Sets tipo movimiento.
     *
     * @param tipoMovimiento the tipo movimiento
     */
    public void setTipoMovimiento(TipoEntrada tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    /**
     * Gets empleado ingreso.
     *
     * @return the empleado ingreso
     */
    public String getEmpleadoIngreso() {
        return empleadoIngreso;
    }

    /**
     * Sets empleado ingreso.
     *
     * @param empleadoIngreso the empleado ingreso
     */
    public void setEmpleadoIngreso(String empleadoIngreso) {
        this.empleadoIngreso = empleadoIngreso;
    }
}
