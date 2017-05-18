<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/css/dealMessage.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
		//下拉框连动  
		function getNextEmp() { 
		
			// classNext.append("<option value="+data[i].stypeId+">"+data[i].stypeName+"</option>");  
			// classNext.append("<option value="+classifyId+">---无---</option>");  
			//获取下拉框主键  
			var deptNo=$("#dept").find('option:selected').val();  
			$("#emp").empty();     //清空二级目录   
			var classNext=$("#emp");  
			$.ajax({    
			                  type: "post",    
			                  contentType:"application/json",    
			                  url : "queryAllEmpByDeptNo?deptNo="+deptNo,   
			                  success: function (data) { 
			            	  	var d=eval(data);
			            	   $(d).each(function(index,entity){  
			            		/*    classNext.append("<option value="+"11"+">"+"aa"+"</option>");   */
			            		   classNext.append("<option value="+entity['empNo']+">"+entity['empRealName']+"</option>");  
			            	   }); 
			            	  
			         		 }     
			});   
		}  
		
		
		/* 组长提交 */
		function submitClaimVoucher(action){
	   		if(!confirm("确定"+action+"该问题吗")) return;
	   		if (action == '派人处理'){
	   			document.getElementById("messageStatus").value="已分配,待接受";
	   		}else{
	   			document.getElementById("messageStatus").value="已完成";
	   		}
	   		
	   		document.claimForm.submit();
		   		
		 }
		
		
		/* 开发提交 */
		function doSubmitClaimVoucher(action){
	   		if(!confirm("确定"+action+"该问题吗")) return;
	   		document.claimForm.submit();  		
		 }

</script>
</head>
<body>
	<form action="dealMessageById" name="claimForm" >
		<input name="messageId" value="${message.messageId }" type="hidden"/>
		<input name="messageEmpNo" value="${message.messageEmp.empNo}" type="hidden"/>
		
	<div id="container">

		<div id="left">
			<div id="left-top">MESSAGE INFO</div>
			<div id="message-title">
				<span style="margin-left: 30px;font:bold 30px '微软雅黑'">${message.messageTitle}</span>
					<input name="messageTitle" value="${message.messageTitle}}" type="hidden"/>
			</div>
			<div id="message-type">
				类型:<span style="margin-left: 30px;font:bold 16px '微软雅黑'">${message.messageType.typeName }</span>
					<input name="messageType" value="${message.messageType}" type="hidden"/>
			</div>
			<div id="message-date">
				日期：<span style="margin-left: 30px;font:bold 16px '微软雅黑'">${message.messageCreateTime }</span>
					<input name="messageCreateTime" value="${messageCreateTime}" type="hidden"/>
			</div>
			<div id="message-status">
				状态:<span style="margin-left: 30px;font:bold 16px '微软雅黑'">${message.status }</span>
					<input name="messageStatus" id="messageStatus" value="" type="hidden"/>
			</div>
			<div id="message-person">
				创建人:<span style="margin-left: 30px;font:bold 16px '微软雅黑'">${message.messageEmp.empRealName }</span>
					<input name="messageEmp" value="${message.messageEmp.empNo}" type="hidden"/>
			</div>
			<div id="message-nextperson">
				处理人：<span style="margin-left: 30px;font:bold 16px '微软雅黑'">${message.messageNextDealEmp.empRealName }</span>
					<input name="messageNextDealEmp" value="${message.messageNextDealEmp}" type="hidden"/>
			</div>
			
			
		    <div id="replay">
				<div id="replay-top">
					<div id="FlowEmp" style="border: 1px solid red;margin-right: 5px">历史处理人</div> <div id="ReplayEmp" style="border: 1px solid red">评论</div>
				</div>
							<script type="text/javascript">
										$(function(){
											$(".replayList").hide();
											$("#FlowEmp").css("background-color","tomato");
											
											$("#ReplayEmp").click(function(){
												$(".flowList").hide();
												$(".replayList").show();	
												$("#FlowEmp").css("background-color","");
												$("#ReplayEmp").css("background-color","tomato");
											});
											
											$("#FlowEmp").click(function(){
												$("#ReplayEmp").css("background-color","");
												$("#FlowEmp").css("background-color","tomato");
												$(".replayList").hide();
												$(".flowList").show();
											});
										});
							</script>
			
				<c:forEach var="dd" items="${message.messageReplay }">
					<div class="replayList">
						<div id="replayName">${dd.replayEmp.empName }</div>
						
						<div id="replayInfo"><textarea disabled="disabled" readonly="readonly" rows="3" cols="">${dd.replayInfo }</textarea>
					 	</div>
							
						<div id="replayDate">${dd.replayTime}</div>
					</div>
				</c:forEach>
				
				
				<c:forEach var="dd" items="${message.messageFlows }">
					<div class="flowList">
						<div id="replayName">${dd.flowEmp.empName }</div>
						
						<div id="replayInfo" style="margin-top:15px;"><%-- <textarea disabled="disabled" readonly="readonly" rows="3" cols="">${dd.flowInfo }</textarea> --%>
							${dd.flowInfo }
					 	</div>
							
						<div id="replayDate">${dd.flowTime}</div>
					</div>
				</c:forEach>
				
				
				
			</div>
			
			
		</div>
		<input name="dealEmp" type="hidden" value="${emp1.empNo}"/>
		
		<div id="right">
			<div id="right-top">DEAL INFO</div>
			
			<div id="detail-type">
				<div id="detail-type-type">Type</div>
				<div id="detail-type-info">Info</div>
			</div>
			
			<c:forEach var="detail" items="${dlist}" varStatus="vs">
			
			
			<div id="detail-info">
				<div id="info-type">${detail.detailStype.stypeName }</div>
				<input name="messageDetails[${vs.index-1 }].detailStype" value="${detail.detailStype}" type="hidden"/>
				<div id="info-info"><%-- ${detail.messageInfo } --%>
				<%-- <input name="messageDetails[${vs.index-1 }].messageInfo" value="${detail.messageInfo}" type="hidden"/> --%>
				<textarea style="font-size: 14px" disabled="disabled" readonly="readonly" rows="10" cols="50">${detail.messageInfo}</textarea>
				</div>
			</div>
			
			</c:forEach>
			
			<div id="fileMerge">
				附件
			</div>
			<!-- 显示附件 -->
			<c:forEach var="cc" items="${message.messageFiles}">
			<div id="filesList">
				<div id="fileName"> ${cc.fileName } </div>
				<div id="fileDo"><a href="downloadFile?filePath=${cc.filePath}&fileName=${cc.fileName}">打开</a></div>
			</div>
			</c:forEach>
			
			<div id="detail-end"></div>
			
			<div id="idea-type">
				请输入您的意见：
				
			</div>
			
			<div id="idea-info">
				<textarea name="messageReback" rows="5" cols="58" style="padding:10px"></textarea>
				
					<script type="text/javascript">
						/* 	CKEDITOR.replace("messageReback"); */
					</script>
			</div>
			
			<div id="detail-deal">
			
				<!-- 只能查看 -->
				<c:if test="${realDeal eq 2 || realDeal eq 1 && emp1.empPosition.positionId ne 2}">
					
				</c:if>
				
				<!-- 组长级别处理  -->
				<c:if test="${realDeal eq 1 && emp1.empDept.deptName ne '开发部' && emp1.empPosition.positionId eq 2}">
					<input name="empRealNo" value=0 type="hidden"/>
					<div id="deal">
						<div id="deal-ico"></div>
						<div id="deal-message" onclick="submitClaimVoucher('派人处理')" style="font-size:14px;color:white">派人处理</div>
					</div>
					<!-- <input type="hidden" name="status"/>
					 -->
					<div id="type"> <select id="dept" style="width:120px;" onchange="getNextEmp()">
						<option value=0>--[部门]请选择--</option>
						<c:forEach var="dept" items="${delist }">
							<option value="${dept.deptNo }">${dept.deptName }</option>
						</c:forEach>
						
					</select>
					
					</div>
					<div id="stype">
						<select id="emp" name="emp" style="width:140px;height: 100%;">
						<option value=0>--[员工]请选择--</option>
					</select>
					</div>
					
				<div id="reback">
					<div id="reback-ico"></div>
					<div id="reback-message"style="font-size:14px;color:white" onclick="submitClaimVoucher('完成')">完成</div>
				</div>
				
				</c:if>
				
				
				<!-- 技术人员处理  -->
				<c:if test="${realDeal eq 1 && emp1.empDept.deptName eq '开发部'}">
					<input type="hidden" name="emp" value="11"/>
						<div id="choose">
							<div id="accpt" style="margin-right: 15px"><input name="deal" type="radio" value="完成" checked="checked"/> 完成</div>
						<!-- 	<div id="delay" style="margin-left: 15px"><input name="deal" type="radio" value="延后挂起"/>延后挂起</div> -->
								<div id="change" style="margin-left: 15px"><input name="deal" type="radio" value="重新指向给用户"/>[解决不了]重新指向给用户</div>
							<div id="changeEmp" style="margin-left: 15px">
								<select id="dept" style="width:120px;" onchange="getNextEmp()">
									<option value=0>--[部门]请选择--</option>
									<c:forEach var="dept" items="${delist }">
										<option value="${dept.deptNo }">${dept.deptName }</option>
									</c:forEach>
								</select>
								
								<select id="emp" name="empRealNo" style="width:140px;height: 100%;">
									<option value=0>--[员工]请选择--</option>
								</select>
							</div>
						</div>
						
						<div id="sub">
							<div id="submits" style="width:100px;height: 30px; text-align: center;line-height: 30px;
							background-color:tomato;color:white" onclick="doSubmitClaimVoucher('提交')">提交</div>
						</div>
				</c:if>
				
				
			
			</div>
			
		</div>
	</div>
	</form>
</body>
</html>