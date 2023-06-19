package com.argo.inventario_service.area.domain.repository;

import com.commons.user.models.entity.accessUser.domain.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Access.
 */
@Repository
public interface IAccess extends  JpaRepository<Access,Integer> {


    /**
     * Find by token optional.
     *
     * @param token the token
     * @return the optional
     */
    Optional<Access> findByToken(String token);


    /**
     * Find by sub list.
     *
     * @param codigo the codigo
     * @return the list
     */
    List<Access> findBySub(String codigo);
}
