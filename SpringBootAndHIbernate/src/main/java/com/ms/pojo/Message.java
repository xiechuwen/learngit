package com.ms.pojo;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="message")
public class Message {
	
	@Id
	@GeneratedValue
	private int messageId;
	
	@Column(name="messageTitle")
	private String messageTitle;
	
	@Column(name="messageCreateTime")
	private Date messageCreateTime;
	
	@Column(name="messageModify")
	private Date messageModify;

	@ManyToOne()
	@JoinColumn(name="messageEmp")
	private Emp messageEmp;
	
	@Column(name="status")
	private String status;
	
	
	@ManyToOne()
	@JoinColumn(name="messageNextDealEmp")
	private Emp messageNextDealEmp;
	
	
	@Column(name="messageDetails")
	@OneToMany(mappedBy="detailMessage")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<MessageDetail> messageDetails;
	
	
	@Column(name="messageFiles")
	@OneToMany(mappedBy="fileMessage")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<File> messageFiles;
	
	@Column(name="messageReplay")
	@OneToMany(mappedBy="replayMessage")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Replay> messageReplay;
	
	
	@Column(name="messageFlows")
	@OneToMany(mappedBy="flowMessage")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Flow> messageFlows;
	
	
	

	
	@ManyToOne()
	@JoinColumn(name="messageType")
	private Type messageType;


	public int getMessageId() {
		return messageId;
	}


	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}


	public String getMessageTitle() {
		return messageTitle;
	}


	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}


	public Date getMessageCreateTime() {
		return messageCreateTime;
	}


	public void setMessageCreateTime(Date messageCreateTime) {
		this.messageCreateTime = messageCreateTime;
	}


	public Date getMessageModify() {
		return messageModify;
	}


	public void setMessageModify(Date messageModify) {
		this.messageModify = messageModify;
	}


	public Emp getMessageEmp() {
		return messageEmp;
	}


	public void setMessageEmp(Emp messageEmp) {
		this.messageEmp = messageEmp;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Emp getMessageNextDealEmp() {
		return messageNextDealEmp;
	}


	public void setMessageNextDealEmp(Emp messageNextDealEmp) {
		this.messageNextDealEmp = messageNextDealEmp;
	}


	public Set<MessageDetail> getMessageDetails() {
		return messageDetails;
	}


	public void setMessageDetails(Set<MessageDetail> messageDetails) {
		this.messageDetails = messageDetails;
	}



	public Type getMessageType() {
		return messageType;
	}


	public void setMessageType(Type messageType) {
		this.messageType = messageType;
	}


	public Set<File> getMessageFiles() {
		return messageFiles;
	}


	public void setMessageFiles(Set<File> messageFiles) {
		this.messageFiles = messageFiles;
	}


	public Set<Replay> getMessageReplay() {
		return messageReplay;
	}


	public void setMessageReplay(Set<Replay> messageReplay) {
		this.messageReplay = messageReplay;
	}


	public Set<Flow> getMessageFlows() {
		return messageFlows;
	}


	public void setMessageFlows(Set<Flow> messageFlows) {
		this.messageFlows = messageFlows;
	}






	
	
	
	
	
}
