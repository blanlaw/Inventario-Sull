package com.argo.gateway.user.domain.event;


import com.commons.user.models.entity.user.domain.User;
import com.argo.gateway.user.domain.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.PrePersist;


public class UserEvent {


    @Autowired
    @Qualifier("userRepo")
    private IUser iUser;

    @PrePersist
    public void logNewUser(User user) {


        iUser.findByEmail(user.getEmail()).ifPresent(user1 -> {
            throw new RuntimeException("Este usuario ya existe");
        });


    }
}
