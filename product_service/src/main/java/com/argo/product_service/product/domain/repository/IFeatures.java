package com.argo.product_service.product.domain.repository;

import com.argo.product_service.product.domain.features;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFeatures  extends JpaRepository<features,Integer> {
}
