package com.hai.xsmb.web.service.Impl;

import com.hai.xsmb.core.entity.ResultEntity;
import com.hai.xsmb.core.repository.ResultRepository;
import com.hai.xsmb.web.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public List<ResultEntity> loadResults() {
        return resultRepository.findAll();
    }

    @Override
    public ResultEntity loadByDate(Date date) {
        return resultRepository.getByDateAndDeleted(date, Boolean.FALSE);
    }
}
