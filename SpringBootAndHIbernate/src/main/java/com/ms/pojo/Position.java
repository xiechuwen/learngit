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
@Table(name="position")
public class Position {
	
	@Id
	@GeneratedValue
	private int positionId;
	
	@Column(name="positionName")
	private String positionName;
	
	@Column(name="positionEmps")
	@OneToMany(mappedBy="empPosition")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Emp> positionEmps;

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Set<Emp> getPositionEmps() {
		return positionEmps;
	}

	public void setPositionEmps(Set<Emp> positionEmps) {
		this.positionEmps = positionEmps;
	}
	
	
	
}
