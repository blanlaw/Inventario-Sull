package com.argo.product_service.product.domain.repository;

import com.argo.product_service.product.domain.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IType  extends JpaRepository<TypeProduct,Integer> {
}
