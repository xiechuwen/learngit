package com.ms.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="messageDetail")
public class MessageDetail {
	
	@Id
	@GeneratedValue
	private int detailId;
	
	
	@ManyToOne()
	@JoinColumn(name="detailStype")
	private Stype detailStype;
	
	

	@ManyToOne()
	@JoinColumn(name="detailMessage")
	private Message detailMessage;
	
	@Column(name="messageInfo")
	private String messageInfo;

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public Stype getDetailStype() {
		return detailStype;
	}

	public void setDetailStype(Stype detailStype) {
		this.detailStype = detailStype;
	}

	public Message getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(Message detailMessage) {
		this.detailMessage = detailMessage;
	}

	public String getMessageInfo() {
		return messageInfo;
	}

	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo;
	}
	
	
	
}
