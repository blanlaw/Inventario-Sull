package com.argo.user_commons.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncodePassword {



    private final BCryptPasswordEncoder passwordEncoder;


    public EncodePassword() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    public String encodePassword(String pw) {

        return this.passwordEncoder.encode(pw);

    }
}
