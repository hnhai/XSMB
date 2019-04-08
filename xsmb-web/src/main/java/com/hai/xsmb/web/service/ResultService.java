package com.hai.xsmb.web.service;

import com.hai.xsmb.core.entity.ResultEntity;

import java.util.Date;
import java.util.List;

public interface ResultService {
    List<ResultEntity> loadResults();
    ResultEntity loadResultByDate(Date date);
}
