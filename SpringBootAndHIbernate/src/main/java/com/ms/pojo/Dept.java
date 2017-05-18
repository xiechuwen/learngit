package com.ms.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="dept")
public class Dept {
	
	@Id
	@GeneratedValue
	private int deptNo;
	
	@Column(name="deptName")
	private String deptName;
	
	
	/**
	 * 一对多配置
	 */
	@Column(name="deptEmps")
	@OneToMany(mappedBy="empDept")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Emp> deptEmps;


	public int getDeptNo() {
		return deptNo;
	}


	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public Set<Emp> getDeptEmps() {
		return deptEmps;
	}


	public void setDeptEmps(Set<Emp> deptEmps) {
		this.deptEmps = deptEmps;
	}
	
	
	
	
	
	
}
