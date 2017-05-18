package com.ms.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="file")
public class File {
	@Id
	@GeneratedValue
	private int fileId;
	
	@Column(name="fileName")
	private String fileName;
	
	@Column(name="filePath")
	private String filePath;
	
	@ManyToOne()
	@JoinColumn(name="fileMessage")
	private Message fileMessage;

	
	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Message getFileMessage() {
		return fileMessage;
	}

	public void setFileMessage(Message fileMessage) {
		this.fileMessage = fileMessage;
	}

	public File(int fileId, String fileName, String filePath, Message fileMessage) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileMessage = fileMessage;
	}

	public File() {
		super();
	}
	
	
	
}
