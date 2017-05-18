package com.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dao.DeptDao;
import com.ms.pojo.Dept;
import com.ms.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptDao deptDao;
	
	@Override
	public List<Dept> queryAllDept() {
		List<Dept> list=(List<Dept>) deptDao.findAll();
		return list;
	}



}
