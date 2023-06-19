package com.argo.inventario_service.movimientos.domain.repository;

import com.argo.inventario_service.movimientos.domain.Salida;
import com.argo.inventario_service.movimientos.domain.SalidaDetalles;
import com.argo.inventario_service.movimientos.domain.enm.estadoMovimiento;
import com.argo.inventario_service.producto.domain.CodigoProducto;
import com.commons.user.models.entity.area.domain.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * The interface Salida detalles.
 */
@Repository
public interface ISalidaDetalles extends JpaRepository<SalidaDetalles, Integer> {


    /**
     * Find by id salida list.
     *
     * @param salida the salida
     * @return the list
     */
    List<SalidaDetalles> findByIdSalida(Salida salida);


    /**
     * Mis salidas long.
     *
     * @param almacen the almacen
     * @return the long
     */
    @Query("select  count(salidadet) from salida_detalles salidadet inner join salidadet.idSalida salida where salida.almacenOrigen=?1")
    long misSalidas(Almacen almacen);


    /**
     * Mis salidas big decimal.
     *
     * @param almacen          the almacen
     * @param codigoProducto   the codigo producto
     * @param estadoMovimiento the estado movimiento
     * @return the big decimal
     */
    @Query("select sum(saldt.cantidad) from salida_detalles saldt inner join saldt.idSalida salida where salida.almacenOrigen=?1 and saldt.idProducto=?2 and salida.movimiento<>?3 ")
    BigDecimal misSalidas(Almacen almacen, CodigoProducto codigoProducto, estadoMovimiento estadoMovimiento);

    /**
     * Mis salidas by month big decimal.
     *
     * @param almacen          the almacen
     * @param codigoProducto   the codigo producto
     * @param estadoMovimiento the estado movimiento
     * @param mes              the mes
     * @return the big decimal
     */
    @Query("select sum(saldt.cantidad) from salida_detalles saldt inner join saldt.idSalida salida where salida.almacenOrigen=?1 and saldt.idProducto=?2 and salida.movimiento<>?3  and  function('MONTH',salida.fechaSalida) =?4 ")
    BigDecimal misSalidasByMonth(Almacen almacen, CodigoProducto codigoProducto, estadoMovimiento estadoMovimiento,int mes);


    /**
     * Suma salida big decimal.
     *
     * @param almacen          the almacen
     * @param codigoProducto   the codigo producto
     * @param estadoMovimiento the estado movimiento
     * @return the big decimal
     */
    @Query("select sum(saldt.total) from salida_detalles saldt inner join saldt.idSalida salida where salida.almacenOrigen=?1 and saldt.idProducto=?2  and salida.movimiento<>?3 ")
    BigDecimal sumaSalida(Almacen almacen,CodigoProducto codigoProducto ,estadoMovimiento estadoMovimiento);


    /**
     * Suma salida by month big decimal.
     *
     * @param almacen          the almacen
     * @param codigoProducto   the codigo producto
     * @param estadoMovimiento the estado movimiento
     * @param mes              the mes
     * @return the big decimal
     */
    @Query("select sum(saldt.total) from salida_detalles saldt inner join saldt.idSalida salida where salida.almacenOrigen=?1 and saldt.idProducto=?2  and salida.movimiento<>?3 and function('month',salida.fechaSalida)=?4 ")
    BigDecimal sumaSalidaByMonth(Almacen almacen,CodigoProducto codigoProducto ,estadoMovimiento estadoMovimiento,int mes);

}
