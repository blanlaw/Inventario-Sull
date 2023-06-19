package com.argo.inventario_service.requerimiento.infrastructure.api;

import com.argo.inventario_service.requerimiento.application.RequerimientoService;
import com.argo.inventario_service.requerimiento.application.models.RequerimientoModel;
import com.argo.inventario_service.requerimiento.application.models.RequerimientoModelTraslado;
import com.argo.inventario_service.requerimiento.application.models.RequerimientoModelo;
import com.argo.inventario_service.requerimiento.domain.Requerimiento;
import com.argo.inventario_service.requerimiento.infrastructure.api.dto.RequerimientoDTO;
import com.argo.inventario_service.util.enviarNotificacion;
import com.commons.user.models.entity.accessUser.domain.Access;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * The type Requerimiento controller.
 */
@RestController
@RequestMapping("/requerimiento")
public class RequerimientoController {


    private final RequerimientoService requerimientoService;


    /**
     * Instantiates a new Requerimiento controller.
     *
     * @param requerimientoService the requerimiento service
     */
    @Autowired
    public RequerimientoController(RequerimientoService requerimientoService) {
        this.requerimientoService = requerimientoService;

    }


    /**
     * Crear requerimiento general response entity.
     *
     * @param request the request
     * @param modelo  the modelo
     * @return the response entity
     */
    @PostMapping("")
    public ResponseEntity<?> crearRequerimientoGeneral(HttpServletRequest request, @RequestBody RequerimientoModel modelo) {

        String token = request.getHeader("Authorization");


        Requerimiento requerimiento = this.requerimientoService.crearRequerimientoGeneral(modelo, token);




        return new ResponseEntity<>(HttpStatus.OK);

    }


    /**
     * Confirmar requerimiento response entity.
     *
     * @param request   the request
     * @param codigoreq the codigoreq
     * @return the response entity
     */
    @GetMapping("/confirmar/{id}")
    public ResponseEntity<?> confirmarRequerimiento(HttpServletRequest request, @PathVariable("id") String codigoreq) {
        String token = request.getHeader("Authorization");


        Requerimiento requerimiento = this.requerimientoService.confirmarRequerimiento(token, codigoreq);



        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Confirmar requerimiento traslado response entity.
     *
     * @param request   the request
     * @param codigoreq the codigoreq
     * @return the response entity
     */
    @GetMapping("/confirmar/traslado/{id}")
    public ResponseEntity<?> confirmarRequerimientoTraslado(HttpServletRequest request, @PathVariable("id") String codigoreq) {
        String token = request.getHeader("Authorization");


        Requerimiento requerimiento = this.requerimientoService.confirmarTraslado(token, codigoreq);


        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * Crear requerimiento traslado response entity.
     *
     * @param request the request
     * @param modelo  the modelo
     * @return the response entity
     */
    @PostMapping("/traslado")
    public ResponseEntity<?> crearRequerimientoTraslado(HttpServletRequest request, @RequestBody RequerimientoModelTraslado modelo) {

        String token = request.getHeader("Authorization");

        Requerimiento requerimiento = this.requerimientoService.crearRequermientoTraslado(modelo, token);


        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * Mis rquerimientos list.
     *
     * @param request the request
     * @return the list
     */
    @GetMapping("/me")
    public List misRquerimientos(HttpServletRequest request) {

        String token = request.getHeader("Authorization");

        return this.requerimientoService.misRequermientos(token);


    }

    /**
     * Peticiones requerimiento yo map.
     *
     * @param request the request
     * @return the map
     */
    @GetMapping("/todo")
    public Map peticionesRequerimientoYo(HttpServletRequest request) {

        String token = request.getHeader("Authorization");


        return this.requerimientoService.misPeticiones(token);


    }

    /**
     * Detalles requerimiento response entity.
     *
     * @param request   the request
     * @param codigoreq the codigoreq
     * @return the response entity
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> detallesRequerimiento(HttpServletRequest request, @PathVariable("id") String codigoreq) {
        String token = request.getHeader("Authorization");


        Requerimiento requerimiento = this.requerimientoService.detallesRequerimiento(token, codigoreq);

        return new ResponseEntity<>(requerimiento, HttpStatus.OK);
    }

    /**
     * Recharza requerimiento response entity.
     *
     * @param codigo the codigo
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> recharzaRequerimiento(@PathVariable("id") String codigo) {

        boolean b = this.requerimientoService.rechazarRequerimiento(codigo);
        if (!b) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * Rechazar requerimiento traslado response entity.
     *
     * @param codigo the codigo
     * @return the response entity
     */
    @DeleteMapping("/traslado/{id}")
    public ResponseEntity<?> rechazarRequerimientoTraslado(@PathVariable("id") String codigo) {
        boolean b = this.requerimientoService.rechazarRequerimientoTraslado(codigo);
        if (!b) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * Push user list.
     *
     * @param codigo the codigo
     * @return the list
     */
    @GetMapping("/me/{id}")
    public List<Access> pushUser( @PathVariable("id") String codigo ){



        return this.requerimientoService.buscarUsuariosPorRequerimiento(codigo);



    }

    /**
     * Objeto requerimiento requerimiento modelo.
     *
     * @param id the id
     * @return the requerimiento modelo
     */
    @GetMapping("/getRequerimiento/{id}")
    public RequerimientoModelo objetoRequerimiento(@PathVariable("id")String id){

        return this.requerimientoService.buscarRequerimiento(id);

    }
}
