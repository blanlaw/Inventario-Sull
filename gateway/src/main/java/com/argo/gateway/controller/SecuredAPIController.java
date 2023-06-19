package com.argo.gateway.controller;

import com.argo.gateway.services.OAuthServiceToken;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/oauth")
public class SecuredAPIController {

    private final OAuthServiceToken serviceToken;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public SecuredAPIController(OAuthServiceToken serviceToken) {
        this.serviceToken = serviceToken;
    }

    @RequestMapping("/token")
    public ResponseEntity<?> getAuth(HttpServletRequest request) {


        return new ResponseEntity<>(serviceToken.getToken(request), HttpStatus.OK);


    }

    @GetMapping("/check")
    public ResponseEntity<?> checkToken() {


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
