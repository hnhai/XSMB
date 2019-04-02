package com.hai.xsmb.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/admin")
public class UserController extends BaseController{

    @GetMapping("/users")
    public ResponseEntity getUsers(){
        return new ResponseEntity<>(userService.loadAll(), HttpStatus.OK);
    }
}
