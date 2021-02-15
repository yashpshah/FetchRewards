<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page</title>
</head>
<body>
<form action="ActionController" method="post">
	<table>
	
		<tr>
			<td>Name</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>Points</td>
			<td><input type="text" name="points"></td>
		</tr>
		<tr>
			
			<td><input type="submit" name="action" value="Insert" ></td>
		</tr>
		<tr>
			<td><a href="display.jsp">Show Details</a></td>
		</tr>
	</table>
</form>
</body>
</html>