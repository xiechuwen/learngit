package com.ms.service;

import java.util.List;

import com.ms.pojo.Message;
import com.ms.pojo.MessageDetail;

public interface MessageDetailService {
	
	
	boolean addMessageDetail(MessageDetail messageDetail);

	List<MessageDetail> findAllMessageDetailById(int messageId);
	
}
