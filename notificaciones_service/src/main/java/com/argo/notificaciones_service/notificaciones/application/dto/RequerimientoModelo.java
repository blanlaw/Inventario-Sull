package com.argo.notificaciones_service.notificaciones.application.dto;

import java.util.Date;
import java.util.List;

public class RequerimientoModelo {
    private String estado;
    private Date fechaEmision;
    private Date fechaEntrega;
    private String observaciones;
    private String almacenPideRequerimiento;
    private String almacenRecibeRequerimiento;
    private String requeridoPor;
    private List<DetallesRequerimientoModelo> detalles;

    public RequerimientoModelo(String estado, Date fechaEmision, Date fechaEntrega, String observaciones, String almacenPideRequerimiento, String almacenRecibeRequerimiento, String requeridoPor) {
        this.estado = estado;
        this.fechaEmision = fechaEmision;
        this.fechaEntrega = fechaEntrega;
        this.observaciones = observaciones;
        this.almacenPideRequerimiento = almacenPideRequerimiento;
        this.almacenRecibeRequerimiento = almacenRecibeRequerimiento;
        this.requeridoPor = requeridoPor;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
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

    public RequerimientoModelo() {
    }

    @Override
    public String toString() {
        return "RequerimientoModelo{" +
                "estado='" + estado + '\'' +
                ", fechaEmision=" + fechaEmision +
                ", fechaEntrega=" + fechaEntrega +
                ", observaciones='" + observaciones + '\'' +
                ", almacenPideRequerimiento='" + almacenPideRequerimiento + '\'' +
                ", almacenRecibeRequerimiento='" + almacenRecibeRequerimiento + '\'' +
                ", requeridoPor='" + requeridoPor + '\'' +
                ", detalles=" + detalles +
                '}';
    }
}
