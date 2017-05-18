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
@Table(name="replay")
public class Replay {
	
	@Id
	@GeneratedValue
	private int replayId;
	
	@Column(name="replayInfo")
	private String replayInfo;
	
	@Column(name="replayTime")
	private Date replayTime;
	
	@ManyToOne()
	@JoinColumn(name="replayMessage")
	private Message replayMessage;
	
	@ManyToOne()
	@JoinColumn(name="replayEmp")
	private Emp replayEmp;

	
	
	public Emp getReplayEmp() {
		return replayEmp;
	}

	public void setReplayEmp(Emp replayEmp) {
		this.replayEmp = replayEmp;
	}

	public int getReplayId() {
		return replayId;
	}

	public void setReplayId(int replayId) {
		this.replayId = replayId;
	}

	public String getReplayInfo() {
		return replayInfo;
	}

	public void setReplayInfo(String replayInfo) {
		this.replayInfo = replayInfo;
	}

	public Date getReplayTime() {
		return replayTime;
	}

	public void setReplayTime(Date replayTime) {
		this.replayTime = replayTime;
	}

	public Message getReplayMessage() {
		return replayMessage;
	}

	public void setReplayMessage(Message replayMessage) {
		this.replayMessage = replayMessage;
	}
	
	
	
	
	
}
