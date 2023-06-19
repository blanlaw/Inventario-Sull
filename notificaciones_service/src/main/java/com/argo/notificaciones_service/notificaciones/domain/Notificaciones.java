package com.argo.notificaciones_service.notificaciones.domain;


import com.argo.notificaciones_service.notificaciones.domain.enm.TipoRequerimiento;
import com.argo.notificaciones_service.notificaciones.domain.enm.estadoNotificacion;

import javax.persistence.*;

@Entity(name = "notificaciones")
public class Notificaciones {

    @Id
    private String idRequerimiento;

    @Column
    private int idAlmacen;

    @Enumerated(EnumType.STRING)
    @Column
    private estadoNotificacion estado;

    @Enumerated(EnumType.STRING)
    @Column
    private TipoRequerimiento tipoRequerimiento;

    public Notificaciones() {
        this.estado = estadoNotificacion.NO_REVISADO;
    }

    public estadoNotificacion getEstado() {
        return estado;
    }

    public void setEstado(estadoNotificacion estado) {
        this.estado = estado;
    }

    public String getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(String idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    public TipoRequerimiento getTipoRequerimiento() {
        return tipoRequerimiento;
    }

    public void setTipoRequerimiento(TipoRequerimiento tipoRequerimiento) {
        this.tipoRequerimiento = tipoRequerimiento;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }


}
