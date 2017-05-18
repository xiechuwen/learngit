package com.ms.pojo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="result")
public class Result {
	
	@Id
	@GeneratedValue
	private int resultId;
	
	
	@ManyToOne()
	@JoinColumn(name="resultEmp")
	private Emp resultEmp;
	

	@ManyToOne()
	@JoinColumn(name="resultNextDealEmp")
	private Emp resultNextDealEmp;
	
	@Column(name="resultCreateTime")
	private Date resultCreateTime;
	
	@Column(name="resultModify")
	private Date resultModify;
	
	
	@ManyToOne()
	@JoinColumn(name="resultMessage")
	private Message resultMessage;


	public int getResultId() {
		return resultId;
	}


	public void setResultId(int resultId) {
		this.resultId = resultId;
	}


	public Emp getResultEmp() {
		return resultEmp;
	}


	public void setResultEmp(Emp resultEmp) {
		this.resultEmp = resultEmp;
	}


	public Emp getResultNextDealEmp() {
		return resultNextDealEmp;
	}


	public void setResultNextDealEmp(Emp resultNextDealEmp) {
		this.resultNextDealEmp = resultNextDealEmp;
	}


	public Date getResultCreateTime() {
		return resultCreateTime;
	}


	public void setResultCreateTime(Date resultCreateTime) {
		this.resultCreateTime = resultCreateTime;
	}


	public Date getResultModify() {
		return resultModify;
	}


	public void setResultModify(Date resultModify) {
		this.resultModify = resultModify;
	}


	public Message getResultMessage() {
		return resultMessage;
	}


	public void setResultMessage(Message resultMessage) {
		this.resultMessage = resultMessage;
	}
	
	
	
	
}
