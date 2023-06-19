package com.argo.inventario_service.producto.domain.repository;

import com.argo.inventario_service.producto.domain.DetallesOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Orden detalles.
 */
@Repository
public interface IOrdenDetalles extends JpaRepository<DetallesOrden, Integer> {
}
