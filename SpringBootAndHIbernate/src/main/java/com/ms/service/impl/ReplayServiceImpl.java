package com.ms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dao.ReplayDao;
import com.ms.pojo.Replay;
import com.ms.service.ReplayService;

@Service
public class ReplayServiceImpl implements ReplayService {
	
	@Autowired
	ReplayDao replayDao;

	@Override
	public boolean addReplay(Replay replay) {
		Replay replay1=replayDao.save(replay);
		if(replay1!=null)
			return true;
		return false;
	}
	
	
}
