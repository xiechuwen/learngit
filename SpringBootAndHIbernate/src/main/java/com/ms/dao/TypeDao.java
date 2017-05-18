package com.ms.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ms.pojo.Emp;
import com.ms.pojo.Type;

@Repository
@Qualifier(value = "typeDao")
public interface TypeDao extends CrudRepository<Type, Integer>{
	
	
}
