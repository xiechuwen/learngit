package com.ms.dao;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ms.pojo.Message;

@Repository
@Qualifier(value = "messageDao")
public interface MessageDao extends CrudRepository<Message, Integer>{
	
	@Modifying@Transactional
	@Query(" update Message set status=:messageStatus,"
			+ "messageNextDealEmp.empNo=:messageNextDealEmp,"
			+ "messageModify=:messageModify"
			+ " where messageId=:messageId")
	int updateMessageById(@Param("messageId") int messageId,
			@Param("messageStatus") String messageStatus,
			@Param("messageNextDealEmp") int messageNextDealEmp,
			@Param("messageModify") Date messageModify);
	
	
	@Query(" from Message where messageNextDealEmp.empNo=:nextId or messageEmp.empNo=:nextId")
	List<Message> queryAllMessageByNextEmpId(@Param("nextId") int nextId);
	
	
}
