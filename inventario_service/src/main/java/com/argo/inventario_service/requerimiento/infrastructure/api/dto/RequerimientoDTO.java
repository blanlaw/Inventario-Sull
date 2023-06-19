package com.argo.inventario_service.requerimiento.infrastructure.api.dto;

import com.argo.inventario_service.requerimiento.domain.enm.TipoRequerimiento;

/**
 * The type Requerimiento dto.
 */
public class RequerimientoDTO {
    private String codigoRequerimiento;


    private int almacenRecibe;


    private TipoRequerimiento tipoRequerimiento;

    /**
     * Gets codigo requerimiento.
     *
     * @return the codigo requerimiento
     */
    public String getCodigoRequerimiento() {
        return codigoRequerimiento;
    }

    /**
     * Sets codigo requerimiento.
     *
     * @param codigoRequerimiento the codigo requerimiento
     */
    public void setCodigoRequerimiento(String codigoRequerimiento) {
        this.codigoRequerimiento = codigoRequerimiento;
    }

    /**
     * Gets almacen recibe.
     *
     * @return the almacen recibe
     */
    public int getAlmacenRecibe() {
        return almacenRecibe;
    }

    /**
     * Sets almacen recibe.
     *
     * @param almacenRecibe the almacen recibe
     */
    public void setAlmacenRecibe(int almacenRecibe) {
        this.almacenRecibe = almacenRecibe;
    }

    /**
     * Gets tipo requerimiento.
     *
     * @return the tipo requerimiento
     */
    public TipoRequerimiento getTipoRequerimiento() {
        return tipoRequerimiento;
    }

    /**
     * Sets tipo requerimiento.
     *
     * @param tipoRequerimiento the tipo requerimiento
     */
    public void setTipoRequerimiento(TipoRequerimiento tipoRequerimiento) {
        this.tipoRequerimiento = tipoRequerimiento;
    }

    /**
     * Instantiates a new Requerimiento dto.
     *
     * @param codigoRequerimiento the codigo requerimiento
     * @param almacenRecibe       the almacen recibe
     * @param tipoRequerimiento   the tipo requerimiento
     */
    public RequerimientoDTO(String codigoRequerimiento, int almacenRecibe, TipoRequerimiento tipoRequerimiento) {
        this.codigoRequerimiento = codigoRequerimiento;
        this.almacenRecibe = almacenRecibe;
        this.tipoRequerimiento = tipoRequerimiento;
    }
}
