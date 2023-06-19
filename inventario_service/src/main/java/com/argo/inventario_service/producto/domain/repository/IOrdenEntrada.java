package com.argo.inventario_service.producto.domain.repository;

import com.argo.inventario_service.producto.domain.embd.embdOrdenEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Orden entrada.
 */
@Repository
public interface IOrdenEntrada  extends JpaRepository<embdOrdenEntrada,Integer> {


    /**
     * Buscar entrada optional.
     *
     * @param id the id
     * @return the optional
     */
    @Query("select ont from orden_entrada ont where ont.idEntrada.idEntrada=?1")
    Optional<embdOrdenEntrada> buscarEntrada(int id);


}
