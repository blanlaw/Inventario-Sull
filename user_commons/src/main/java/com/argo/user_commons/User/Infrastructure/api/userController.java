package com.argo.user_commons.User.Infrastructure.api;


import com.argo.user_commons.User.Application.dto.UserDTO;
import com.argo.user_commons.User.Application.dto.createAccount;
import com.argo.user_commons.User.Application.dto.password;
import com.argo.user_commons.User.Application.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class userController {


    private final userService service;

    @Autowired
    public userController(userService service) {
        this.service = service;
    }

    @Value("${SECRET.KEY}")
    private String code;





    @PutMapping("/user")
    public ResponseEntity<?> changePassword(@RequestBody password pw) {


        if (!this.service.changePassword(pw)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getUser/{username}")
    public UserDTO getUser(@PathVariable("username")String username){

        return this.service.getUser(username);

    }


    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody createAccount account) {


        if (!this.service.createAccount(account)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
