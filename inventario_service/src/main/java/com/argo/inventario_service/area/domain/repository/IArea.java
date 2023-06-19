package com.argo.inventario_service.area.domain.repository;


import com.commons.user.models.entity.area.domain.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Area.
 */
@Repository
public interface IArea  extends JpaRepository<Area,Integer> {
}
