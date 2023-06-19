package com.argo.inventario_service.movimientos.domain.repository;

import com.argo.inventario_service.movimientos.application.models.entradaModelo;
import com.argo.inventario_service.movimientos.domain.Entrada;
import com.commons.user.models.entity.area.domain.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Entrada.
 */
@Repository
public interface IEntrada  extends JpaRepository<Entrada,Integer> {

    /**
     * Find by id almacen recibe list.
     *
     * @param almacen the almacen
     * @return the list
     */
    List<Entrada> findByIdAlmacenRecibe(Almacen almacen);


    /**
     * Almacen recibe entrada list.
     *
     * @param almacen the almacen
     * @return the list
     */
    @Query("select ent.idEntrada as idEntrada, ent.fechaEntrada as fechaEntrada, ent.movimiento as estadoMovimiento,ent.tipoComprobante as tipoComprobante,ent.tipoEntrada as tipoEntrada from Entrada ent where ent.idAlmacenRecibe=?1")
    List<entradaModelo> almacenRecibeEntrada(Almacen almacen);

    /**
     * Entras by date of week list.
     *
     * @param fecha the fecha
     * @param id    the id
     * @return the list
     */
    @Query(value = "SELECT * FROM entrada  ent inner join almacen alm on (alm.id_almacen=ent.id_almacen_recibe)WHERE ent.fecha_entrada =  :fecha  and alm.id_almacen=:id",nativeQuery = true)
    List entrasByDateOfWeek( String fecha,int id);
}
