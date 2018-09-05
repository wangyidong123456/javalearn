<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工列表</title>
</head>
<body>
<a href="add">创建员工</a>
<table border="1">
	<tr>
		<td>编号</td>
		<td>姓名</td>
		<td>工作</td>
		<td>薪资</td>
		<td>奖金</td>
		<td>入职日期</td>
		<td>部门编号</td>
		<td>删除</td>
	</tr>
	<c:forEach items="${employees}" var="employee">
		<tr>
		<td>${employee.empno}</td>
		<td>${employee.ename}</td>
		<td>${employee.job}</td>
		<td>${employee.sal}</td>
		<td>${employee.comm}</td>
		<td>${employee.hiredate}</td>
		<td>${employee.deptno}</td>
		<td><a href="delete?empno=${employee.empno}">删除</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>