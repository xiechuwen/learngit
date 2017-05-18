package com.ms.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ms.pojo.Flow;

@Repository
@Qualifier(value = "flowDao")
public interface FlowDao extends CrudRepository<Flow, Integer>{

}
