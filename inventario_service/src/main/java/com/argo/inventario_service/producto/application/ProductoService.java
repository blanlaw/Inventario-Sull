package com.argo.inventario_service.producto.application;

import com.argo.inventario_service.area.domain.repository.IAlmacen;
import com.argo.inventario_service.producto.application.models.CodigoList;
import com.argo.inventario_service.producto.domain.CodigoProducto;
import com.argo.inventario_service.producto.domain.ProductoAlmacen;
import com.argo.inventario_service.producto.domain.repository.CodigoListNuevo;
import com.argo.inventario_service.producto.domain.repository.ICodigoProducto;
import com.argo.inventario_service.producto.domain.repository.IProduct;
import com.argo.inventario_service.producto.domain.repository.IType;
import com.argo.inventario_service.util.obtenerusuario;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * The type Producto service.
 */
@Service
public class ProductoService {


    @Autowired
    private final ICodigoProducto iCodigoProducto;
    private final IProduct iProduct;
    private final IType iType;
    private final IAlmacen iAlmacen;

    @Autowired
    private obtenerusuario obtenerusuario;

    /**
     * Instantiates a new Producto service.
     *
     * @param iCodigoProducto the codigo producto
     * @param iProduct        the product
     * @param iType           the type
     * @param iAlmacen        the almacen
     */
    public ProductoService(ICodigoProducto iCodigoProducto, IProduct iProduct, IType iType, IAlmacen iAlmacen) {
        this.iCodigoProducto = iCodigoProducto;
        this.iProduct = iProduct;
        this.iType = iType;
        this.iAlmacen = iAlmacen;
    }


    /**
     * Lista codigo productos list.
     *
     * @param token the token
     * @return the list
     */
    public List listaCodigoProductos(String token) {


        int idAlmacen = this.obtenerusuario.getUser(token).getIdAlmacen().getIdAlmacen();
        return this.iCodigoProducto.listaCodigoProductosMovil(idAlmacen);


    }


    /**
     * Buscar por nombre list.
     *
     * @param idalmacen the idalmacen
     * @param codigo    the codigo
     * @return the list
     */
    public List buscarPorNombre(int idalmacen, String codigo) {

        Almacen almacen = this.iAlmacen.findById(idalmacen).get();


        return this.iCodigoProducto.buscarPorNombre().stream().filter(productoAlmacen -> {

            String descripcion = productoAlmacen.getId().getCodigo().getDescripcion().toUpperCase();
            return productoAlmacen.getId().getIdAlmacen() == almacen && descripcion.contains(codigo.toUpperCase());


        }).map(productoAlmacen -> {

            CodigoProducto codigo1 = productoAlmacen.getId().getCodigo();
            return new CodigoList() {
                @Override
                public String getCodigo() {
                    return codigo1.getCodigo();
                }

                @Override
                public String getDescripcion() {
                    return codigo1.getDescripcion();
                }

                @Override
                public String getModelo() {
                    return codigo1.getModelo();
                }

                @Override
                public String getMarca() {
                    return codigo1.getMarca();
                }

                @Override
                public String getColor() {
                    return codigo1.getColor();
                }

                @Override
                public String getTalla() {
                    return codigo1.getTalla();
                }

                @Override
                public String getTipo() {
                    return codigo1.getTipo().getTipo();
                }

                @Override
                public int getCantidad() {
                    return productoAlmacen.getStock();
                }
            };


        }).collect(Collectors.toList());


    }

    /**
     * Todos list.
     *
     * @param token the token
     * @return the list
     */
    public List todos(String token) {

        User user = this.obtenerusuario.getUser(token);
        Almacen idAlmacen = user.getIdAlmacen();
        return this.iProduct.listaEntera(idAlmacen);


    }

    /**
     * Todos 2 list.
     *
     * @param token the token
     * @return the list
     */
    public List todos2(String token) {
        User user = this.obtenerusuario.getUser(token);
        Almacen idAlmacen = user.getIdAlmacen();
        List<ProductoAlmacen> producto = this.iProduct.getProducto(idAlmacen.getIdAlmacen());
        List<ProductoAlmacen> producto2 = new ArrayList<>(producto);


        AtomicReference<List<ProductoAlmacen>> valoresRepetidos = new AtomicReference<>();
        valoresRepetidos.set(new ArrayList<>());
        return producto.stream().map(productoAlmacen -> {

            List<ProductoAlmacen> collect1 = producto2.stream().filter(pros -> pros.getId().getIndex().equals(productoAlmacen.getId().getIndex()) && pros.getId().getCodigo().equals(productoAlmacen.getId().getCodigo())).collect(Collectors.toList());

            if (!valoresRepetidos.get().contains(productoAlmacen)) {

                valoresRepetidos.get().addAll(collect1);
                return collect1;
            }
            return null;

        }).filter(Objects::nonNull)

                .map(productoAlmacens -> {

                    int stock = productoAlmacens.stream().mapToInt(ProductoAlmacen::getStock).sum();
                    ProductoAlmacen productoAlmacen = productoAlmacens.get(productoAlmacens.size() - 1);


                    return new CodigoListNuevo() {
                        @Override
                        public String getCodigo() {
                            return productoAlmacen.getId().getCodigo().getCodigo();
                        }

                        @Override
                        public String getDescripcion() {
                            return productoAlmacen.getId().getCodigo().getDescripcion();
                        }

                        @Override
                        public String getModelo() {
                            return productoAlmacen.getId().getCodigo().getModelo();
                        }

                        @Override
                        public String getMarca() {
                            return productoAlmacen.getId().getCodigo().getMarca();
                        }

                        @Override
                        public String getColor() {
                            return productoAlmacen.getId().getCodigo().getColor();
                        }

                        @Override
                        public String getTalla() {
                            return productoAlmacen.getId().getCodigo().getTalla();
                        }

                        @Override
                        public String getTipo() {
                            return productoAlmacen.getId().getCodigo().getTipo().getTipo();

                        }

                        @Override
                        public BigDecimal getPrecio() {
                            return productoAlmacen.getId().getCodigo().getPrecioUnitario();
                        }

                        @Override
                        public int getCantidad() {
                            return stock;
                        }
                    };

                }).filter(Objects::nonNull).collect(Collectors.toList());

    }


    /**
     * Lista tipo list.
     *
     * @return the list
     */
    public List listaTipo() {


        return this.iCodigoProducto.listaTipo().stream().map(tipoProducto -> {
            Map mapa = new HashMap();
            mapa.put("tipo", tipoProducto.getTipo());
            mapa.put("id", tipoProducto.getIdTipo());
            return mapa;

        }).collect(Collectors.toList());


    }

    /**
     * Lista nombres list.
     *
     * @return the list
     */
    public List listaNombres() {


        return this.iCodigoProducto.findNombres().stream().map(s -> {


            Map mapa = new HashMap();
            mapa.put("nombre", s);
            return mapa;

        }).collect(Collectors.toList());


    }


    /**
     * Lista modelo list.
     *
     * @return the list
     */
    public List listaModelo() {


        return this.iCodigoProducto.listaModelo().stream().map(s -> {


            Map mapa = new HashMap();
            mapa.put("modelo", s);
            return mapa;


        }).collect(Collectors.toList());


    }


    /**
     * Lista marca list.
     *
     * @return the list
     */
    public List listaMarca() {


        return this.iCodigoProducto.listaMarca().stream().map(s -> {
            Map mapa = new HashMap();
            mapa.put("marca", s);
            return mapa;


        }).collect(Collectors.toList());

    }

    /**
     * Lista color list.
     *
     * @return the list
     */
    public List listaColor() {


        return this.iCodigoProducto.listaColor().stream().map(s -> {
            Map mapa = new HashMap();
            mapa.put("color", s);
            return mapa;


        }).collect(Collectors.toList());

    }


    /**
     * Lista talla list.
     *
     * @return the list
     */
    public List listaTalla() {


        return this.iCodigoProducto.listaTalla().stream().map(s -> {
            Map mapa = new HashMap();
            mapa.put("talla", s);
            return mapa;


        }).collect(Collectors.toList());

    }


    /**
     * Lista precio list.
     *
     * @return the list
     */
    public List listaPrecio() {


        return this.iCodigoProducto.listaPrecio().stream().map(s -> {
            Map mapa = new HashMap();
            mapa.put("precio", s);
            return mapa;


        }).collect(Collectors.toList());

    }

    /**
     * Lista unidad medida list.
     *
     * @return the list
     */
    public List listaUnidadMedida() {


        return this.iCodigoProducto.listaUnidadMedida().stream().map(s -> {
            Map mapa = new HashMap();
            mapa.put("unidad", s);
            return mapa;


        }).collect(Collectors.toList());

    }


}
