package com.hai.xsmb.web.controller;

import com.hai.xsmb.core.entity.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class ResultController extends BaseController{

    private static final Logger LOG = LoggerFactory.getLogger(ResultController.class);

    @GetMapping("/results")
    public ResponseEntity result(){
        List<ResultEntity> result = new ArrayList<>();
        HttpStatus httpStatus = null;
        try {
            result = resultService.loadResults();
            httpStatus = HttpStatus.OK;
        }catch (Exception ex){
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOG.warn(ex.getMessage(), ex);
        }
        return new ResponseEntity(result, httpStatus);
    }
}
