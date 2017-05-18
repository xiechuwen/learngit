<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Say Hi!</h1>
	<a href="showUserById.action">ok</a>
		
	<h1>
		我叫<span style="color:tomato">${emp.eName}</span>
	</h1>
	
	<table>
		<tr>
			<td>编号<td>
			<td><span style="color:tomato">${emp.empno}</td>
		</tr>
		
		<tr>
			<td>姓名<td>
			<td><span style="color:tomato">${emp.eName}</td>
		</tr>
		
		<tr>
			<td>职位<td>
			<td><span style="color:tomato">${emp.job}</td>
		</tr>
		
		<tr>
			<td>上级编号<td>
			<td><span style="color:tomato">${emp.mgr}</td>
		</tr>
		
		<tr>
			<td>入职日期<td>
			<td><span style="color:tomato">${emp.hiredate}</td>
		</tr>
		
		<tr>
			<td>薪水<td>
			<td><span style="color:tomato">${emp.sal}</td>
		</tr>
		
		
		<tr>
			<td>部门编号<td>
			<td><span style="color:tomato">${emp.deptNo}</td>
		</tr>
	</table>
</body>
</html>