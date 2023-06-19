package com.argo.inventario_service.reporte;

import com.argo.inventario_service.reporte.models.ReporteModelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * The type Reporte controller.
 */
@RestController
@RequestMapping("/reporte")
public class reporteController {

    /**
     * The Pdf generator.
     */
    @Autowired
    pdfGenerator pdfGenerator;
    @Autowired
    private ReporteService reporteService;


    /**
     * Obtener reporte reporte modelo.
     *
     * @param request the request
     * @param idmes   the idmes
     * @return the reporte modelo
     */
    @GetMapping("/{id}")
    public ReporteModelo obtenerReporte(HttpServletRequest request, @PathVariable("id") int idmes) {

        String token = request.getHeader("Authorization");
        return this.reporteService.reportePorMes(idmes,token);


    }

    /**
     * Generar pdf response entity.
     *
     * @param token the token
     * @param idmes the idmes
     * @return the response entity
     */
    @PostMapping("/{mes}")
    public ResponseEntity<?> generarPdf(@RequestHeader("Authorization") String token, @PathVariable("mes") int idmes) {
        Date date = new Date();


        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte" + date + ".pdf");


        return ResponseEntity
                .ok()
                .headers(headers)

                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(this.reporteService.generarPdf(token, idmes));


    }

    /**
     * Obtener reporte reporte modelo.
     *
     * @param request the request
     * @return the reporte modelo
     */
    @GetMapping("")
    public ReporteModelo obtenerReporte(HttpServletRequest request){

        String token=request.getHeader("Authorization");
        return this.reporteService.cargarReporte(token);


    }


}
