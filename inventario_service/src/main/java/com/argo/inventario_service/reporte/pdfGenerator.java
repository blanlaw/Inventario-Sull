package com.argo.inventario_service.reporte;


import com.argo.inventario_service.reporte.models.DetallesReporteModelo;
import com.argo.inventario_service.reporte.models.ReporteModelo;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Pdf generator.
 */
@Service
public class pdfGenerator {


    /**
     * Generar pdf byte array resource.
     *
     * @param reporteModelo the reporte modelo
     * @return the byte array resource
     */
    public ByteArrayResource generarPdf(ReporteModelo reporteModelo) {

        String logo="C:\\Users\\loser\\Downloads\\sull\\logo.jpg";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        List<DetallesReporteModelo> detalles = reporteModelo.getDetalles();

        try {
            File file = ResourceUtils.getFile("classpath:reporte.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource tableDataset = new JRBeanCollectionDataSource(reporteModelo.getDetalles());


            Map<String, Object> par = new HashMap<>();
            par.put("createdBy", "sulluscocha");
            par.put("sal",reporteModelo.getTotalExistenciasSalidas());
            par.put("tol",reporteModelo.getTotaExistencias());
            par.put("logo",logo);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, par, tableDataset);
           //  JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\asdrian\\Desktop\\reporte.pdf");
            byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
            InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(bytes));
            ByteArrayResource arrayResource =new ByteArrayResource(bytes);
            return arrayResource;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("error");
        }


    }
}
