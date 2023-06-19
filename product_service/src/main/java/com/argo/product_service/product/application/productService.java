package com.argo.product_service.product.application;

import com.argo.product_service.product.application.dto.createProduct;
import com.argo.product_service.product.application.dto.findProduct;
import com.argo.product_service.product.application.dto.updateProduct;
import com.argo.product_service.product.domain.Product;
import com.argo.product_service.product.domain.TypeProduct;
import com.argo.product_service.product.domain.features;
import com.argo.product_service.product.domain.repository.IFeatures;
import com.argo.product_service.product.domain.repository.IProduct;
import com.argo.product_service.product.domain.repository.IType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service("product-service")
public class productService {

    private final IFeatures iFeatures;
    private final IProduct iProduct;
    private final IType iType;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    public productService(IFeatures iFeatures, IProduct iProduct, IType iType) {
        this.iFeatures = iFeatures;
        this.iProduct = iProduct;
        this.iType = iType;
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean saveProduct(features f) {

        try {


            this.iFeatures.save(f);
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }

    }


    public boolean generateProduct(createProduct dto) {
        try {
            Product p = new Product();
            p.setIdTypeProduct(this.iType.findById(dto.getTipoProducto()).orElseThrow(() -> new RuntimeException("d")));
            p.setPrecioUnitario(dto.getPrecioUnitarioActualizado());
            p.setDescripcion(dto.getDescripcion());
            p.setCodigo(dto.getCodigo());
            features f = new features();
            f.setColor(dto.getColor());
            f.setMarca(dto.getMarca());
            f.setModelo(dto.getModelo());
            f.setTalla(dto.getTalla());
            f.setIdProduct(p);
            return this.saveProduct(f);
        } catch (Exception ex) {
            return false;
        }
    }


    public List<findProduct> getAllProducts() {


        return this.iProduct.findProduct();


    }

    public findProduct getProduct(String id) {


        return this.iProduct.findProduct(id).orElse(null);


    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateProduct(updateProduct dto, String codigo) {

        try {

            Optional<Product> optionalProduct = this.iProduct.findById(codigo);

            if (optionalProduct.isEmpty()) {
                return false;
            }
            Product product = optionalProduct.get();
            product.getIdFeatures().setMarca(dto.getMarca());
            product.getIdFeatures().setModelo(dto.getModelo());
            product.getIdFeatures().setColor(dto.getColor());
            product.getIdFeatures().setTalla(dto.getTalla());
            product.setPrecioUnitario(dto.getPrecioUnitarioActualizado());
            product.setDescripcion(dto.getDescripcion());
            product.setIdTypeProduct(this.iType.getOne(dto.getTipoProducto()));
            return true;


        } catch (Exception exception) {

            return false;
        }


    }







    @Transactional(rollbackFor = Exception.class)
    public boolean deleteProduct(String code) {

        try {

            Product one = this.iProduct.getOne(code);
            this.iProduct.deleteById(code);
            ProductServiceEvent p  =new ProductServiceEvent();
            p.setProduct(one);
            p.setEstado("delete");
            this.applicationEventPublisher.publishEvent(p);
            return true;


        } catch (Exception ex) {
            return false;
        }

    }




    public static class ProductServiceEvent {

        public String estado;
        public Product product;
        public ProductServiceEvent() {
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }
    }

}
