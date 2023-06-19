package com.argo.inventario_service.requerimiento.domain;

import com.argo.inventario_service.requerimiento.domain.enm.EstadoRequerimiento;
import com.argo.inventario_service.requerimiento.domain.enm.TipoRequerimiento;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The type Requerimiento.
 */
@Entity
public class Requerimiento implements Serializable {

    /**
     * The Detalles requerimiento list.
     */
    @OneToMany(mappedBy = "idRequerimiento")
    List<DetallesRequerimiento> detallesRequerimientoList;
    @Id
    @Column(name = "codigo_requerimiento")
    private String codigoRequerimiento;
    @Enumerated(EnumType.STRING)
    @Column
    private EstadoRequerimiento estadoRequerimiento;
    @ManyToOne(targetEntity = Almacen.class)
    @JoinColumn
    private Almacen almacenPide;
    @ManyToOne(targetEntity = Almacen.class)
    @JoinColumn
    private Almacen almacenRecibe;


    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_requerimiento")
    private TipoRequerimiento tipoRequerimiento;


    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_emision")
    private Date fechaEmision ;


    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_entrega")
    private Date fechaEntrega;


    @Column
    private String observaciones;


    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "requerido_por", nullable = false)
    private User requeridoPor;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "atentido_por", nullable = false)
    private User atendidoPor;


    /**
     * Instantiates a new Requerimiento.
     *
     * @param codigoRequerimiento the codigo requerimiento
     * @param almacenPide         the almacen pide
     * @param almacenRecibe       the almacen recibe
     * @param tipoRequerimiento   the tipo requerimiento
     * @param fechaEntrega        the fecha entrega
     * @param observaciones       the observaciones
     * @param requeridoPor        the requerido por
     * @param atendidoPor         the atendido por
     */
    public Requerimiento(String codigoRequerimiento, Almacen almacenPide, Almacen almacenRecibe, TipoRequerimiento tipoRequerimiento,  Date fechaEntrega, String observaciones, User requeridoPor, User atendidoPor) {
        this.codigoRequerimiento = codigoRequerimiento;
        this.almacenPide = almacenPide;
        this.almacenRecibe = almacenRecibe;
        this.tipoRequerimiento = tipoRequerimiento;

        this.fechaEntrega = fechaEntrega;
        this.observaciones = observaciones;
        this.requeridoPor = requeridoPor;
        this.atendidoPor = atendidoPor;
        this.estadoRequerimiento = EstadoRequerimiento.ESPERA;
    }


    /**
     * Instantiates a new Requerimiento.
     */
    public Requerimiento() {

    }

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
     * Gets fecha emision.
     *
     * @return the fecha emision
     */
    public Date getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Sets fecha emision.
     *
     * @param fechaEmision the fecha emision
     */
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Gets fecha entrega.
     *
     * @return the fecha entrega
     */
    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * Sets fecha entrega.
     *
     * @param fechaEntregan the fecha entregan
     */
    public void setFechaEntrega(Date fechaEntregan) {
        this.fechaEntrega = fechaEntregan;
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
     * Gets requerido por.
     *
     * @return the requerido por
     */
    public User getRequeridoPor() {
        return requeridoPor;
    }

    /**
     * Sets requerido por.
     *
     * @param requeridoPor the requerido por
     */
    public void setRequeridoPor(User requeridoPor) {
        this.requeridoPor = requeridoPor;
    }

    /**
     * Gets atendido por.
     *
     * @return the atendido por
     */
    public User getAtendidoPor() {
        return atendidoPor;
    }

    /**
     * Sets atendido por.
     *
     * @param atentidoPor the atentido por
     */
    public void setAtendidoPor(User atentidoPor) {
        this.atendidoPor = atentidoPor;
    }

    /**
     * Gets almacen pide.
     *
     * @return the almacen pide
     */
    public Almacen getAlmacenPide() {
        return almacenPide;
    }

    /**
     * Sets almacen pide.
     *
     * @param almacenPide the almacen pide
     */
    public void setAlmacenPide(Almacen almacenPide) {
        this.almacenPide = almacenPide;
    }

    /**
     * Gets almacen recibe.
     *
     * @return the almacen recibe
     */
    public Almacen getAlmacenRecibe() {
        return almacenRecibe;
    }

    /**
     * Sets almacen recibe.
     *
     * @param almacenRecibe the almacen recibe
     */
    public void setAlmacenRecibe(Almacen almacenRecibe) {
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
     * Gets estado requerimiento.
     *
     * @return the estado requerimiento
     */
    public EstadoRequerimiento getEstadoRequerimiento() {
        return estadoRequerimiento;
    }

    /**
     * Sets estado requerimiento.
     *
     * @param estadoRequerimiento the estado requerimiento
     */
    public void setEstadoRequerimiento(EstadoRequerimiento estadoRequerimiento) {
        this.estadoRequerimiento = estadoRequerimiento;
    }

    /**
     * Gets detalles requerimiento list.
     *
     * @return the detalles requerimiento list
     */
    public List<DetallesRequerimiento> getDetallesRequerimientoList() {
        return detallesRequerimientoList;
    }

    /**
     * Sets detalles requerimiento list.
     *
     * @param detallesRequerimientoList the detalles requerimiento list
     */
    public void setDetallesRequerimientoList(List<DetallesRequerimiento> detallesRequerimientoList) {
        this.detallesRequerimientoList = detallesRequerimientoList;
    }
}
