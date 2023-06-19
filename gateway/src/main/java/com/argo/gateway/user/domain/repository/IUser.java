package com.argo.gateway.user.domain.repository;

import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.rol.domain.Rol;
import com.commons.user.models.entity.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userRepo")
public interface IUser extends JpaRepository<User, String> {


    Optional<User> findByEmail(String email);


    User findByIdRolAndIdAlmacen(Rol rol,Almacen almacen);


    List<User> findByIdAlmacen(Almacen almacen);


}
