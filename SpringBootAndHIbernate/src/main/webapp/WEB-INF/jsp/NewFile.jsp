<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-2.1.4.min.js"></script>
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
				                alert("上传图片出错");  
				            }  
				        });  
				          
				    }  
		</script>
</head>
<body>
<form action="" name="chain" id="form" enctype="multipart/form-data">
	<input type="file" id="fileInfo" name="file"/><br>
	  <input type="button" value="点击上传" onclick="uploadFileOss()"/>
</form>
</body>
</html>