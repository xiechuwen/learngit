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
@Table(name="type")
public class Type {
	
	@Id
	@GeneratedValue
	private int typeId;
	
	@Column(name="stypeName")
	private String typeName;
	
	
	@Column(name="typeStypes")
	@OneToMany(mappedBy="stypeType")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Stype> typeStypes;

	

	@Column(name="typeMessages")
	@OneToMany(mappedBy="messageType")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Message> typeMessages;

	
	public int getTypeId() {
		return typeId;
	}


	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public Set<Stype> getTypeStypes() {
		return typeStypes;
	}


	public void setTypeStypes(Set<Stype> typeStypes) {
		this.typeStypes = typeStypes;
	}


	public Set<Message> getTypeMessages() {
		return typeMessages;
	}


	public void setTypeMessages(Set<Message> typeMessages) {
		this.typeMessages = typeMessages;
	}
	
	
	
	
}
