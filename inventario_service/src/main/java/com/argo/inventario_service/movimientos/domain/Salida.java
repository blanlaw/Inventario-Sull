package com.argo.inventario_service.movimientos.domain;

import com.argo.inventario_service.movimientos.domain.enm.estadoMovimiento;
import com.argo.inventario_service.requerimiento.domain.Requerimiento;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The type Salida.
 */
@Entity
public class Salida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSalida;
    @Column
    private String combustible;
    @Column
    private String empresa;
    @Column
    private String equipo;
    @Enumerated(EnumType.STRING)
    private estadoMovimiento movimiento;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_salida")
    private Date fechaSalida;

    @Column
    private String placa;
    @Column
    private String modelo;

    @Column(name = "vale_salida")
    private String valeSalida;


    /**
     * The Detalles.
     */
    @OneToMany(mappedBy = "idSalida")
    List<SalidaDetalles> detalles;


    @ManyToOne(targetEntity = Almacen.class)
    @JoinColumn
    private Almacen almacenDestino;

    @ManyToOne(targetEntity = Almacen.class)
    @JoinColumn
    private Almacen almacenOrigen;


    @ManyToOne(targetEntity = User.class)
    @JoinColumn
    private User usuarioEntrega;


    @ManyToOne(targetEntity = User.class)
    @JoinColumn
    private User usuarioRecibe;



    @OneToOne
    @JoinColumn
    private Requerimiento requerimiento;


    /**
     * Instantiates a new Salida.
     *
     * @param combustible    the combustible
     * @param empresa        the empresa
     * @param equipo         the equipo
     * @param movimiento     the movimiento
     * @param fechaSalida    the fecha salida
     * @param placa          the placa
     * @param modelo         the modelo
     * @param valeSalida     the vale salida
     * @param almacenDestino the almacen destino
     * @param almacenOrigen  the almacen origen
     * @param usuarioEntrega the usuario entrega
     * @param usuarioRecibe  the usuario recibe
     */
    public Salida(String combustible, String empresa, String equipo, estadoMovimiento movimiento, Date fechaSalida, String placa, String modelo, String valeSalida, Almacen almacenDestino, Almacen almacenOrigen, User usuarioEntrega, User usuarioRecibe) {
        this.combustible = combustible;
        this.empresa = empresa;
        this.equipo = equipo;
        this.movimiento = movimiento;
        this.fechaSalida = fechaSalida;
        this.placa = placa;
        this.modelo = modelo;
        this.valeSalida = valeSalida;
        this.almacenDestino = almacenDestino;
        this.almacenOrigen = almacenOrigen;
        this.usuarioEntrega = usuarioEntrega;
        this.usuarioRecibe = usuarioRecibe;
    }

    /**
     * Instantiates a new Salida.
     */
    public Salida() {

    }

    /**
     * Gets id salida.
     *
     * @return the id salida
     */
    public int getIdSalida() {
        return idSalida;
    }

    /**
     * Sets id salida.
     *
     * @param idSalida the id salida
     */
    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    /**
     * Gets combustible.
     *
     * @return the combustible
     */
    public String getCombustible() {
        return combustible;
    }

    /**
     * Sets combustible.
     *
     * @param combustible the combustible
     */
    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    /**
     * Gets empresa.
     *
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Sets empresa.
     *
     * @param empresa the empresa
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * Gets equipo.
     *
     * @return the equipo
     */
    public String getEquipo() {
        return equipo;
    }

    /**
     * Sets equipo.
     *
     * @param equipo the equipo
     */
    public void setEquipo(String equipo) {
        this.equipo = equipo;
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
     * Gets fecha salida.
     *
     * @return the fecha salida
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Sets fecha salida.
     *
     * @param fechaSalida the fecha salida
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Gets placa.
     *
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Sets placa.
     *
     * @param placa the placa
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * Gets modelo.
     *
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Sets modelo.
     *
     * @param modelo the modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Gets vale salida.
     *
     * @return the vale salida
     */
    public String getValeSalida() {
        return valeSalida;
    }

    /**
     * Sets vale salida.
     *
     * @param valeIngreso the vale ingreso
     */
    public void setValeSalida(String valeIngreso) {
        this.valeSalida = valeIngreso;
    }

    /**
     * Gets almacen destino.
     *
     * @return the almacen destino
     */
    public Almacen getAlmacenDestino() {
        return almacenDestino;
    }

    /**
     * Sets almacen destino.
     *
     * @param almacenDestino the almacen destino
     */
    public void setAlmacenDestino(Almacen almacenDestino) {
        this.almacenDestino = almacenDestino;
    }

    /**
     * Gets almacen origen.
     *
     * @return the almacen origen
     */
    public Almacen getAlmacenOrigen() {
        return almacenOrigen;
    }

    /**
     * Sets almacen origen.
     *
     * @param almacenOrigen the almacen origen
     */
    public void setAlmacenOrigen(Almacen almacenOrigen) {
        this.almacenOrigen = almacenOrigen;
    }

    /**
     * Gets usuario entrega.
     *
     * @return the usuario entrega
     */
    public User getUsuarioEntrega() {
        return usuarioEntrega;
    }

    /**
     * Sets usuario entrega.
     *
     * @param usuarioEntrega the usuario entrega
     */
    public void setUsuarioEntrega(User usuarioEntrega) {
        this.usuarioEntrega = usuarioEntrega;
    }

    /**
     * Gets usuario recibe.
     *
     * @return the usuario recibe
     */
    public User getUsuarioRecibe() {
        return usuarioRecibe;
    }

    /**
     * Sets usuario recibe.
     *
     * @param usuarioRecibe the usuario recibe
     */
    public void setUsuarioRecibe(User usuarioRecibe) {
        this.usuarioRecibe = usuarioRecibe;
    }

    /**
     * Gets requerimiento.
     *
     * @return the requerimiento
     */
    public Requerimiento getRequerimiento() {
        return requerimiento;
    }

    /**
     * Sets requerimiento.
     *
     * @param requerimiento the requerimiento
     */
    public void setRequerimiento(Requerimiento requerimiento) {
        this.requerimiento = requerimiento;
    }

    /**
     * Gets detalles.
     *
     * @return the detalles
     */
    public List<SalidaDetalles> getDetalles() {
        return detalles;
    }

    /**
     * Sets detalles.
     *
     * @param detalles the detalles
     */
    public void setDetalles(List<SalidaDetalles> detalles) {
        this.detalles = detalles;
    }
}
