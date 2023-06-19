package com.argo.notificaciones_service.notificaciones.application.dto;

import java.util.Date;
import java.util.List;

public class RequermientoModleoEnvio {
    private String estado;
    private String fechaEmision;
    private String fechaEntrega;
    private String observaciones;
    private String almacenPideRequerimiento;
    private String almacenRecibeRequerimiento;
    private String requeridoPor;
    private List<DetallesRequerimientoModelo> detalles;



    public RequermientoModleoEnvio(String estado, String fechaEmision, String fechaEntrega, String observaciones, String almacenPideRequerimiento, String almacenRecibeRequerimiento, String requeridoPor, List<DetallesRequerimientoModelo> detalles) {
        this.estado = estado;
        this.fechaEmision = fechaEmision;
        this.fechaEntrega = fechaEntrega;
        this.observaciones = observaciones;
        this.almacenPideRequerimiento = almacenPideRequerimiento;
        this.almacenRecibeRequerimiento = almacenRecibeRequerimiento;
        this.requeridoPor = requeridoPor;
        this.detalles = detalles;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getAlmacenPideRequerimiento() {
        return almacenPideRequerimiento;
    }

    public void setAlmacenPideRequerimiento(String almacenPideRequerimiento) {
        this.almacenPideRequerimiento = almacenPideRequerimiento;
    }

    public String getAlmacenRecibeRequerimiento() {
        return almacenRecibeRequerimiento;
    }

    public void setAlmacenRecibeRequerimiento(String almacenRecibeRequerimiento) {
        this.almacenRecibeRequerimiento = almacenRecibeRequerimiento;
    }

    public String getRequeridoPor() {
        return requeridoPor;
    }

    public void setRequeridoPor(String requeridoPor) {
        this.requeridoPor = requeridoPor;
    }

    public List<DetallesRequerimientoModelo> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallesRequerimientoModelo> detalles) {
        this.detalles = detalles;
    }
}
