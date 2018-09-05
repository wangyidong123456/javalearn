<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>添加客户</h3>

<form action="${ pageContext.request.contextPath }/customerAction_save.action" method="post">
	客户名称：<input type="text" name="cust_name"/><br>
	客户电话：<input type="text" name="cust_mobile"/><br>
	<input type="submit" value="提交" />
</form>
	
</body>
</html>