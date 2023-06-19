package com.argo.inventario_service.reporte.models;

import java.math.BigDecimal;
import java.util.List;

/**
 * The type Reporte modelo.
 */
public class ReporteModelo {

    private List<DetallesReporteModelo> detalles;
    private BigDecimal totalExistenciasSalidas;
    private BigDecimal totaExistencias;

    /**
     * Gets detalles.
     *
     * @return the detalles
     */
    public List<DetallesReporteModelo> getDetalles() {
        return detalles;
    }

    /**
     * Sets detalles.
     *
     * @param detalles the detalles
     */
    public void setDetalles(List<DetallesReporteModelo> detalles) {
        this.detalles = detalles;
    }


    /**
     * Gets total existencias salidas.
     *
     * @return the total existencias salidas
     */
    public BigDecimal getTotalExistenciasSalidas() {
        List<DetallesReporteModelo> detalles = this.getDetalles();

        BigDecimal total = new BigDecimal(0);

        for (DetallesReporteModelo detalle : detalles) {
            total = total.add(detalle.getExistenciasSalidas());
        }

        return total;


    }

    /**
     * Instantiates a new Reporte modelo.
     *
     * @param detalles the detalles
     */
    public ReporteModelo(List<DetallesReporteModelo> detalles) {
        this.detalles = detalles;
    }

    /**
     * Instantiates a new Reporte modelo.
     */
    public ReporteModelo() {
    }

    /**
     * Gets tota existencias.
     *
     * @return the tota existencias
     */
    public BigDecimal getTotaExistencias() {
        List<DetallesReporteModelo> detalles = this.getDetalles();
        BigDecimal total = new BigDecimal(0);


        for (DetallesReporteModelo detalle : detalles) {
            total = total.add(detalle.totalExistencias);
        }
        return total;   

    }
}
