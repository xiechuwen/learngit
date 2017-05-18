package com.ms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ms.pojo.Stype;

@Repository
@Qualifier(value = "stypeDao")
public interface StypeDao extends CrudRepository<Stype, Integer>{
	
	@Query(" from Stype where stypeType.typeId=:typeId")  
	List<Stype> findStypeByTypeId(@Param("typeId") int typeId);

}
