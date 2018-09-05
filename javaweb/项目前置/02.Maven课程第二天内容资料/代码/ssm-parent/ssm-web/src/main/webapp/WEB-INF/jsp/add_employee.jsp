<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>添加员工</h2>
	<form action="add" method="post">
		<input type="text" name="empno" placeholder="编号"><br>
		<input type="text" name="ename" placeholder="姓名"><br>
		<input type="text" name="job" placeholder="工作"><br>
		<input type="text" name="sal" placeholder="薪资"><br>
		<input type="text" name="comm" placeholder="奖金"><br>
		<input type="submit" value="添加">
	</form>
</body>
</html>