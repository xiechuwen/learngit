package com.ms.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ms.pojo.Position;

@Repository
@Qualifier(value = "positionDao")
public interface PositionDao extends CrudRepository<Position, Integer>{

}
