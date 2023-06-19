package com.argo.product_service.product.infrasctructure.api;

import com.argo.product_service.product.application.dto.createProduct;
import com.argo.product_service.product.application.dto.findProduct;

import com.argo.product_service.product.application.dto.updateProduct;
import com.argo.product_service.product.application.productService;
import com.argo.product_service.product.domain.repository.IProduct;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class productController {


    private final productService service;


    private final IProduct iProduct;


    @Autowired
    public productController(@Qualifier("product-service") productService service, IProduct iProduct) {
        this.service = service;
        this.iProduct = iProduct;
    }


    @PostMapping("/product")
    public ResponseEntity<?> crearProducto(@RequestBody createProduct createProduct){

        if(!this.service.generateProduct(createProduct)){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity<?> obtenerProductos(){

        List<findProduct> lista= this.service.getAllProducts();
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> obtenerProducto(@PathVariable("id") String id){

        findProduct producto  =this.service.getProduct(id);
        return new ResponseEntity<>(producto,HttpStatus.OK);

    }
    @PutMapping("/product/{id}")
    public ResponseEntity<?> actualizarProducto(@RequestBody updateProduct dto,@PathVariable("id") String codigo){


        if(!this.service.updateProduct(dto,codigo)){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(HttpStatus.OK);

    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> borrarProducto(@PathVariable("id")String code){


        if(!this.service.deleteProduct(code)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
