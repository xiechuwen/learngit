package com.ms.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ms.list.DetailMessage;
import com.ms.pojo.Emp;
import com.ms.pojo.Flow;
import com.ms.pojo.Message;
import com.ms.pojo.MessageDetail;
import com.ms.pojo.Replay;
import com.ms.pojo.Type;
import com.ms.service.EmpService;
import com.ms.service.FileService;
import com.ms.service.FlowService;
import com.ms.service.MessageDetailService;
import com.ms.service.MessageService;
import com.ms.service.ReplayService;
import com.ms.service.TypeService;

@Controller
@EnableAutoConfiguration
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	FileService fileService;
	
	@Autowired
	MessageDetailService messageDetailService;
	
	@Autowired
	EmpService empService;
	
	@Autowired
	FlowService flowService;
	
	@Autowired
	TypeService typeService;
	
	@Autowired
	ReplayService replayService;
	
	/**
	 * 显示所有的问题
	 * @param session
	 * @return
	 */
	@RequestMapping("/showAllMessage")
	public ModelAndView showAllMessage(
			HttpSession session){
		/*List<Message> list=messageService.findAllMessage();*/
		Emp emp=(Emp)session.getAttribute("emp1");
		List<Message> list=messageService.findAllMessageByNextId(emp.getEmpNo());
		ModelAndView mav=new ModelAndView();
		if(list!=null){
			mav.setViewName("ShowAllMessageInfo");
			mav.addObject(list);
			return mav;
		}
		mav.setViewName("ShowAllMessageInfo");
		return mav;
	} 


	/**
	 * 跳转显示添加页面（包括处理人，创建人，类型选择）
	 * @param mav
	 * @param session
	 * @return
	 */
	@RequestMapping("/addMessageInfo")
	public ModelAndView addMessageInfo(ModelAndView mav,HttpSession session){
		Emp emp=(Emp) session.getAttribute("emp1");
		mav.addObject("emp",emp);
		Emp nextEmp=empService.queryNextEmpById( emp.getEmpDept().getDeptNo(),emp.getEmpPosition().getPositionId());
		List<Type> tlist=typeService.queryAllType();
		mav.addObject("tlist",tlist);
		if(nextEmp!=null && tlist!=null){
			mav.addObject("nextEmp",nextEmp);
			mav.setViewName("addMessageInfo");
		}
		mav.setViewName("addMessageInfoNew");
		return mav;
	}
	

	@RequestMapping("/dealMessageInfo")
	public ModelAndView dealMessageInfo(ModelAndView mav){
		mav.setViewName("dealMessageInfo");
		return mav;
	}
	
/*	@RequestMapping("/ShowAllMessageInfo")
	public ModelAndView showAllMessageInfo(ModelAndView mav){
		mav.setViewName("ShowAllMessageInfo");
		return mav;
	}*/
	
	
	/**
	 * 添加问题单
	 * @param mav
	 * @param messageDetails
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/addMessageInforMation",	
			produces="text/plain;charset=UTF-8")
	public ModelAndView addMessageInfo(ModelAndView mav,DetailMessage messageDetails,
		/*	@RequestParam("file")MultipartFile[] files,*/HttpServletRequest request,
		String detailInfo,MessageDetail messageDetail) throws IllegalStateException, IOException{
		
		String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
	/*	System.out.println("datetime:"+datetime);
		int a=10/0;*/
		messageDetails.getMessage().setMessageCreateTime(Date.valueOf(datetime));
		messageDetails.getMessage().setMessageId(0);
		messageDetails.getMessage().setMessageModify(Date.valueOf("1111-11-11"));
		messageDetails.getMessage().setStatus("已提交，待处理");
	/*	messageDetails.getMessage().setMessageReback(" ");*/
/*		int a=10/0;*/
		boolean b=messageService.addMessage(messageDetails.getMessage());
		
		if(b){
			//开始添加问题详情
			MessageDetail detail=new MessageDetail();
				detail.setDetailId(0);
				detail.setDetailMessage(messageDetails.getMessage());
				detail.setMessageInfo(detailInfo);
				detail.setDetailStype(messageDetail.getDetailStype());
				boolean result=messageDetailService.addMessageDetail(detail);
				
				List<com.ms.pojo.File> fileList=new ArrayList<com.ms.pojo.File>();
				if(result){
					//开始添加工作流程
					Flow flow=new Flow();
					flow.setFlowId(0);
					flow.setFlowInfo("创建了这个问题");
					flow.setFlowTime(Date.valueOf(datetime));
					flow.setFlowEmp(messageDetails.getMessage().getMessageEmp());
					flow.setFlowMessage(messageDetails.getMessage());
					boolean result2=flowService.addFlow(flow);
					if(result2){
						
						//开始上传文件以及添加文件路径
						List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("files");  
						String dirPath = request.getSession().getServletContext().getRealPath("/WEB-INF/files/");  
						String fileName1=null;
						if(files!=null && files.size()>0 ){
							for (MultipartFile file : files) {
								//获取文件名
								String fileName=file.getOriginalFilename();
								//获取文件的真实类型
								String contentType=file.getContentType();
								//获取文件的大小 字节型
								long fileSize=file.getSize();
							
								//上传文件
								fileName1=UUID.randomUUID().toString()+fileName;
								file.transferTo(new File(dirPath,fileName1));
								fileList.add(new com.ms.pojo.File(0,fileName,fileName1,messageDetails.getMessage()));
								
							}
						}
						

						boolean result1=false;
						//开始添加到数据库
						for (com.ms.pojo.File file : fileList) {
							result1=fileService.addFile(file);
						}
						//添加成功
						if(result){
							mav.setViewName("redirect:showAllMessage");
						}
					}

				}
		}
		return mav;
	}
	
	
	/**
	 * 根据问题信息ID去处理信息
	 * @param mav
	 * @param messageId
	 * @param messageDetails
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="dealMessageById",
			produces="text/plain;charset=UTF-8")
	public ModelAndView dealMessageById(ModelAndView mav,int messageId,
		String messageStatus,int emp,String deal,int dealEmp,String messageReback,HttpSession session
		,String messageEmpNo,int empRealNo) throws ParseException{
		if(messageStatus!=null && messageStatus!=""){
			if(messageStatus.equals("已分配,待接受")){
				//分配
			    String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
				boolean result=messageService.changeMessageById(messageId, messageStatus, Date.valueOf(datetime), emp);
				if(result){
					//创建回复单子
					Replay replay=new Replay();
					//获取当前时间
				/*	String time=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());*/
					replay.setReplayId(0);
					replay.setReplayInfo(messageReback);
					Emp emp2=(Emp)session.getAttribute("emp1");
					replay.setReplayEmp(emp2);
					replay.setReplayTime(Date.valueOf(datetime));
					Message messageInfo=new Message();
					messageInfo.setMessageId(messageId);
					replay.setReplayMessage(messageInfo);
					
					boolean result3=replayService.addReplay(replay);
					if(result3){
						//创建工作流
						Flow flow =new Flow();
						flow.setFlowId(0);
						flow.setFlowMessage(messageInfo);
						flow.setFlowEmp(emp2);
						flow.setFlowInfo("分配了这个问题");
						flow.setFlowTime(Date.valueOf(datetime));
					 	boolean result2=flowService.addFlow(flow);
					 	if(result2){
					 		mav.setViewName("redirect:showAllMessage");
					 	}
					}
				}
			}else{
				//完成
				String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			    
				//下个处理人
							
				boolean result=messageService.changeMessageById(messageId, messageStatus, Date.valueOf(datetime), Integer.parseInt(messageEmpNo));
				
				//创建回复单子
				Replay replay=new Replay();
				//获取当前时间
			/*	String time=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());*/
				replay.setReplayId(0);
				replay.setReplayInfo(messageReback);
				Emp emp2=(Emp)session.getAttribute("emp1");
				replay.setReplayEmp(emp2);
				replay.setReplayTime(Date.valueOf(datetime));
				Message messageInfo=new Message();
				messageInfo.setMessageId(messageId);
				replay.setReplayMessage(messageInfo);
				
				if(result){
					boolean result1=replayService.addReplay(replay);
					if(result1){
						//创建工作流
						Flow flow=new Flow();
						flow.setFlowId(0);
						flow.setFlowMessage(messageInfo);
						flow.setFlowEmp(emp2);
						flow.setFlowInfo("完成了这个问题");
						flow.setFlowTime(Date.valueOf(datetime));
						boolean result3=flowService.addFlow(flow);
						if(result3){
							mav.setViewName("redirect:showAllMessage");
						}
					}
					
				}
				
			}
		}
		
		
		//开发人员管理
		if(deal!=null && deal!=""){
			if(deal.equals("完成")){
				//接受
				messageStatus="已完成";
		
				String time=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
				boolean result=messageService.changeMessageById(messageId, messageStatus, Date.valueOf(time), Integer.parseInt(messageEmpNo));

				if(result){
					//再次添加回复单子
					Replay replay=new Replay();
					//获取当前时间
					replay.setReplayId(0);
					replay.setReplayInfo(messageReback);
					Emp emp2=(Emp)session.getAttribute("emp1");
					replay.setReplayEmp(emp2);
					replay.setReplayTime(Date.valueOf(time));
					Message messageInfo=new Message();
					messageInfo.setMessageId(messageId);
					replay.setReplayMessage(messageInfo);
					//创建
					boolean result2=replayService.addReplay(replay);
					if(result2){
						//创建工作流
						Flow flow=new Flow();
						flow.setFlowId(0);
						flow.setFlowMessage(messageInfo);
						flow.setFlowEmp(emp2);
						flow.setFlowInfo("完成了这个问题");
						flow.setFlowTime(Date.valueOf(time));
						boolean result3=flowService.addFlow(flow);
						if(result3){
							mav.setViewName("redirect:showAllMessage");
						}
					}
				}
			}else{
				
				//解决不了,重新指向！！！
				messageStatus="已转交其他员工";
				String time=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
				boolean result=messageService.changeMessageById(messageId, messageStatus, Date.valueOf(time),empRealNo);
		
				if(result){
					//再次添加回复单子
					Replay replay=new Replay();
					//获取当前时间
					replay.setReplayId(0);
					replay.setReplayInfo(messageReback);
					Emp emp2=(Emp)session.getAttribute("emp1");
					replay.setReplayEmp(emp2);
					replay.setReplayTime(Date.valueOf(time));
					Message messageInfo=new Message();
					messageInfo.setMessageId(messageId);
					replay.setReplayMessage(messageInfo);

					//创建
					boolean result3=replayService.addReplay(replay);
					if(result3){
						//添加工作流
						Flow flow=new Flow();
						flow.setFlowId(0);
						flow.setFlowMessage(messageInfo);
						flow.setFlowEmp(emp2);
						flow.setFlowInfo("转交了这个问题");
						flow.setFlowTime(Date.valueOf(time));
						boolean result4=flowService.addFlow(flow);
						if(result4){		
							mav.setViewName("redirect:showAllMessage");
						}
				
					}
				}
				
			}
	
		}
		
		return mav;
	}
	
	
	
	/**
	 * 文件下载
	 * @throws IOException 
	 */
		@RequestMapping(value="/downloadFile",method=RequestMethod.GET)
		public void downloadFile(HttpServletResponse response,String filePath,
				HttpServletRequest request,String fileName) throws IOException{
			response.setHeader("content-type", "application/octet-stream");
			response.setContentType("application/octet-stream");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"),"ISO-8859-1"));
			String dirPath = request.getSession().getServletContext().getRealPath("/WEB-INF/files/");  
			String path=dirPath+filePath;
			File file=new File(path);
			byte[] buff = new byte[1024];
			BufferedInputStream bis = null;
			OutputStream os = null;
			os = response.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(file));
			int i = bis.read(buff);
			while (i != -1) {
				os.write(buff, 0, buff.length);
				os.flush();
				i = bis.read(buff);
			}
			
			if (bis != null) {
				bis.close();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}
