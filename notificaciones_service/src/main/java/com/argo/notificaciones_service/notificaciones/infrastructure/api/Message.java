package com.argo.notificaciones_service.notificaciones.infrastructure.api;


import com.argo.notificaciones_service.notificaciones.application.NotificacionesService;
import com.argo.notificaciones_service.notificaciones.domain.Notificaciones;
import com.argo.notificaciones_service.notificaciones.infrastructure.api.dto.mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class Message {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private NotificacionesService notificacionesService;

    @SendTo("/topic/messages")
    public String send() {
        System.out.println("me llego un mensaje");
        return "bien";

    }


    @MessageMapping("/chat")
    public void recibir(@Header("Authorization") String almacen) {

        System.out.println(almacen);

        List<Notificaciones> notificaciones = this.notificacionesService.misNotificaciones(Integer.parseInt(almacen));
        List<mensaje> collect = notificaciones.stream().map(notificaciones1 -> {

            mensaje m = new mensaje();
            m.setMensaje("Tiene un nuevo requerimiento de " + notificaciones1.getTipoRequerimiento().toString());
            m.setIdRequerimiento(notificaciones1.getIdRequerimiento());
            m.setEstadoNotificacion(notificaciones1.getEstado());
            m.setTipoRequerimiento(notificaciones1.getTipoRequerimiento());
            return m;
        }).collect(Collectors.toList());

        System.out.println("este es mi almacen " + almacen);
        this.simpMessagingTemplate.convertAndSend("/secured/user/queue/specific-user/" + almacen, collect);


    }

}
