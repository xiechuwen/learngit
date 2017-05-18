package com.ms.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author LiuZhen
 *
 */
@Entity
@Table(name="emp")
public class Emp implements Serializable {
	@Id
	@GeneratedValue
	private int empNo;
	
	@Column(name="empRealName")
	private String empRealName;
	
	@Column(name="empName")
	private String empName;
	
	@Column(name="passWord")
	private String passWord;
	
	
	@ManyToOne()
	@JoinColumn(name="empDept")
	private Dept empDept;
	
	
	@ManyToOne()
	@JoinColumn(name="empPosition")
	private Position empPosition;
	
	
	@Column(name="empMessages")
	@OneToMany(mappedBy="messageEmp")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Message> empMessages;
	
	
	//信息中下个处理人
	@Column(name="empNextMessages")
	@OneToMany(mappedBy="messageNextDealEmp")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Message> empNextMessages;
	
	

	
	@Column(name="empReplays")
	@OneToMany(mappedBy="replayEmp")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Replay> empReplays;

	
	
	public Set<Replay> getEmpReplays() {
		return empReplays;
	}


	public void setEmpReplays(Set<Replay> empReplays) {
		this.empReplays = empReplays;
	}


	public int getEmpNo() {
		return empNo;
	}


	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}


	public String getEmpRealName() {
		return empRealName;
	}


	public void setEmpRealName(String empRealName) {
		this.empRealName = empRealName;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public Dept getEmpDept() {
		return empDept;
	}


	public void setEmpDept(Dept empDept) {
		this.empDept = empDept;
	}


	public Position getEmpPosition() {
		return empPosition;
	}


	public void setEmpPosition(Position empPosition) {
		this.empPosition = empPosition;
	}


	public Set<Message> getEmpMessages() {
		return empMessages;
	}


	public void setEmpMessages(Set<Message> empMessages) {
		this.empMessages = empMessages;
	}


	public Set<Message> getEmpNextMessages() {
		return empNextMessages;
	}


	public void setEmpNextMessages(Set<Message> empNextMessages) {
		this.empNextMessages = empNextMessages;
	}


	
	
	
}
