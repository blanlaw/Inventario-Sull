package com.argo.notificaciones_service.notificaciones.infrastructure.api.dto;


import com.argo.notificaciones_service.notificaciones.domain.enm.TipoRequerimiento;
import com.argo.notificaciones_service.notificaciones.domain.enm.estadoNotificacion;


public class mensaje {

    private String idRequerimiento;

    private String mensaje;

    private com.argo.notificaciones_service.notificaciones.domain.enm.estadoNotificacion estadoNotificacion;

    private TipoRequerimiento tipoRequerimiento;

    public TipoRequerimiento getTipoRequerimiento() {
        return tipoRequerimiento;
    }

    public void setTipoRequerimiento(TipoRequerimiento tipoRequerimiento) {
        this.tipoRequerimiento = tipoRequerimiento;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(String idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    public estadoNotificacion getEstadoNotificacion() {
        return estadoNotificacion;
    }

    public void setEstadoNotificacion(estadoNotificacion estadoNotificacion) {
        this.estadoNotificacion = estadoNotificacion;
    }
}
