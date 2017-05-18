package com.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dao.StypeDao;
import com.ms.pojo.Stype;
import com.ms.service.StypeService;

@Service
public class StypeServiceImpl implements StypeService {

	@Autowired
	StypeDao stypeDao;
	
	@Override
	public List<Stype> queryStypeByTypeId(int typeId) {
		List<Stype> list=stypeDao.findStypeByTypeId(typeId);
		return list;
	}

	

}
