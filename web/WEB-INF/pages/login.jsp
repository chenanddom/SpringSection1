<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>小春论坛登录</title>
	</head>
	<body>
		<c:if test="${!empty error}">
	        <font color="red"><c:out value="${error}" /></font>
		</c:if>        
		<form action="<c:url value="loginCheck.html"/>" method="post">
			<table>
				<tr>
					<td>用户名:</td>
				</tr>
				<tr>
					<td><input type="text" name="userName"></td>
				</tr>

				<tr>
					<td>密 码:</td>
				</tr>
				<tr>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><input type="submit" value="登录"/></td>
					<td><input type="reset" value="重置"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>
