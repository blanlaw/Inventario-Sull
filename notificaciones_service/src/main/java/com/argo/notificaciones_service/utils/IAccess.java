package com.argo.notificaciones_service.utils;

import com.commons.user.models.entity.accessUser.domain.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccess extends JpaRepository<Access,Integer> {

    Optional<Access> findByToken(String token);

}
