<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息</title>
</head>
<body>
员工编号：${employee.empno}<br>
员工姓名：${employee.ename}<br>
员工工作：${employee.job}<br>
员工薪资：${employee.sal}<br>
员工奖金：${employee.comm==null?0:employee.comm}<br>
员工入职日期：<fmt:formatDate value="${employee.hiredate}" pattern="yyyy-M-d" /><br>
</body>
</html>