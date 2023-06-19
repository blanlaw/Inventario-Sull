package com.argo.inventario_service.movimientos.domain.repository;

import com.argo.inventario_service.movimientos.domain.Entrada;
import com.argo.inventario_service.movimientos.domain.EntradaDetalles;
import com.argo.inventario_service.movimientos.domain.enm.estadoMovimiento;
import com.argo.inventario_service.producto.domain.CodigoProducto;
import com.commons.user.models.entity.area.domain.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The interface Entrada detalles.
 */
@Repository
public interface IEntradaDetalles extends JpaRepository<EntradaDetalles, Integer> {


    /**
     * Find by id entrada list.
     *
     * @param entrada the entrada
     * @return the list
     */
    List<EntradaDetalles> findByIdEntrada(Entrada entrada);


    /**
     * Mis entradas long.
     *
     * @param almacen the almacen
     * @return the long
     */
    @Query("select count(entd) from entrada_detalles  entd inner join entd.idEntrada entrada where entrada.idAlmacenRecibe=?1  ")
    long misEntradas(Almacen almacen);


    /**
     * Count by id product and id entrada long.
     *
     * @param codigoProducto the codigo producto
     * @param entrada        the entrada
     * @return the long
     */
    long countByIdProductAndIdEntrada(CodigoProducto codigoProducto, Entrada entrada);


    /**
     * Suma totales big decimal.
     *
     * @param idlmacen         the idlmacen
     * @param codigoProducto   the codigo producto
     * @param estadoMovimiento the estado movimiento
     * @return the big decimal
     */
    @Query("select sum(entd.total) from entrada_detalles  entd inner join entd.idEntrada entrada where entrada.idAlmacenRecibe.idAlmacen=?1 and  entd.idProduct.codigo=?2 and entrada.movimiento=?3")
    BigDecimal sumaTotales(int idlmacen, String codigoProducto, estadoMovimiento estadoMovimiento);

    /**
     * Suma totales by month big decimal.
     *
     * @param idlmacen         the idlmacen
     * @param codigoProducto   the codigo producto
     * @param estadoMovimiento the estado movimiento
     * @param mes              the mes
     * @return the big decimal
     */
    @Query("select sum(entd.total) from entrada_detalles  entd inner join entd.idEntrada entrada where entrada.idAlmacenRecibe.idAlmacen=?1 and  entd.idProduct.codigo=?2 and entrada.movimiento=?3 and function('month',entrada.fechaEntrada)=?4 ")
    BigDecimal sumaTotalesByMonth(int idlmacen, String codigoProducto, estadoMovimiento estadoMovimiento, int mes);


    /**
     * Mis entradas detalles big decimal.
     *
     * @param almacen          the almacen
     * @param codigoProducto   the codigo producto
     * @param estadoMovimiento the estado movimiento
     * @return the big decimal
     */
    @Query("select sum(ent.cantidad) from entrada_detalles  ent inner join ent.idEntrada entrada where entrada.idAlmacenRecibe=?1 and ent.idProduct=?2 and entrada.movimiento=?3")
    BigDecimal misEntradasDetalles(Almacen almacen, CodigoProducto codigoProducto, estadoMovimiento estadoMovimiento);


    /**
     * Mis entradas detalles by month big decimal.
     *
     * @param almacen          the almacen
     * @param codigoProducto   the codigo producto
     * @param estadoMovimiento the estado movimiento
     * @param mes              the mes
     * @return the big decimal
     */
    @Query("select sum(ent.cantidad) from entrada_detalles  ent inner join ent.idEntrada entrada where entrada.idAlmacenRecibe=?1 and ent.idProduct=?2 and entrada.movimiento=?3 and function('month',entrada.fechaEntrada)=?4 ")
    BigDecimal misEntradasDetallesByMonth(Almacen almacen, CodigoProducto codigoProducto, estadoMovimiento estadoMovimiento,int mes);


}
