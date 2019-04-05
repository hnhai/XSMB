package com.hai.xsmb.web.controller;

import com.hai.xsmb.web.service.JwtService;
import com.hai.xsmb.web.service.ResultService;
import com.hai.xsmb.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

    @Autowired
    protected UserService userService;

    @Autowired
    protected JwtService jwtService;

    @Autowired
    protected ResultService resultService;

}
