package com.argo.notificaciones_service.notificaciones.application.dto;

import com.argo.notificaciones_service.notificaciones.domain.enm.TipoRequerimiento;
import com.commons.user.models.entity.area.domain.Almacen;

public class RequerimientoDTO {

    private String codigoRequerimiento;


    private int almacenRecibe;


    private TipoRequerimiento tipoRequerimiento;


    public String getCodigoRequerimiento() {
        return codigoRequerimiento;
    }


    public int getAlmacenRecibe() {
        return almacenRecibe;
    }

    public TipoRequerimiento getTipoRequerimiento() {
        return tipoRequerimiento;
    }

    public void setCodigoRequerimiento(String codigoRequerimiento) {
        this.codigoRequerimiento = codigoRequerimiento;
    }

    public void setAlmacenRecibe(int almacenRecibe) {
        this.almacenRecibe = almacenRecibe;
    }

    public void setTipoRequerimiento(TipoRequerimiento tipoRequerimiento) {
        this.tipoRequerimiento = tipoRequerimiento;
    }
}
