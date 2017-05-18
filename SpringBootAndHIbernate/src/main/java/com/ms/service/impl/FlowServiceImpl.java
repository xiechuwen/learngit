package com.ms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dao.FlowDao;
import com.ms.pojo.Flow;
import com.ms.service.FlowService;

@Service
public class FlowServiceImpl implements FlowService{

	@Autowired
	FlowDao flowDao;
	
	@Override
	public boolean addFlow(Flow flow) {
		Flow flow1=flowDao.save(flow);
		if(flow1!=null)
			return true;
		return false;
	}

}
