<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#container{
		width:100%;
		height: 100%;
	}
	
	#login{
		width:300px;
		height: 200px;
		margin-left:510px;
		margin-top: 220px;
	}
</style>
</head>
<body>
	<div id="container">
		<div id="login">
		<form action="login">
			<table>
				<tr>
					<td><input name="empName" placeholder="请输入您的用户名"/></td>
				</tr>
				<tr>
					<td><input name="passWord" placeholder="请输入您的密码" type="password"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="登录" style="margin-left:90px;"/></td>
				</tr>
			</table>
		</form>
		</div>
	</div>
</body>
</html>