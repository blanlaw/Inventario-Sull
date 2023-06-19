package com.argo.inventario_service.producto.domain.repository;

import com.argo.inventario_service.producto.domain.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Type.
 */
@Repository
public interface IType extends JpaRepository<TipoProducto,Integer> {
}
