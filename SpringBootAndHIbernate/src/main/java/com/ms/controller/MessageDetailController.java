package com.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ms.pojo.Dept;
import com.ms.pojo.Message;
import com.ms.pojo.MessageDetail;
import com.ms.service.DeptService;
import com.ms.service.MessageDetailService;
import com.ms.service.MessageService;
import com.ms.service.StypeService;

@Controller
@EnableAutoConfiguration
public class MessageDetailController {
	
	@Autowired
	MessageDetailService messageDetailService;
	
	@Autowired
	MessageService messageService;
	
	
	@Autowired
	DeptService deptService;
	
	@Autowired
	StypeService stypeService;
	
	
/*	@RequestMapping("/addMessageDetail")
	public ModelAndView addMessageDetail(ModelAndView mav,DetailMessage messageDetails){
		
		return mav;
	}*/
	
	/**
	 * 根据ID去查询相应的信息
	 * @param mav
	 * @return
	 */
	@RequestMapping("/showMessageAndMessageDetailInfo")
	public ModelAndView showMessageAndMessageDetailInfo(
			ModelAndView mav,int messageId,int realDeal){
		//先查询问题主题
		Message message=messageService.findMessageById(messageId);
		if(message!=null){
			mav.addObject("message",message);
			List<MessageDetail> dlist=messageDetailService.findAllMessageDetailById(messageId);
			if(dlist!=null){
				mav.addObject("dlist", dlist);
				List<Dept> delist=deptService.queryAllDept();
				if(delist!=null){
					mav.addObject("delist",delist);
					mav.addObject("realDeal",realDeal);
					mav.setViewName("dealMessageInfo");
				}
			}
		}
		return mav;
	}
	
	
}
