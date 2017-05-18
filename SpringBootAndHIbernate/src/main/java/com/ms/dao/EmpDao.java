package com.ms.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ms.pojo.Emp;

@Repository
@Qualifier(value = "empDao")
public interface EmpDao extends CrudRepository<Emp, Integer>{
	
	@Query(" from Emp  where empName=:empName and passWord=:passWord")  
	Emp findEmpByPassWrod(@Param("empName") String empName,@Param("passWord") String passWord);
	
	
	@Query(" from Emp  where empDept.deptNo=:deptId and empPosition.positionId=:positionId+1")  
	Emp findNextEmpById(@Param("deptId") int deptId,@Param("positionId") int positionId);
	
	@Query(" from Emp where empDept.deptNo=:deptNo")
	List<Emp> findAllEmpByDeptNo(@Param("deptNo") int deptNo);
}
