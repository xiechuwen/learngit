package com.ms.service;

import java.util.List;

import com.ms.pojo.Emp;

public interface EmpService {
	Emp queryEmpByPassWord(String username,String password);
	
	Emp queryNextEmpById(int deptId,int positionId);
	
	List<Emp> queryAllEmpByDeptNo(int deptNo);
}
