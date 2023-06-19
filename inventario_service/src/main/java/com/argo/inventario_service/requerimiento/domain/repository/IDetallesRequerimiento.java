package com.argo.inventario_service.requerimiento.domain.repository;


import com.argo.inventario_service.requerimiento.domain.DetallesRequerimiento;
import com.argo.inventario_service.requerimiento.domain.Requerimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Detalles requerimiento.
 */
@Repository
public interface IDetallesRequerimiento extends JpaRepository<DetallesRequerimiento,Integer> {


    /**
     * Find by id requerimiento list.
     *
     * @param requerimiento the requerimiento
     * @return the list
     */
    List<DetallesRequerimiento> findByIdRequerimiento(Requerimiento requerimiento);
}
