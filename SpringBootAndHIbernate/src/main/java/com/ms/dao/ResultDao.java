package com.ms.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ms.pojo.Result;

@Repository
@Qualifier(value = "resultDao")
public interface ResultDao extends CrudRepository<Result, Integer>{

}
