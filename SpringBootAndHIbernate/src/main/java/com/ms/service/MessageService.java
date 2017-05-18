package com.ms.service;

import java.sql.Date;
import java.util.List;

import com.ms.pojo.Message;

public interface MessageService {
	
	List<Message> findAllMessage();
	
	boolean addMessage(Message message);
	
	Message findMessageById(int messageId);
	
	boolean changeMessageById(int messageId,String status,Date modify,int nextDealNo);
	
	List<Message> findAllMessageByNextId(int nextId);

}
