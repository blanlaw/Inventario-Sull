package com.argo.user_commons.User.Roles.infrascturure.api;

import com.argo.user_commons.User.Roles.application.dto.roldto;
import com.argo.user_commons.User.Roles.application.rolesService;
import com.argo.user_commons.User.Roles.domain.IRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class rolesController {



    private final rolesService service;

    @Autowired
    public rolesController(rolesService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> crearRol(@RequestBody roldto roldto){


        if(!this.service.crearRol(roldto)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping("/prueba")
    public String roles(){
        this.iRoles.findAll().forEach(System.out::println);
        return "si me conecte";
    }

    @Autowired
    private IRoles iRoles;
}
