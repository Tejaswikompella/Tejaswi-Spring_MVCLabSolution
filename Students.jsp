<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Record</title>
</head>
<body>
	<table>
		<tr>
			<td><a href="addStudent?id=-1">Add a new Student</a></td>
		</tr>
	</table>
	
	<table border="1">
		<tr>
			<th>Id</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Country</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${studentList}" var="s">
			<tr>
				<td>${s.id}</td>
				<td>${s.firstName}</td>
				<td>${s.lastName }</td>
				<td>${s.country }</td>
				<td><a href="addStudent?id=${s.id}">Update</a><a
					href="deleteStudent?id=${s.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
