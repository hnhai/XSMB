package com.hai.xsmb.web.controller;


import com.hai.xsmb.web.dto.UserLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class LoginController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLogin userLogin) {
        String result = "";
        HttpStatus httpStatus = null;
        try {
            Boolean isUser = userService.loadByUsernameAndPassWord(userLogin.getUsername(), userLogin.getPassword());
            if (isUser) {
                result = jwtService.generateTokenLogin(userLogin.getUsername());
                httpStatus = HttpStatus.OK;
            } else {
                result = "Wrong userId and password";
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        } catch (Exception ex) {
            result = "Server Error";
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOG.warn(ex.getMessage(), ex);
        }
        return new ResponseEntity(result, httpStatus);
    }
}
