package com.ms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ms.pojo.Message;
import com.ms.pojo.MessageDetail;

@Repository
@Qualifier(value = "messageDetailDao")
public interface MessageDetailDao extends CrudRepository<MessageDetail, Integer>{

	@Query(" from MessageDetail where detailMessage.messageId=:messageId")
	List<MessageDetail> queryAllMessageDetailById(@Param("messageId") int messageId);
}
