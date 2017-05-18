package com.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dao.MessageDetailDao;
import com.ms.pojo.Message;
import com.ms.pojo.MessageDetail;
import com.ms.service.MessageDetailService;

@Service
public class MessageDetailServiceImpl implements MessageDetailService {

	@Autowired
	MessageDetailDao messageDetailDao;
	
	
	@Override
	public boolean addMessageDetail(MessageDetail messageDetail) {
			MessageDetail messageDetail1=messageDetailDao.save(messageDetail);
			if(messageDetail1!=null){
				return true;
			}
		return false;
	}


	@Override
	public List<MessageDetail> findAllMessageDetailById(int messageId) {
		List<MessageDetail> list=messageDetailDao.queryAllMessageDetailById(messageId);
		return list;
	}





}
