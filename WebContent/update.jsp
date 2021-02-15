<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete points</title>
</head>
<body>
	<%
		UserBean s = (UserBean) request.getAttribute("s");
	%>
	<form action="ActionController" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="<%=s.getName()%>"></td>
			</tr>
			<tr>
				<td>Points</td>
				<td><input type="text" name="points" value="<%=s.getPoints()%>"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="id" value="<%=s.getId()%>"></td>
				<td><input type="hidden" name="beforePoints"
					value="<%=s.getPoints()%>"></td>
				<td><input type="submit" name="action" value="Add"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="id" value="<%=s.getId()%>"></td>
				<td><input type="hidden" name="beforePoints"
					value="<%=s.getPoints()%>"></td>
				<td><input type="submit" name="action" value="Delete"></td>
			</tr>
		</table>
		<a href="display.jsp">Show details</a>
	</form>
</body>
</html>