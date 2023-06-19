package com.argo.inventario_service.area.domain.repository;


import com.commons.user.models.entity.area.domain.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Almacen.
 */
@Repository
public interface IAlmacen  extends JpaRepository<Almacen,Integer> {

    /**
     * Find by id almacen is not list.
     *
     * @param id the id
     * @return the list
     */
    List<Almacen> findByIdAlmacenIsNot(int id);
}
