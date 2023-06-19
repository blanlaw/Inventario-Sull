package com.argo.inventario_service.producto.domain;

import com.argo.inventario_service.producto.domain.enm.moneda;
import com.argo.inventario_service.requerimiento.domain.enm.EstadoRequerimiento;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The type Orden de compra.
 */
@Entity
public class OrdenDeCompra implements Serializable {


    /**
     * The Detalles orden.
     */
    @OneToMany(mappedBy = "idOrden")
    List<DetallesOrden> detallesOrden;
    //numero comprobante
    @Column(name = "numero_comprobante", length = 50, columnDefinition = "varchar(50) default 'KARDEX DE DIFERENCIA'")
    private String numeroComprobante;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "id_user_realizado")
    private User idUser;


    @Id
    @Column(name = "id_orden", nullable = false, unique = true)
    private String numeroOrden;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_orden")
    private Date fechaOrden;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaEntrega;

    @Column(nullable = false, length = 100)
    private String direccionEntrega;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private moneda monedas;

    @Column(nullable = false, length = 100)
    private String condicionPago;


    //datos del proveedor
    @Column(nullable = false, length = 70)
    private String formaPago;

    @Column(nullable = false, length = 11)
    private String ruc;

    @Column(nullable = false, length = 255)
    private String nombreProveedor;

    @Column(nullable = false, length = 150)
    private String direccion;

    @Column(nullable = true, columnDefinition = "varchar(80) default 'no tiene'")
    private String correo;

    @Column(nullable = true, columnDefinition = "char(9) default 'no tiene'")
    private String phone;


    //total orden
    @Transient
    private BigDecimal subTotal;

    @Transient
    private BigDecimal descuento;

    @Transient
    private BigDecimal igv;
    @Transient
    private BigDecimal total;

    //observaciones
    @Size(max = 4000)
    private String observaciones;


    @Enumerated(EnumType.STRING)
    @Column
    private EstadoRequerimiento estadoOrden;



    @ManyToOne(targetEntity = Almacen.class)
    private Almacen idAlmacen;


    /**
     * Instantiates a new Orden de compra.
     *
     * @param numeroComprobante the numero comprobante
     * @param idUser            the id user
     * @param numeroOrden       the numero orden
     * @param fechaOrden        the fecha orden
     * @param fechaEntrega      the fecha entrega
     * @param direccionEntrega  the direccion entrega
     * @param monedas           the monedas
     * @param condicionPago     the condicion pago
     * @param formaPago         the forma pago
     * @param ruc               the ruc
     * @param nombreProveedor   the nombre proveedor
     * @param direccion         the direccion
     * @param correo            the correo
     * @param phone             the phone
     * @param observaciones     the observaciones
     * @param idAlmacen         the id almacen
     */
    public OrdenDeCompra(String numeroComprobante, User idUser, String numeroOrden, Date fechaOrden, Date fechaEntrega, String direccionEntrega, moneda monedas, String condicionPago, String formaPago, String ruc, String nombreProveedor, String direccion, String correo, String phone, @Size(max = 4000) String observaciones, Almacen idAlmacen) {
        this.numeroComprobante = numeroComprobante;
        this.idUser = idUser;
        this.numeroOrden = numeroOrden;
        this.fechaOrden = fechaOrden;
        this.fechaEntrega = fechaEntrega;
        this.direccionEntrega = direccionEntrega;
        this.monedas = monedas;
        this.condicionPago = condicionPago;
        this.formaPago = formaPago;
        this.ruc = ruc;
        this.nombreProveedor = nombreProveedor;
        this.direccion = direccion;
        this.correo = correo;
        this.phone = phone;
        this.observaciones = observaciones;
        this.idAlmacen = idAlmacen;
        this.estadoOrden=EstadoRequerimiento.ESPERA;
    }

    /**
     * Instantiates a new Orden de compra.
     */
    public OrdenDeCompra() {

    }


    /**
     * Gets sub total.
     *
     * @return the sub total
     */
    public BigDecimal getSubTotal() {

        List<DetallesOrden> detallesOrden = this.getDetallesOrden();

        BigDecimal subTotal = new BigDecimal(0);


        for (DetallesOrden det : detallesOrden) {
            subTotal = det.getSubTotal().add(subTotal);


        }


        return subTotal;
    }

    /**
     * Sets sub total.
     *
     * @param subTotal the sub total
     */
    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * Gets descuento.
     *
     * @return the descuento
     */
    public BigDecimal getDescuento() {
        BigDecimal descuento = new BigDecimal(0);
        for (DetallesOrden det : detallesOrden) {
            descuento = det.getDescuento().add(descuento);


        }


        return descuento;
    }

    /**
     * Gets igv.
     *
     * @return the igv
     */
    public BigDecimal getIgv() {

        return this.getSubTotal().multiply(new BigDecimal("0.18"));


    }

    /**
     * Gets numero comprobante.
     *
     * @return the numero comprobante
     */
    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    /**
     * Sets numero comprobante.
     *
     * @param numeroComprobante the numero comprobante
     */
    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    /**
     * Gets detalles orden.
     *
     * @return the detalles orden
     */
    public List<DetallesOrden> getDetallesOrden() {
        return detallesOrden;
    }

    /**
     * Sets detalles orden.
     *
     * @param detallesOrden the detalles orden
     */
    public void setDetallesOrden(List<DetallesOrden> detallesOrden) {
        this.detallesOrden = detallesOrden;
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
     * Gets numero orden.
     *
     * @return the numero orden
     */
    public String getNumeroOrden() {
        return numeroOrden;
    }

    /**
     * Sets numero orden.
     *
     * @param numeroOrden the numero orden
     */
    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    /**
     * Gets fecha orden.
     *
     * @return the fecha orden
     */
    public Date getFechaOrden() {
        return fechaOrden;
    }

    /**
     * Sets fecha orden.
     *
     * @param fechaOrden the fecha orden
     */
    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
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
     * @param fechaEntrega the fecha entrega
     */
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    /**
     * Gets direccion entrega.
     *
     * @return the direccion entrega
     */
    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    /**
     * Sets direccion entrega.
     *
     * @param direccionEntrega the direccion entrega
     */
    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    /**
     * Gets monedas.
     *
     * @return the monedas
     */
    public moneda getMonedas() {
        return monedas;
    }

    /**
     * Sets monedas.
     *
     * @param monedas the monedas
     */
    public void setMonedas(moneda monedas) {
        this.monedas = monedas;
    }

    /**
     * Gets condicion pago.
     *
     * @return the condicion pago
     */
    public String getCondicionPago() {
        return condicionPago;
    }

    /**
     * Sets condicion pago.
     *
     * @param condicionPago the condicion pago
     */
    public void setCondicionPago(String condicionPago) {
        this.condicionPago = condicionPago;
    }

    /**
     * Gets forma pago.
     *
     * @return the forma pago
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Sets forma pago.
     *
     * @param formaPago the forma pago
     */
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * Gets ruc.
     *
     * @return the ruc
     */
    public String getRuc() {
        return ruc;
    }

    /**
     * Sets ruc.
     *
     * @param ruc the ruc
     */
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    /**
     * Gets nombre proveedor.
     *
     * @return the nombre proveedor
     */
    public String getNombreProveedor() {
        return nombreProveedor;
    }

    /**
     * Sets nombre proveedor.
     *
     * @param nombreProveedor the nombre proveedor
     */
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    /**
     * Gets direccion.
     *
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Sets direccion.
     *
     * @param direccion the direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Gets correo.
     *
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Sets correo.
     *
     * @param correo the correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets total.
     *
     * @return the total
     */
    public BigDecimal getTotal() {
        return total;
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
     * Gets id almacen.
     *
     * @return the id almacen
     */
    public Almacen getIdAlmacen() {
        return idAlmacen;
    }

    /**
     * Sets id almacen.
     *
     * @param idAlmacen the id almacen
     */
    public void setIdAlmacen(Almacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    /**
     * Gets estado orden.
     *
     * @return the estado orden
     */
    public EstadoRequerimiento getEstadoOrden() {
        return estadoOrden;
    }

    /**
     * Sets estado orden.
     *
     * @param estadoOrden the estado orden
     */
    public void setEstadoOrden(EstadoRequerimiento estadoOrden) {
        this.estadoOrden = estadoOrden;
    }
}
