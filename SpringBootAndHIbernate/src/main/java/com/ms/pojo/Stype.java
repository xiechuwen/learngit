package com.ms.pojo;

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

@Entity
@Table(name="stype")
public class Stype {
	
	@Id
	@GeneratedValue
	private int stypeId;
	
	@Column(name="stypeName")
	private String stypeName;
	
	

	@ManyToOne()
	@JoinColumn(name="stypeType")
	private Type stypeType;
	

	@Column(name="stypeMessageDetails")
	@OneToMany(mappedBy="detailStype")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<MessageDetail> stypeMessageDetails;


	public int getStypeId() {
		return stypeId;
	}


	public void setStypeId(int stypeId) {
		this.stypeId = stypeId;
	}


	public String getStypeName() {
		return stypeName;
	}


	public void setStypeName(String stypeName) {
		this.stypeName = stypeName;
	}


	public Type getStypeType() {
		return stypeType;
	}


	public void setStypeType(Type stypeType) {
		this.stypeType = stypeType;
	}


	public Set<MessageDetail> getStypeMessageDetails() {
		return stypeMessageDetails;
	}


	public void setStypeMessageDetails(Set<MessageDetail> stypeMessageDetails) {
		this.stypeMessageDetails = stypeMessageDetails;
	}
	
	
	
}
