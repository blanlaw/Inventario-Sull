package com.argo.user_commons.User.Roles.application;


import com.argo.user_commons.User.Roles.application.dto.roldto;
import com.argo.user_commons.User.Roles.domain.IRoles;
import com.commons.user.models.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class rolesService {


    private final IRoles iRoles;


    @Autowired
    public rolesService(IRoles iRoles) {
        this.iRoles = iRoles;
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean crearRol(roldto roldto) {


        try {

            Roles roles = new Roles();
            roles.setRol(roldto.getRol());


            this.iRoles.save(roles);


            return true;

        } catch (Exception ex) {

            return false;
        }


    }


}
