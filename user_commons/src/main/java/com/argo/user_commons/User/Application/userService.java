package com.argo.user_commons.User.Application;

import com.argo.user_commons.User.Application.dto.*;
import com.argo.user_commons.User.Roles.domain.IRoles;


import com.argo.user_commons.User.domain.repositroy.IUser;
import com.argo.user_commons.Utils.EncodePassword;
import com.commons.user.models.entity.Roles;
import com.commons.user.models.entity.User;
import com.commons.user.models.entity.UserDetails;
import com.commons.user.models.entity.en.roles_enum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class userService {


    private final EncodePassword encodePassword;
    private final IUser iUser;
    private final IRoles iRoles;


    @Autowired
    public userService(EncodePassword encodePassword, IUser iUser, IRoles iRoles) {
        this.encodePassword = encodePassword;
        this.iUser = iUser;
        this.iRoles = iRoles;

    }


    public boolean changePassword(password pw) {

        try {
            // this.userUtil.getUser().setPassword(this.encodePassword.encodePassword(pw.getPassword()));
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    @Transactional(rollbackFor = Exception.class)
    public boolean createAccount(createAccount dto) {

        try {

            User user = new User();
            user.setUsername(dto.getUsername());
            user.setPassword(this.encodePassword.encodePassword(dto.getPassword()));
            user.setRoles(this.iRoles.findByRol(roles_enum.ADMIN).get());
            this.iUser.save(user);


            return true;

        } catch (Exception ex) {
            return false;
        }


    }

    public UserDTO getUser(String username) {

        UserDTO userDTO = new UserDTO();
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        RolesDTO rolesDTO = new RolesDTO();

        Optional<User> UserOptional = this.iUser.findByUsername(username);
        User user = UserOptional.get();

        Roles roles = user.getRoles();
        rolesDTO.setId(roles.getId());
        rolesDTO.setRol(roles.getRol().name());
        UserDetails userDetails = user.getUserDetails();


        userDetailsDTO.setIdUser(userDetails.getIdUser());
        userDetailsDTO.setName(userDetails.getName());
        userDetailsDTO.setLastName(userDetails.getLastName());
        userDetailsDTO.setEmail(userDetails.getEmail());
        userDetailsDTO.setCell(userDetails.getCell());
        userDTO.setIdUser(user.getIdUser());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setUserDetailsDTO(userDetailsDTO);
        userDTO.setRoles(rolesDTO);

        return userDTO;

    }


}
