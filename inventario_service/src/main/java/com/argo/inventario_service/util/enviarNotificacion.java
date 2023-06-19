package com.argo.inventario_service.util;

import com.argo.inventario_service.requerimiento.infrastructure.api.dto.RequerimientoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * The interface Enviar notificacion.
 */
@FeignClient("notificaciones-service")
public interface enviarNotificacion {


    /**
     * Enviar notificacion response entity.
     *
     * @param requerimientoDTO the requerimiento dto
     * @param tipo             the tipo
     * @param token            the token
     * @return the response entity
     */
    @PostMapping("/notificaciones/{id}")
    ResponseEntity<?> enviarNotificacion(@RequestBody RequerimientoDTO requerimientoDTO, @PathVariable("id") int tipo, @RequestHeader("Authorization") String token);


}
