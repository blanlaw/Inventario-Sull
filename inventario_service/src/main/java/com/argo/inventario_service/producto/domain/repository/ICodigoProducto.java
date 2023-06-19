package com.argo.inventario_service.producto.domain.repository;

import com.argo.inventario_service.producto.application.models.CodigoList;
import com.argo.inventario_service.producto.application.models.CodigoListMovil;
import com.argo.inventario_service.producto.domain.CodigoProducto;
import com.argo.inventario_service.producto.domain.ProductoAlmacen;
import com.argo.inventario_service.producto.domain.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * The interface Codigo producto.
 */
@Repository
public interface ICodigoProducto extends JpaRepository<CodigoProducto, String> {


    /**
     * Lista codigo productos list.
     *
     * @return the list
     */
    @Query("select p.codigo as codigo,tp.tipo as tipo,p.color as color,p.marca as marca,p.modelo as modelo,p.talla as talla,p.descripcion as descripcion  from lista_productos p inner join p.tipo tp")
    List<CodigoList> listaCodigoProductos();

    /**
     * Lista codigo productos movil list.
     *
     * @param idAlmacen the id almacen
     * @return the list
     */
    @Query("select p.codigo as codigo,tp.tipo as tipo,p.color as color,p.marca as marca,p.modelo as modelo,p.talla as talla,p.descripcion as descripcion  from producto_almacen pt inner join pt.id.codigo p inner join p.tipo tp inner join pt.id.idAlmacen al where al.idAlmacen=?1")
    List<CodigoListMovil> listaCodigoProductosMovil(int idAlmacen);


    /**
     * Find by codigo starting with optional.
     *
     * @param s the s
     * @return the optional
     */
    Optional<CodigoProducto> findByCodigoStartingWith(String s);

    /**
     * Lista codigo productos nevo list.
     *
     * @return the list
     */
    @Query("select p.codigo as codigo,tp.tipo as tipo,p.color as color,p.marca as marca,p.modelo as modelo,p.talla as talla,p.descripcion as descripcion,p.precioUnitario as precio  from lista_productos p inner join p.tipo tp ")
    List<CodigoListNuevo> listaCodigoProductosNevo();

    /**
     * Buscar por nombre list.
     *
     * @return the list
     */
    @Query("select pro from producto_almacen pro")
    List<ProductoAlmacen> buscarPorNombre();


    /**
     * Find by data optional.
     *
     * @param tipo           the tipo
     * @param descripcion    the descripcion
     * @param talla          the talla
     * @param modelo         the modelo
     * @param marca          the marca
     * @param color          the color
     * @param preciounitario the preciounitario
     * @param unidadMedida   the unidad medida
     * @return the optional
     */
    @Query("select cd from lista_productos cd where cd.tipo.tipo=?1 and cd.descripcion=?2 and cd.talla=?3 and cd.modelo=?4 and cd.marca=?5 and cd.color=?6 and cd.precioUnitario=?7 and cd.unidadMedida=?8")
    Optional<CodigoProducto> findByData(String tipo, String descripcion, String talla, String modelo, String marca, String color, BigDecimal preciounitario, String unidadMedida);


    /**
     * Todo lista list.
     *
     * @param descripcion the descripcion
     * @return the list
     */
    @Query("select cd.codigo from lista_productos  cd where cd.descripcion=?1")
    List<String> todoLista(String descripcion);

    /**
     * Find nombres list.
     *
     * @return the list
     */
    @Query("select DISTINCT  cd.descripcion from lista_productos cd ")
    List<String> findNombres();


    /**
     * Lista modelo list.
     *
     * @return the list
     */
    @Query("select DISTINCT  cd.modelo from lista_productos cd ")
    List<String> listaModelo();


    /**
     * Lista marca list.
     *
     * @return the list
     */
    @Query("select DISTINCT  cd.marca from lista_productos cd ")
    List<String> listaMarca();


    /**
     * Lista tipo list.
     *
     * @return the list
     */
    @Query("select DISTINCT  tp from tipo_producto tp")
    List<TipoProducto> listaTipo();


    /**
     * Lista color list.
     *
     * @return the list
     */
    @Query("select DISTINCT  cd.color from lista_productos cd ")
    List<String> listaColor();

    /**
     * Lista talla list.
     *
     * @return the list
     */
    @Query("select DISTINCT  cd.talla from lista_productos cd")
    List<String> listaTalla();


    /**
     * Lista precio list.
     *
     * @return the list
     */
    @Query("select DISTINCT  cd.precioUnitario from lista_productos cd ")
    List<BigDecimal> listaPrecio();

    /**
     * Lista unidad medida list.
     *
     * @return the list
     */
    @Query("select DISTINCT  cd.unidadMedida from lista_productos cd")
    List<String> listaUnidadMedida();






}
