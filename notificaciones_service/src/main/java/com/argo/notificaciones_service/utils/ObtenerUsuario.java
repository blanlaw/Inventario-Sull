package com.argo.notificaciones_service.utils;

import com.argo.notificaciones_service.notificaciones.application.dto.RequerimientoModelo;
import com.commons.user.models.entity.accessUser.domain.Access;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("inventario-service")
public interface ObtenerUsuario {


    @GetMapping("/requerimiento/me/{id}")
    List<Access> pushUser(@PathVariable("id") String codigo);


    @GetMapping("/requerimiento/getRequerimiento/{id}")
    RequerimientoModelo objetoRequerimiento(@PathVariable("id") String id);

}
