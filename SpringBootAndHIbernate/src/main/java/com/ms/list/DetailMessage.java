package com.ms.list;

import java.util.List;

import com.ms.pojo.Message;
import com.ms.pojo.MessageDetail;

public class DetailMessage {
	private List<MessageDetail> messageDetails;
	
	private Message message;
	
	

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public List<MessageDetail> getMessageDetails() {
		return messageDetails;
	}

	public void setMessageDetails(List<MessageDetail> messageDetails) {
		this.messageDetails = messageDetails;
	}

	public DetailMessage(List<MessageDetail> messageDetails, Message message) {
		super();
		this.messageDetails = messageDetails;
		this.message = message;
	}

	public DetailMessage() {
		super();
	}

	
	
}
