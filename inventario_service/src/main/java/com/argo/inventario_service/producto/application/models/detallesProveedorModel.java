package com.argo.inventario_service.producto.application.models;

/**
 * The type Detalles proveedor model.
 */
public class detallesProveedorModel {

    private String ruc;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;

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
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets nombre.
     *
     * @param nombre the nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * Gets telefono.
     *
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Sets telefono.
     *
     * @param telefono the telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
}
