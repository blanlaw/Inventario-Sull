package com.argo.notificaciones_service.notificaciones.application.dto;

public class Push {



    private String codigoRequerimiento;

    private String mensaje;

    public String getCodigoRequerimiento() {
        return codigoRequerimiento;
    }

    public void setCodigoRequerimiento(String codigoRequerimiento) {
        this.codigoRequerimiento = codigoRequerimiento;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
