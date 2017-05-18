package com.ms.pojo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="flow")
public class Flow {
	
	@Id
	@GeneratedValue
	private int flowId;
	
	@Column(name="flowInfo")
	private String flowInfo;
	
	@Column(name="flowTime")
	private Date flowTime;
	
	@ManyToOne()
	@JoinColumn(name="flowMessage")
	private Message flowMessage;
	
	@ManyToOne()
	@JoinColumn(name="flowEmp")
	private Emp flowEmp;

	
	
	public int getFlowId() {
		return flowId;
	}

	public void setFlowId(int flowId) {
		this.flowId = flowId;
	}

	public String getFlowInfo() {
		return flowInfo;
	}

	public void setFlowInfo(String flowInfo) {
		this.flowInfo = flowInfo;
	}

	public Date getFlowTime() {
		return flowTime;
	}

	public void setFlowTime(Date flowTime) {
		this.flowTime = flowTime;
	}

	public Message getFlowMessage() {
		return flowMessage;
	}

	public void setFlowMessage(Message flowMessage) {
		this.flowMessage = flowMessage;
	}

	public Emp getFlowEmp() {
		return flowEmp;
	}

	public void setFlowEmp(Emp flowEmp) {
		this.flowEmp = flowEmp;
	}

	
	
	
	
	
	
}
