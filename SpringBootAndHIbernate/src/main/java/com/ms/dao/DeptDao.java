package com.ms.dao;

import java.util.List;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ms.pojo.Dept;
import com.ms.pojo.Emp;

@Repository
@Qualifier(value = "deptDao")
public interface DeptDao extends CrudRepository<Dept, Integer>{

}
