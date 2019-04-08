package com.hai.xsmb.web.controller;

import com.hai.xsmb.core.entity.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/rest/user")
public class ResultController extends BaseController{

    private static final Logger LOG = LoggerFactory.getLogger(ResultController.class);

    @GetMapping("/results")
    public ResponseEntity getAllResult(){
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

    @GetMapping("/result/{date}")
    public ResponseEntity getResultofDate(@PathVariable("date") String day){
        ResultEntity result = new ResultEntity();
        HttpStatus httpStatus = null;
        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(day);
            result = resultService.loadResultByDate(date);
            httpStatus = HttpStatus.OK;
        }catch (Exception ex){
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOG.warn(ex.getMessage(), ex);
        }
        return new ResponseEntity(result, httpStatus);
    }
}
