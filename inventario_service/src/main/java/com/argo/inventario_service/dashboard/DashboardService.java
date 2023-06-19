package com.argo.inventario_service.dashboard;

import com.argo.inventario_service.area.domain.repository.IAlmacen;
import com.argo.inventario_service.dashboard.models.SalidasSemanales;
import com.argo.inventario_service.dashboard.models.dashboardModel;
import com.argo.inventario_service.dashboard.models.entradasSemanales;
import com.argo.inventario_service.dashboard.models.requerimientoModelDashboard;
import com.argo.inventario_service.movimientos.domain.repository.IEntrada;
import com.argo.inventario_service.movimientos.domain.repository.IEntradaDetalles;
import com.argo.inventario_service.movimientos.domain.repository.ISalida;
import com.argo.inventario_service.movimientos.domain.repository.ISalidaDetalles;
import com.argo.inventario_service.producto.application.models.productoModels;
import com.argo.inventario_service.producto.domain.repository.ICodigoProducto;
import com.argo.inventario_service.producto.domain.repository.IProduct;
import com.argo.inventario_service.reporte.ReporteService;
import com.argo.inventario_service.requerimiento.domain.enm.EstadoRequerimiento;
import com.argo.inventario_service.requerimiento.domain.repository.IDetallesRequerimiento;
import com.argo.inventario_service.requerimiento.domain.repository.IRequerimiento;
import com.argo.inventario_service.util.obtenerusuario;
import com.argo.inventario_service.util.transformarFecha;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * The type Dashboard service.
 */
@Service
public class DashboardService {

    private final IEntradaDetalles iEntradaDetalles;
    private final IEntrada iEntrada;
    private final IProduct iProduct;
    private final IRequerimiento iRequerimiento;
    private final IDetallesRequerimiento iDetallesRequerimiento;
    private final transformarFecha fecha;
    private final ICodigoProducto iCodigoProducto;
    private final IAlmacen iAlmacen;
    private final ISalida iSalida;
    private final ISalidaDetalles iSalidaDetalles;
    private final ReporteService reporteService;
    @Autowired
    private obtenerusuario getUser;

    /**
     * Instantiates a new Dashboard service.
     *
     * @param iEntradaDetalles       the entrada detalles
     * @param iEntrada               the entrada
     * @param iProduct               the product
     * @param iRequerimiento         the requerimiento
     * @param iDetallesRequerimiento the detalles requerimiento
     * @param fecha                  the fecha
     * @param iCodigoProducto        the codigo producto
     * @param iAlmacen               the almacen
     * @param iSalida                the salida
     * @param iSalidaDetalles        the salida detalles
     * @param reporteService         the reporte service
     */
    public DashboardService(IEntradaDetalles iEntradaDetalles, IEntrada iEntrada, IProduct iProduct, IRequerimiento iRequerimiento, IDetallesRequerimiento iDetallesRequerimiento, transformarFecha fecha, ICodigoProducto iCodigoProducto, IAlmacen iAlmacen, ISalida iSalida, ISalidaDetalles iSalidaDetalles, ReporteService reporteService) {
        this.iEntradaDetalles = iEntradaDetalles;
        this.iEntrada = iEntrada;
        this.iProduct = iProduct;
        this.iRequerimiento = iRequerimiento;
        this.iDetallesRequerimiento = iDetallesRequerimiento;
        this.fecha = fecha;
        this.iCodigoProducto = iCodigoProducto;
        this.iAlmacen = iAlmacen;
        this.iSalida = iSalida;
        this.iSalidaDetalles = iSalidaDetalles;
        this.reporteService = reporteService;
    }


    /**
     * Dashboard data dashboard model.
     *
     * @param token the token
     * @return the dashboard model
     */
    public dashboardModel dashboardData(String token) {

        User user = this.getUser.getUser(token);
        Almacen almacen = user.getIdAlmacen();


        int espera = (int) this.iRequerimiento.countByAlmacenPideAndEstadoRequerimiento(almacen, EstadoRequerimiento.ESPERA);
        int entradas = (int) this.iEntradaDetalles.misEntradas(almacen);
        int salidas = (int) this.iSalidaDetalles.misSalidas(almacen);


        List<entradasSemanales> listaEntradaSemanales = new ArrayList<>();
        List<SalidasSemanales> listaSalidasSemanales = new ArrayList<>();
        LocalDate loc = LocalDate.now();
        LocalDate lunesDate = loc.with(WeekFields.of(Locale.getDefault()).getFirstDayOfWeek());
        for (int i = 1; i < 8; i++) {

            List entradas1 = this.iEntrada.entrasByDateOfWeek( lunesDate.toString(),almacen.getIdAlmacen());
            List salidas1 = this.iSalida.salidasByDateOfWeek(lunesDate.toString(),almacen.getIdAlmacen());
            entradasSemanales entradasSemanales = new entradasSemanales();
            entradasSemanales.setDay(i);
            entradasSemanales.setEntradas(entradas1.size());
            SalidasSemanales salidasSemanales = new SalidasSemanales();
            salidasSemanales.setDay(i);
            salidasSemanales.setSalidas(salidas1.size());
            listaEntradaSemanales.add(entradasSemanales);
            listaSalidasSemanales.add(salidasSemanales);


            lunesDate = lunesDate.withDayOfMonth(lunesDate.getDayOfMonth() + 1);


        }

        int cantidadProductos = (int) this.iProduct.cantidadProductos(almacen);


        List<requerimientoModelDashboard> aceptado = this.iRequerimiento.dashboardRequerimiento(almacen, EstadoRequerimiento.ACEPTADO, PageRequest.of(0, 4));
        List<requerimientoModelDashboard> esperalista = this.iRequerimiento.dashboardRequerimiento(almacen, EstadoRequerimiento.ESPERA, PageRequest.of(0, 4));
        List<requerimientoModelDashboard> rechazado = this.iRequerimiento.dashboardRequerimiento(almacen, EstadoRequerimiento.RECHAZADO, PageRequest.of(0, 4));
        List<productoModels> productoModels = this.iProduct.productosDashboard(almacen, PageRequest.of(0, 4));
        dashboardModel modelo = new dashboardModel();
        modelo.setEntradaProductos(entradas);
        modelo.setCantidadProductos(cantidadProductos);
        modelo.setReqespera(espera);
        modelo.setSalidaProductos(salidas);
        modelo.setListaRequerimientosAceptado(aceptado);
        modelo.setListaRequerimientosRechazado(rechazado);
        modelo.setListaRequerimientosEspera(esperalista);
        modelo.setListaProductos(productoModels);
        modelo.setListaEntradasSemanales(listaEntradaSemanales);
        modelo.setListaSalidasSemanales(listaSalidasSemanales);
        return modelo;

    }


    /**
     * Reporte by mes.
     *
     * @param mes the mes
     */
    public void reporteByMes(int mes){




    }


}
