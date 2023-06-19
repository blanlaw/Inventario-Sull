package com.argo.inventario_service.producto.domain.repository;

import com.argo.inventario_service.producto.application.models.productoModels;
import com.argo.inventario_service.producto.domain.ProductoAlmacen;
import com.argo.inventario_service.producto.domain.embd.embIdProduct;
import com.commons.user.models.entity.area.domain.Almacen;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Product.
 */
@Repository
public interface IProduct extends JpaRepository<ProductoAlmacen, embIdProduct> {


    /**
     * Productos dashboard list.
     *
     * @param almacen  the almacen
     * @param pageable the pageable
     * @return the list
     */
    @Query("select cod.codigo as codigo,cod.descripcion as nombre,pt.stock as cantidad,cod.precioUnitario as precioUnitario from producto_almacen pt inner join pt.id.codigo cod where pt.id.idAlmacen=?1")
    List<productoModels> productosDashboard(Almacen almacen, Pageable pageable);


    /**
     * Lista entera list.
     *
     * @param almacen the almacen
     * @return the list
     */
    @Query("select cod.codigo as codigo,cod.tipo.tipo as tipo,cod.color as color,cod.marca as marca,cod.modelo as modelo,cod.talla as talla,cod.descripcion as descripcion,cod.precioUnitario as precio,pro.stock as cantidad from producto_almacen pro inner join pro.id.codigo cod  where pro.id.idAlmacen=?1")
    List<CodigoListNuevo> listaEntera(Almacen almacen);


    /**
     * Cantidad productos long.
     *
     * @param almacen the almacen
     * @return the long
     */
    @Query("select count(pro) from producto_almacen  pro inner join pro.id proid where proid.idAlmacen=?1")
    long cantidadProductos(Almacen almacen);


    /**
     * Todo list.
     *
     * @param almacen the almacen
     * @return the list
     */
    @Query("select pro from producto_almacen pro where pro.id.idAlmacen=?1")
    List<ProductoAlmacen> todo(Almacen almacen);

    /**
     * Lista entera producto almacen list.
     *
     * @param idAlmacen the id almacen
     * @return the list
     */
    @Query("select pro.id.codigo.codigo as codigo,pro.stock as cantidad,al.idAlmacen as almacen from producto_almacen pro inner join pro.id.idAlmacen  al  where al.idAlmacen=?1")
    List<CodigoListaProducto> listaEnteraProductoAlmacen(Almacen idAlmacen);


    /**
     * Gets producto.
     *
     * @param almacen the almacen
     * @return the producto
     */
    @Query("select pro from producto_almacen pro  inner join pro.id.idAlmacen pros where pros.idAlmacen=?1")
    List<ProductoAlmacen> getProducto(int almacen);
}
