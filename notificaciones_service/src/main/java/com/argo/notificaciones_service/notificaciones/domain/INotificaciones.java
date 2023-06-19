package com.argo.notificaciones_service.notificaciones.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INotificaciones  extends JpaRepository<Notificaciones,String> {


    List<Notificaciones> findByIdAlmacen(int idAlmacen);
}
