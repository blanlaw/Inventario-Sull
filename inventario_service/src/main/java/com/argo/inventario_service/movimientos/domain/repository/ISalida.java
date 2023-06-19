package com.argo.inventario_service.movimientos.domain.repository;

import com.argo.inventario_service.movimientos.domain.Salida;
import com.argo.inventario_service.requerimiento.domain.Requerimiento;
import com.commons.user.models.entity.area.domain.Almacen;
import org.checkerframework.checker.units.qual.A;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Salida.
 */
@Repository
public interface ISalida extends JpaRepository<Salida, Integer> {

    /**
     * Find by requerimiento optional.
     *
     * @param req the req
     * @return the optional
     */
    Optional<Salida> findByRequerimiento(Requerimiento req);


   // Optional<Salida> findByAlmacenOrigen(Almacen almacen);


    /**
     * Find by almacen origen list.
     *
     * @param almacen the almacen
     * @return the list
     */
    List<Salida> findByAlmacenOrigen(Almacen almacen);

    /**
     * Salidas by date of week list.
     *
     * @param toString  the to string
     * @param idAlmacen the id almacen
     * @return the list
     */
    @Query(value = "SELECT * FROM salida  ent inner join almacen alm on (alm.id_almacen=ent.almacen_origen_id_almacen) WHERE ent.fecha_salida =  :toString  and alm.id_almacen= :idAlmacen",nativeQuery = true)
    List salidasByDateOfWeek( String toString,int idAlmacen);
}


