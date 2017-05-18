package com.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dao.TypeDao;
import com.ms.pojo.Type;
import com.ms.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	TypeDao typeDao;
	
	@Override
	public List<Type> queryAllType() {
		List<Type> list=(List<Type>) typeDao.findAll();
		return list;
	}

	

}
