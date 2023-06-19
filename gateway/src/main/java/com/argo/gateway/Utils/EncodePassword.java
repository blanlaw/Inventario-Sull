package com.argo.gateway.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncodePassword {


    private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();




    public String encodePassword(String pw) {

        return this.bCryptPasswordEncoder.encode(pw);

    }
}
