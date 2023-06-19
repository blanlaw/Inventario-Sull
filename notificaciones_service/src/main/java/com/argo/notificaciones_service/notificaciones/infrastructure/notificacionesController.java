package com.argo.notificaciones_service.notificaciones.infrastructure;

import com.argo.notificaciones_service.notificaciones.application.NotificacionesService;
import com.argo.notificaciones_service.notificaciones.application.dto.RequerimientoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notificaciones")
public class notificacionesController {

    @Autowired
    private NotificacionesService notificacionesService;


    @PostMapping("/{id}")
    public ResponseEntity<?> misNotificaciones(@RequestBody RequerimientoDTO requerimientoDTO, @PathVariable("id") int tipo,@RequestHeader("Authorization") String token) {


        this.notificacionesService.sendNotification(tipo, requerimientoDTO,token.split(" ")[1]);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
