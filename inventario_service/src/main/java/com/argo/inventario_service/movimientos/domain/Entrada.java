package com.argo.inventario_service.movimientos.domain;

import com.argo.inventario_service.movimientos.domain.enm.TipoEntrada;
import com.argo.inventario_service.movimientos.domain.enm.estadoMovimiento;
import com.argo.inventario_service.requerimiento.domain.Requerimiento;
import com.argo.inventario_service.requerimiento.domain.enm.TipoRequerimiento;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The type Entrada.
 */
@Entity
public class Entrada implements Serializable {



    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;


    /**
     * The Detalles.
     */
    @OneToMany(mappedBy = "idEntrada")
    List<EntradaDetalles> detalles;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEntrada;
    @Enumerated(EnumType.STRING)
    private estadoMovimiento movimiento;
    @Column
    private String observaciones;
    @Column
    private String tipoComprobante;
    @Column
    private String valeIngreso;
    @OneToOne(targetEntity = Requerimiento.class)
    @JoinColumn(name = "id_requerimiento")
    private Requerimiento idRequerimiento;
    @ManyToOne(targetEntity = Almacen.class)
    @JoinColumn(name = "id_almacen_recibe")
    private Almacen idAlmacenRecibe;
    @ManyToOne(targetEntity = Almacen.class)
    @JoinColumn(name = "id_almacen_entrega")
    private Almacen idAlmacenEntrega;
    //usuario recibe
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "id_user_recibe")
    private User idUser;

    @Enumerated(EnumType.STRING)
    @Column
    private TipoEntrada tipoEntrada;


    /**
     * Instantiates a new Entrada.
     *
     * @param movimiento       the movimiento
     * @param observaciones    the observaciones
     * @param tipoComprobante  the tipo comprobante
     * @param valeIngreso      the vale ingreso
     * @param idRequerimiento  the id requerimiento
     * @param idAlmacenRecibe  the id almacen recibe
     * @param idAlmacenEntrega the id almacen entrega
     * @param idUser           the id user
     * @param tipoEntrada      the tipo entrada
     * @param fechaEntrada     the fecha entrada
     */
    public Entrada(estadoMovimiento movimiento, String observaciones, String tipoComprobante, String valeIngreso, Requerimiento idRequerimiento, Almacen idAlmacenRecibe, Almacen idAlmacenEntrega, User idUser,TipoEntrada tipoEntrada,Date fechaEntrada) {
        this.movimiento = movimiento;
        this.observaciones = observaciones;
        this.tipoComprobante = tipoComprobante;
        this.valeIngreso = valeIngreso;
        this.idRequerimiento = idRequerimiento;
        this.idAlmacenRecibe = idAlmacenRecibe;
        this.idAlmacenEntrega = idAlmacenEntrega;
        this.idUser = idUser;
        this.tipoEntrada=tipoEntrada;
        this.fechaEntrada=fechaEntrada;
    }

    /**
     * Instantiates a new Entrada.
     */
    public Entrada() {

    }


    /**
     * Gets id entrada.
     *
     * @return the id entrada
     */
    public int getIdEntrada() {
        return idEntrada;
    }

    /**
     * Sets id entrada.
     *
     * @param idEntrada the id entrada
     */
    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
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
     * Gets id requerimiento.
     *
     * @return the id requerimiento
     */
    public Requerimiento getIdRequerimiento() {
        return idRequerimiento;
    }

    /**
     * Sets id requerimiento.
     *
     * @param idRequerimiento the id requerimiento
     */
    public void setIdRequerimiento(Requerimiento idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    /**
     * Gets id almacen recibe.
     *
     * @return the id almacen recibe
     */
    public Almacen getIdAlmacenRecibe() {
        return idAlmacenRecibe;
    }

    /**
     * Sets id almacen recibe.
     *
     * @param idAlmacenRecibe the id almacen recibe
     */
    public void setIdAlmacenRecibe(Almacen idAlmacenRecibe) {
        this.idAlmacenRecibe = idAlmacenRecibe;
    }

    /**
     * Gets id almacen entrega.
     *
     * @return the id almacen entrega
     */
    public Almacen getIdAlmacenEntrega() {
        return idAlmacenEntrega;
    }

    /**
     * Sets id almacen entrega.
     *
     * @param idAlmacenEntrega the id almacen entrega
     */
    public void setIdAlmacenEntrega(Almacen idAlmacenEntrega) {
        this.idAlmacenEntrega = idAlmacenEntrega;
    }

    /**
     * Gets id user.
     *
     * @return the id user
     */
    public User getIdUser() {
        return idUser;
    }

    /**
     * Sets id user.
     *
     * @param idUser the id user
     */
    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    /**
     * Gets detalles.
     *
     * @return the detalles
     */
    public List<EntradaDetalles> getDetalles() {
        return detalles;
    }

    /**
     * Sets detalles.
     *
     * @param detalles the detalles
     */
    public void setDetalles(List<EntradaDetalles> detalles) {
        this.detalles = detalles;
    }

    /**
     * Gets tipo entrada.
     *
     * @return the tipo entrada
     */
    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    /**
     * Sets tipo entrada.
     *
     * @param tipoEntrada the tipo entrada
     */
    public void setTipoEntrada(TipoEntrada tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    /**
     * Gets fecha entrada.
     *
     * @return the fecha entrada
     */
    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    /**
     * Sets fecha entrada.
     *
     * @param fechaEntrada the fecha entrada
     */
    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
}
