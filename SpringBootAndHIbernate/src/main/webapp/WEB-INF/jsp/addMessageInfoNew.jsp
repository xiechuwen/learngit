<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add message Info</title>
<link href="/css/addMessageNew.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
		<script type="text/javascript">
				    function uploadFileOss() {  
				  /*   	 var formData = new FormData($( "#form" )[0]);   */
				    	 /* 	var form = $("<form></form>");  
				    	    form.append($(input));  
				    	    var formData = new FormData(form[0]);   */
				    	   var formData = new FormData($( "#form" )[0]);  
				        $.ajax({  
				            url : "uploadFile",  
				            type : 'POST',  
				            data : /* $( '#form').serialize() */formData,  	
				            async : false,  
				            cache : false,  
				            contentType : false,   
				             processData : false,   
				            success : function(returndata) {  
				                if (callback) {  
				                    callback(returndata);  
				                }  
				            },  
				            error : function(returndata) {  
				          
				            }  
				        });  
				          
				    }  
		</script>
		

<script type="text/javascript">
		//下拉框连动  
		function getNextClassify() { 
		
			// classNext.append("<option value="+data[i].stypeId+">"+data[i].stypeName+"</option>");  
			// classNext.append("<option value="+classifyId+">---无---</option>");  
			//获取下拉框主键  
			var classifyId=$("#classifys").find('option:selected').val();  
			$("#detailStype").empty();     //清空二级目录   
			var classNext=$("#detailStype");  
			$.ajax({    
			                  type: "post",    
			                  contentType:"application/json",    
			                  url : "queryStypeByTypeId?typeId="+classifyId,   
			                  success: function (data) { 
			            	  	var d=eval(data);
			                  	
			            	   $(d).each(function(index,entity){  
			            		/*    classNext.append("<option value="+"11"+">"+"aa"+"</option>");   */
			            		   classNext.append("<option value="+entity['stypeId']+">"+entity['stypeName']+"</option>");  
			            	   }); 
			            	  
			         		 }     
			});   
		}  
</script>


<!-- 添加一个 -->
<script type="text/javascript">
	
</script>

<script type="text/javascript">
		var i=0;
		var rowNumber=0;
	function add_tr(obj) {

	    var tr = $(obj).parent();
	    tr.after(tr.clone());
	    
		++i;
		var j=i-1;
		
		var detailStype = $("#detailStype").val();
		var detailStypeName=$("#detailStype option:selected");
		var detailStypeNameFinal=detailStypeName.text();
		var messageInfo = $("#messageInfo").val();
		tr.find("div").get(0).innerHTML="<input  name=messageDetails["+j+"].detailStype id=detailStype"+j+" type=hidden value="+detailStype+" />"+detailStypeNameFinal;
		tr.find("div").get(1).innerHTML="<input  name=messageDetails["+j+"].messageInfo id=messageInfo"+j+" type=hidden value="+messageInfo+" />"+messageInfo;
/* 		tr.find("div").get(3).innerHTML="<input type=button style="+"width:100%;height: 100%;line-height:15px;"+" name=DelRow"+j+"id=DelRow"+j+ onclick=delRow("+j+") value="+'删除'+" />"; */
		rowNumber=i;
		$("#detailStype").attr("value","");
		$("#messageInfo").attr("value","");

  	}
	
	
	
	
	function delRow(id){	
		var account = $("#account"+id).val();
		$("#myTable tr").eq(id+1).remove();
		var rowNumber=$("#rowNumber").val();
			for(var s=id+1;s<rowNumber;s++){
			$("#item"+s).attr("name","claimVoucherDetail["+(s-1)+"].item");
			$("#item"+s).attr("id","item"+(s-1));
			$("#account"+s).attr("name","claimVoucherDetail["+(s-1)+"].account");
			$("#account"+s).attr("id","account"+(s-1));
			$("#desc"+s).attr("name","claimVoucherDetail["+(s-1)+"].des");
			$("#desc"+s).attr("id","desc"+(s-1));		
			var js="delRow("+(s-1)+");";
			var newclick=eval("(false||function (){"+js+"});");
			$("#DelRow"+s).unbind('click').removeAttr('onclick').click(newclick);
			$("#DelRow"+s).attr("id","DelRow"+(s-1));					
			}
		$("#rowNumber").attr("value",rowNumber-1);
		--i;

	}
	
	
	function submitAction(){

		document.claimForm.submit();
	}
	
</script>


<script type="text/javascript">
	
</script>

</head>
<body>		
	<div id="container">
			<div id="left">
				<div id="left-top"style="color:#C4D0BA;font-size:30px;text-indent:20px;;font-style:normal; line-height:80px">
					MS SYSTEM
				</div>
				<div id=left-middle>
					<div id="midle-title">somepeple something</div>
					<div class="midle-select">showAllMessage</div>
					<div class="midle-select"><a style="text-decoration: none" href="javascript:location.reload();">addMessageInfo</a></div>
					
				</div>
				 <script type="text/javascript">
				        $(function(){
				        	/* $(".midle-select").click(function () {
					            $(this).next("ul").slideToggle(300).siblings("ul").slideUp(400);
					            $(this).addClass("hover").siblings().removeClass("hover");
						  	
					     	 
					        })	 */
					        
					    	$("#rightMain").hide();
					    	$('.midle-select').each(function(i){
					    			$(this).click(function(){
				     					document.getElementById("rightMain").src=$(this).text(); 
				     				 	$("#rightMain").show();
				     					$("#right2").hide();
				     				});
					     		});
					     	
					     	});
				        
   			 </script>
				
				<div id=left-bottom></div>
			</div>
		
		
			
			<div id="right">
			
				<iframe name="left" id="rightMain" src="" frameborder="false" scrolling="auto" style="border:none;width:100%;height:680px; allowtransparency="true">
				
				</iframe>
				
				<div id="right2">
				<div id="right-top"></div>
				<div id="right-title">
					Problem Center
				</div>
	<form action="addMessageInforMation" name="claimForm" enctype="multipart/form-data" method="post">				
				<!-- 左边主信息显示 -->
				<div id="left-form">
					<div class="left-form-title">基本信息显示</div>
					<div id="img">
						<div id="file">
								[<a href="#">添加附件</a>]（一次最多上传5个附件,附件名为空时默认使用上传的文件名） 
						</div>
						
						<div id="fileList" >
							文档名：<input type="text" style="width:100px"/>
							<input type="file" name="files"/>
							<a href="#">[X]</a>
						</div>
					</div>
					
				</div>
				
				
		
				<!-- 右边信息登记 -->
				<div id="right-form">
					<div class="left-form-title">基本问题记录</div>
					
			
					<div id="type">
						<div class="type-words">问题类型</div>　
						<div class="type-input"><select name="message.messageType" id="classifys" style="width:130px;text-align: center;margin-top:6px"  onChange="getNextClassify()">
						<c:forEach items="${tlist}" var="tlist" >
							<option value="${tlist.typeId}">${tlist.typeName }</option>
						</c:forEach>
						
						</select></div>
						
						<!-- 第二个下拉框 -->
						<div class="next-type">
							<select name="detailStype" style="width:130px;text-align: center;margin-top:6px"  id="detailStype" >
								<option value="">请选择</option>  
						</select>
  					   </div>  	
  					   
  					   
					</div>
					
					
					<div id="title">
						<div class="type-words">问题标题</div>
						<div class="type-input1"><input name="message.messageTitle" placeholder="请输入您遇到的问题标题" style="width:285px;height:30px;margin-top:3px;"/></div>
					</div>
					<div id="messageInfo1">
						<div id="person">　<span>创建人：</span>${emp.empName}</div>
						<div id="nextperson"><span>处理人：</span>${nextEmp.empName}</div>
						<input type=hidden name="message.messageEmp" value=${emp.empNo}>
						<input type=hidden name="message.messageNextDealEmp" value=${nextEmp.empNo}>
					</div>
					
			
				</div>
				
				
				<!--　下面详情登记　-->
				
				<div id="detail">
					<div id="detail-top">详细问题记录</div>
					
					
			<!-- 提交多个详情 -->
		
					<!-- 多个详情 -->
					<div id="detail-info"  >
					
						
						<div class="info-new">
							<textarea id="textArea" name="detailInfo" rows="15" cols="80" style="padding:10px;border: 1px solid black"></textarea>
							
							<script type="text/javascript">
								 	CKEDITOR.replace("textArea");  
								</script>
						</div>
						
						
					
					

					<div id="detail-submit"style="font-size:16px;color:white;text-align: center;line-height: 30px" onclick="submitAction()">填写完毕</div>
			
				</div>
					
					
				</div>
				</form>		
		</div>
			
			</div>
			
	</div>
</body>
</html>