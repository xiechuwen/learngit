package com.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dao.EmpDao;
import com.ms.pojo.Emp;
import com.ms.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDao empDao;

	@Override
	public Emp queryEmpByPassWord(String username, String password) {
		Emp emp=empDao.findEmpByPassWrod(username, password);
		
		return emp;
	}

	@Override
	public Emp queryNextEmpById(int deptId,int positionId) {
		Emp emp=empDao.findNextEmpById( deptId, positionId);
		return emp;
	}

	@Override
	public List<Emp> queryAllEmpByDeptNo(int deptNo) {
		List<Emp> list=empDao.findAllEmpByDeptNo(deptNo);
		return list;
	}
	
}
