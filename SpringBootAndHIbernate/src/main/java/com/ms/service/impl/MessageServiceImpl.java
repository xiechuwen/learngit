package com.ms.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dao.MessageDao;
import com.ms.pojo.Message;
import com.ms.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDao messageDao;
	
	@Override
	public List<Message> findAllMessage() {
		List<Message> list=new ArrayList<Message>();
		list=(List<Message>) messageDao.findAll();
		return list;
	}

	@Override
	public boolean addMessage(Message massage) {
		Message massage1=messageDao.save(massage);
		if(massage1!=null){
			return true;
		}
		return false;
	}
	
	
	/**
	 * 根据id查询问题信息
	 */
	@Override
	public Message findMessageById(int messageId) {
		Message message=messageDao.findOne(messageId);
		return message;
	}

	
	/**
	 * 根据ID修改问题信息
	 */
	@Override
	public boolean changeMessageById(int messageId, String status, Date modify, int nextDealNo) {
		int result=messageDao.updateMessageById(messageId, status, nextDealNo, modify);
		if(result>0)
			return true;
		return false;
	}

	@Override
	public List<Message> findAllMessageByNextId(int nextId) {
		List<Message> list=messageDao.queryAllMessageByNextEmpId(nextId);
		return list;
	}

	

}
