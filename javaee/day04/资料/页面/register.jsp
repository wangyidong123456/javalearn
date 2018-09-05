<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  
	 
  </head>
  <body>
  	<center>
  		<form action="/test/registerServlet" method="post">
			<table>
				<tr>
					<td>用户名<font color="red">*</font></td>
					<td><input type="text" name="name"/></td>
				</tr>			
				<tr>
					<td>密码</td>
					<td><input type="password" name="password"/></td>
				</tr>			
				<tr>
					<td>确认密码</td>
					<td><input type="password" name="repassword"/></td>
				</tr>	
				<tr>
					<td>年龄</td>
					<td><input type="text" name="age"/></td>
				</tr>			
				<tr>
					<td>性别</td>
					<td>
						<input type="radio" name="sex" value="男"/>男
						<input type="radio" name="sex" value="女"/>女
					</td>
				</tr>			
				<tr>
					<td>邮箱</td>
					<td><input type="text" name="email"/></td>
				</tr>	
				<tr>
					<td>生日</td>
					<td><input type="text" name="birthday" id="birthday"/></td>
				</tr>			
				<tr>
					<td>爱好</td>
					<td>
						<input type="checkbox" name="hobby" value="C"/>C
						<input type="checkbox" name="hobby" value="C++"/>C++
						<input type="checkbox" name="hobby" value="Java"/>Java
						<input type="checkbox" name="hobby" value="IOS"/>IOS
						<input type="checkbox" name="hobby" value="PHP"/>PHP
						<input type="checkbox" name="hobby" value="Android"/>Android
					</td>
				</tr>			
				<tr>
					<td>地址</td>
					<td>
						<select name="address">
							<option value="none">--请选择地址--</option>
							<option value="北京">北京</option>
							<option value="上海">上海</option>
							<option value="南京">南京</option>
							<option value="广州">广州</option>
							<option value="深圳">深圳</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>自我描述</td>
					<td>
						<textarea cols="40" rows="10" name="description"></textarea>
					</td>
				</tr>				
				<tr>
	  				<td><input type="submit" value="注册" /></td>
	  				<td></td>
	  			</tr>
			</table>  		
  		</form>
  	</center>
  </body>
</html>
					