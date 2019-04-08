package com.hai.xsmb.core.repository;

import com.hai.xsmb.core.entity.ResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ResultRepository extends JpaRepository<ResultEntity, Long> {
    ResultEntity getByDateAndDeleted(Date date, Boolean deleted);
}
