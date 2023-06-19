package com.argo.notificaciones_service.notificaciones.application;



import com.argo.notificaciones_service.notificaciones.application.dto.RequerimientoDTO;
import com.argo.notificaciones_service.notificaciones.application.dto.RequerimientoModelo;
import com.argo.notificaciones_service.notificaciones.application.dto.RequermientoModleoEnvio;
import com.argo.notificaciones_service.notificaciones.application.dto.mensajesss;
import com.argo.notificaciones_service.notificaciones.domain.INotificaciones;
import com.argo.notificaciones_service.notificaciones.domain.Notificaciones;
import com.argo.notificaciones_service.notificaciones.domain.enm.TipoRequerimiento;
import com.argo.notificaciones_service.notificaciones.domain.enm.estadoNotificacion;
import com.argo.notificaciones_service.notificaciones.infrastructure.api.dto.mensaje;
import com.argo.notificaciones_service.utils.IAccess;
import com.argo.notificaciones_service.utils.ObtenerUsuario;
import com.commons.user.models.entity.accessUser.domain.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class NotificacionesService {


    private final String GENERAL = "/secured/user/queue/specific-user/nuevo/";
    private final String TRASLADO = "/secured/user/queue/specific-user/";
    private final INotificaciones iNotificaciones;
    @Autowired
    private final RestTemplate restTemplate;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private ObtenerUsuario obtenerUsuario;
    @Autowired
    private IAccess iAccess;


    @Autowired
    public NotificacionesService(INotificaciones iNotificaciones, RestTemplate restTemplate) {

        this.iNotificaciones = iNotificaciones;

        this.restTemplate = restTemplate;
    }

    @Transactional
    public void agregarNotificacionTraslado(RequerimientoDTO requerimientoDTO) {


        Notificaciones notificaciones = new Notificaciones();
        notificaciones.setIdRequerimiento(requerimientoDTO.getCodigoRequerimiento());
        notificaciones.setTipoRequerimiento(requerimientoDTO.getTipoRequerimiento());
        System.out.println(requerimientoDTO.getTipoRequerimiento());
        notificaciones.setIdAlmacen(requerimientoDTO.getAlmacenRecibe());

        Notificaciones save = this.iNotificaciones.save(notificaciones);


    }

    public List<Notificaciones> misNotificaciones(int id) {


        System.out.println("entre aca");
        return this.iNotificaciones.findByIdAlmacen(id);


    }

    @Transactional
    public void removerNotificacion(String idRequerimiento) {


        this.iNotificaciones.deleteById(idRequerimiento);
        System.out.println("borrado con exito");

    }

    @Transactional
    public void verNotificaciones(int idalmacen) {


        this.iNotificaciones.findByIdAlmacen(idalmacen).stream().forEach(notificaciones -> {

            notificaciones.setEstado(estadoNotificacion.REVISADO);
            Notificaciones save = this.iNotificaciones.save(notificaciones);

        });


    }

    private void enviarNotificacionGeneral(RequerimientoDTO idAlmacen) {

        this.agregarNotificacionTraslado(idAlmacen);
        List<Notificaciones> notificaciones = this.misNotificaciones(idAlmacen.getAlmacenRecibe());
        List<mensaje> collect = notificaciones.stream().map(notificaciones1 -> {

            mensaje m = new mensaje();
            m.setMensaje("Tiene un nuevo requerimiento de " + notificaciones1.getTipoRequerimiento().toString());
            m.setIdRequerimiento(notificaciones1.getIdRequerimiento());
            m.setEstadoNotificacion(notificaciones1.getEstado());
            m.setTipoRequerimiento(notificaciones1.getTipoRequerimiento());
            return m;
        }).collect(Collectors.toList());
        String s = String.valueOf(idAlmacen.getAlmacenRecibe());

        this.simpMessagingTemplate.convertAndSend(GENERAL + s, collect);
    }

    private void enviarNotificacionConfirmacion(RequerimientoDTO requerimiento, String token) {
        String url = "";
        if (requerimiento.getTipoRequerimiento() == TipoRequerimiento.NECESIDAD) {
            url = TRASLADO;
            this.removerNotificacion(requerimiento.getCodigoRequerimiento());

            List<Access> accesses = this.obtenerUsuario.pushUser(requerimiento.getCodigoRequerimiento());
            RequerimientoModelo requerimientoModelo = this.obtenerUsuario.objetoRequerimiento(requerimiento.getCodigoRequerimiento());
            for (Access access : accesses) {

                Map<String, Object> to = new HashMap<>();

                Map<String, Object> notification = new HashMap<>();
                notification.put("body", "El requerimiento  "+requerimiento.getCodigoRequerimiento()+" fue "+requerimientoModelo.getEstado());
                notification.put("title", "Solicitud de requerimiento");

                Date fechaEntrega = requerimientoModelo.getFechaEntrega();
                Date fechaEmision = requerimientoModelo.getFechaEmision();
                String fechaentrega=fechaEntrega.getYear()+"-"+fechaEntrega.getMonth()+"-"+fechaEntrega.getDate();
                String fechaemision=fechaEmision.getYear()+"-"+fechaEmision.getMonth()+"-"+fechaEmision.getDate();

                RequermientoModleoEnvio requermientoModleoEnvio =new RequermientoModleoEnvio(requerimientoModelo.getEstado(),fechaemision,fechaentrega,requerimientoModelo.getObservaciones(),requerimientoModelo.getAlmacenPideRequerimiento(),requerimientoModelo.getAlmacenRecibeRequerimiento(),
                        requerimientoModelo.getRequeridoPor(),requerimientoModelo.getDetalles());



                Map<String,Object> req =new HashMap<>();
                System.out.println("el tama es "+requerimientoModelo.getDetalles().size());

                req.put("click_action", "FLUTTER_NOTIFICATION_CLICK");
                req.put("req", requermientoModleoEnvio);
                to.put("data", req);



                String urls = "https://fcm.googleapis.com/fcm/send";


                mensajesss m = new mensajesss();
                m.setNotification(notification);
                m.setTo(access.getSessionId());
                m.setPriority("high");
                m.setData(req);


                System.out.println(m);
                HttpHeaders headers = new HttpHeaders();
                headers.add("Authorization ", "Bearer AAAAh9jU3jo:APA91bF-f1Sq97C1FHgFVxLaiy3GAprO_jy61HWGWRWUGbHY644GG08LjPPd1-ARyTj2ggNNXZ0TJB3JWz77_w9TYS-oLcbZe02b34E5Aa2mPDWSxuZKGl2LnrjJIYhXgY8hThT6rko7");
                headers.add("Content-Type", "application/json");


                HttpEntity<?> requestEntity =
                        new HttpEntity<>(m, headers);


                System.out.println("cacaaa");
                ResponseEntity<Map> exchange = this.restTemplate.exchange(urls, HttpMethod.POST, requestEntity,
                        Map.class);
                exchange.getBody().forEach((o, o2) -> {
                    System.out.println(o);
                    System.out.println(o2);
                });
            }


        }
        if (requerimiento.getTipoRequerimiento() == TipoRequerimiento.NOSTOCK) {
            url = GENERAL;
            this.agregarNotificacionTraslado(requerimiento);
        }


        List<Notificaciones> notificaciones = this.misNotificaciones(requerimiento.getAlmacenRecibe());
        List<mensaje> collect = notificaciones.stream().map(notificaciones1 -> {

            mensaje m = new mensaje();
            m.setMensaje("Tiene un nuevo requerimiento de " + notificaciones1.getTipoRequerimiento().toString());
            m.setIdRequerimiento(notificaciones1.getIdRequerimiento());
            m.setEstadoNotificacion(notificaciones1.getEstado());
            m.setTipoRequerimiento(notificaciones1.getTipoRequerimiento());
            return m;
        }).collect(Collectors.toList());
        String s = String.valueOf(requerimiento.getAlmacenRecibe());
        System.out.println("este es mi 3 almacen " + s);

        this.simpMessagingTemplate.convertAndSend(url + s, collect);
    }

    private void enviarNotificacionTraslado(RequerimientoDTO requerimiento) {


        this.removerNotificacion(requerimiento.getCodigoRequerimiento());
        List<Notificaciones> notificaciones = this.misNotificaciones(requerimiento.getAlmacenRecibe());
        List<mensaje> collect = notificaciones.stream().map(notificaciones1 -> {

            mensaje m = new mensaje();
            m.setMensaje("Tiene un nuevo requerimiento de " + notificaciones1.getTipoRequerimiento().toString());
            m.setIdRequerimiento(notificaciones1.getIdRequerimiento());
            m.setEstadoNotificacion(notificaciones1.getEstado());
            m.setTipoRequerimiento(notificaciones1.getTipoRequerimiento());
            return m;
        }).collect(Collectors.toList());
        String s = String.valueOf(requerimiento.getAlmacenRecibe());
        System.out.println("este es mi 2 almacen " + s);
        this.simpMessagingTemplate.convertAndSend(TRASLADO + s, collect);

    }


    public void sendNotification(int id, RequerimientoDTO requerimientoDTO, String token) {
        System.out.println(token);
        switch (id) {

            case 1:
                this.enviarNotificacionGeneral(requerimientoDTO);
                break;


            case 2:
                this.enviarNotificacionConfirmacion(requerimientoDTO, token);
                break;

            case 3:
                this.enviarNotificacionTraslado(requerimientoDTO);
                break;


            default:
                throw new RuntimeException("error opcion invalido");


        }

    }
}
