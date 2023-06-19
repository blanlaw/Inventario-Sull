package com.argo.inventario_service.movimientos.infrastructure.api;

import com.argo.inventario_service.movimientos.application.EntradaService;
import com.argo.inventario_service.movimientos.application.SalidaService;
import com.argo.inventario_service.movimientos.application.models.detallesEntradaModel;
import com.argo.inventario_service.movimientos.application.models.entradaModel;
import com.argo.inventario_service.movimientos.application.models.salidaModel;
import com.argo.inventario_service.movimientos.domain.Entrada;
import com.argo.inventario_service.movimientos.domain.Salida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * The type Movimiento controller.
 */
@RestController
@RequestMapping("/movimiento")
public class MovimientoController {


    /**
     * The Entrada service.
     */
    @Autowired
    public EntradaService entradaService;

    /**
     * The Salida service.
     */
    @Autowired
    public SalidaService salidaService;

    /**
     * Confirmar entrada.
     *
     * @param request the request
     * @param modelo  the modelo
     * @param codigo  the codigo
     */
    @PostMapping("/confirmar/entrada/{id}")
    public void confirmarEntrada(HttpServletRequest request, @RequestBody entradaModel modelo, @PathVariable("id") int codigo) {

        String token = request.getHeader("Authorization");


        this.entradaService.confirmarEntrada(codigo, modelo, token);


    }


    /**
     * Confirmar salida.
     *
     * @param request the request
     * @param modelo  the modelo
     * @param codigo  the codigo
     */
    @PostMapping("/confirmar/salida/{id}")
    public void confirmarSalida(HttpServletRequest request, @RequestBody salidaModel modelo, @PathVariable("id") int codigo) {

        String token = request.getHeader("Authorization");


        this.salidaService.confirmarSalida(modelo, codigo, token);


    }


    /**
     * Mis salidas list.
     *
     * @param request the request
     * @return the list
     */
    @GetMapping("/salida/me")
    public List misSalidas(HttpServletRequest request) {
        String token = request.getHeader("Authorization");


        return this.salidaService.misSalidas(token);

    }

    /**
     * Mis entradas list.
     *
     * @param request the request
     * @return the list
     */
    @GetMapping("/entrada/me")
    public List misEntradas(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        return this.entradaService.misEntradas(token);

    }

    /**
     * Mis salida salida.
     *
     * @param request the request
     * @param id      the id
     * @return the salida
     */
    @GetMapping("/salida/{id}")
    public Salida misSalida(HttpServletRequest request, @PathVariable("id") int id) {
        String token = request.getHeader("Authorization");


        return this.salidaService.detalleSalida(token, id);

    }

    /**
     * Mi entrada detalles entrada model.
     *
     * @param request the request
     * @param id      the id
     * @return the detalles entrada model
     */
    @GetMapping("/entrada/{id}")
    public detallesEntradaModel miEntrada(HttpServletRequest request, @PathVariable("id") int id) {
        String token = request.getHeader("Authorization");

        return this.entradaService.detalleEntrada(token, id);

    }


}
