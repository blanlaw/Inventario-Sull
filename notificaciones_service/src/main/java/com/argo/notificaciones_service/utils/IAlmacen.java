package com.argo.notificaciones_service.utils;

import com.commons.user.models.entity.area.domain.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlmacen  extends JpaRepository<Almacen ,Integer> {
}
