package com.argo.inventario_service.producto.infrastructure.api;

import com.argo.inventario_service.producto.application.OrdenCompraService;
import com.argo.inventario_service.producto.application.ProductoService;
import com.argo.inventario_service.producto.application.models.detalles.ordenCompramodeloDetalles;
import com.argo.inventario_service.producto.application.models.ordenCompraModel;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * The type Producto controller.
 */
@RestController
@RequestMapping("/producto")
public class ProductoController {


    /**
     * The constant AUTH.
     */
    public static final String AUTH = "Authorization";

    private final OrdenCompraService ordenCompraService;
    private final ProductoService productoService;

    /**
     * Instantiates a new Producto controller.
     *
     * @param ordenCompraService the orden compra service
     * @param productoService    the producto service
     */
    public ProductoController(OrdenCompraService ordenCompraService, ProductoService productoService) {
        this.ordenCompraService = ordenCompraService;
        this.productoService = productoService;
    }

    /**
     * Cargar lista productos list.
     *
     * @param request the request
     * @return the list
     */
    @GetMapping("")
    public List cargarListaProductos(HttpServletRequest request) {


        String token = request.getHeader("Authorization");

        return this.productoService.listaCodigoProductos(token);

    }

    /**
     * Todos list.
     *
     * @param request the request
     * @return the list
     */
    @GetMapping("/todos")
    public List todos(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        return this.productoService.todos2(token);
    }


    /**
     * Crear orden compra.
     *
     * @param request the request
     * @param modelo  the modelo
     */
    @PostMapping("/orden")
    public void crearOrdenCompra(HttpServletRequest request, @RequestBody ordenCompraModel modelo) {

        String token = request.getHeader(AUTH);


        this.ordenCompraService.crearOrdenCompraNuevo(token, modelo);

    }

    /**
     * Confirmar orden.
     *
     * @param request the request
     * @param id      the id
     */
    @PostMapping("/orden/{id}")
    public void confirmarOrden(HttpServletRequest request, @PathVariable("id") String id) {
        String token = request.getHeader("Authorization");

        this.ordenCompraService.confirmarOrdenCompra(id, token);

    }


    /**
     * Buscar por nombre list.
     *
     * @param request the request
     * @param codigo  the codigo
     * @param almacen the almacen
     * @return the list
     */
    @GetMapping("/{id}/{almacen}")
    public List buscarPorNombre(HttpServletRequest request, @PathVariable("id") String codigo, @PathVariable("almacen") int almacen) {


        String token = request.getHeader(AUTH);


        return this.productoService.buscarPorNombre(almacen, codigo);
    }

    /**
     * Mis ordenes de compra list.
     *
     * @param request the request
     * @return the list
     */
    @GetMapping("/orden")
    public List misOrdenesDeCompra(HttpServletRequest request) {


        String token = request.getHeader("Authorization");


        return this.ordenCompraService.misOrdenes(token);

    }

    /**
     * Detalles orden orden compramodelo detalles.
     *
     * @param request the request
     * @param id      the id
     * @return the orden compramodelo detalles
     */
    @GetMapping("/orden/{id}")
    public ordenCompramodeloDetalles detallesOrden(HttpServletRequest request, @PathVariable("id") String id) {

        String token = request.getHeader("Authorization");


        return this.ordenCompraService.detalesOrden(token, id);

    }

    /**
     * Nombres lista list.
     *
     * @param request the request
     * @return the list
     */
    @GetMapping("/nombres")
    public List nombresLista(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        return this.productoService.listaNombres();

    }

    /**
     * Tipo list.
     *
     * @param request the request
     * @return the list
     */
    @GetMapping("/tipo")
    public List tipo(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        return this.productoService.listaTipo();

    }

    /**
     * Modelo list.
     *
     * @param request the request
     * @return the list
     */
    @GetMapping("/modelo")
    public List modelo(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        return this.productoService.listaModelo();

    }

    /**
     * Marca list.
     *
     * @param request the request
     * @return the list
     */
    @GetMapping("/marca")
    public List marca(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        return this.productoService.listaMarca();

    }

    /**
     * Color list.
     *
     * @param request the request
     * @return the list
     */
    @GetMapping("/color")
    public List color(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        return this.productoService.listaColor();

    }

    /**
     * Talla list.
     *
     * @param request the request
     * @return the list
     */
    @GetMapping("/talla")
    public List talla(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        return this.productoService.listaTalla();

    }

    /**
     * Precio list.
     *
     * @param request the request
     * @return the list
     */
    @GetMapping("/precio")
    public List precio(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        return this.productoService.listaPrecio();

    }

    /**
     * Unidad list.
     *
     * @param request the request
     * @return the list
     */
    @PostMapping("/unidad")
    public List unidad(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        return this.productoService.listaUnidadMedida();

    }


}
