package com.argo.inventario_service.util;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type Transformar fecha.
 */
@Service
public class transformarFecha {
    /**
     * Convertir fecha date.
     *
     * @param fecha the fecha
     * @return the date
     */
    public Date convertirFecha(String fecha) {

        DateFormat dateTimeFormatter = new SimpleDateFormat("YYYY/MM/DD");
        try {
            return dateTimeFormatter.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Obtener fecha date.
     *
     * @param fecha the fecha
     * @return the date
     */
    public Date obtenerFecha(Date fecha) {

        SimpleDateFormat formato = new SimpleDateFormat("YYYY/MM/DD");
        String format = formato.format(fecha);
        try {
            return formato.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

}
