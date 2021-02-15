<%@page import="com.dao.UserDAO"%>
<%@page import="com.bean.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Page</title>
</head>
<body>
	<%
		List<UserBean> list = UserDAO.getAllStudents();
	%>
	<table border="1" width="100%" cellpadding=5 cellspacing=5>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>POINTS</th>
			<th>EDIT</th>
		</tr>
		<%
			for (UserBean s : list) {
		%>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getName()%></td>
			<td><%=s.getPoints() %></td>
			<td>
				<form action="ActionController" method="post">
					<input type="hidden" name="id" value="<%=s.getId()%>"> <input
						type="submit" name="action" value="edit">
				</form>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="index.jsp">Insert again</a>
</body>
</html>