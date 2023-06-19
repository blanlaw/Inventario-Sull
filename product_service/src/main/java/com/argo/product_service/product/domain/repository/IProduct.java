package com.argo.product_service.product.domain.repository;

import com.argo.product_service.product.application.dto.findProduct;
import com.argo.product_service.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProduct  extends JpaRepository<Product,String> {


    @Query("select p.codigo as codigo,p.descripcion as descripcion,f.modelo as modelo,f.marca as marca,f.color as color,f.talla as talla,tp as tipo,p.precioUnitario as precio from producto p inner join p.idTypeProduct tp inner  join p.idFeatures f")
    List<findProduct> findProduct();

    @Query("select p.codigo as codigo,p.descripcion as descripcion,f.modelo as modelo,f.marca as marca,f.color as color,f.talla as talla,tp as tipo,p.precioUnitario as precio from producto p inner join p.idTypeProduct tp inner  join p.idFeatures f where p.codigo=?1")

    Optional<findProduct> findProduct(String id);
}
