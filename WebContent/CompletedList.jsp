<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CompletedList</title>
</head>
<body>
<h2>I have these completed on ToDo list:</h2>
	 <table border="1" style="width:100%">
		<tr>
			<th>List Id</th>
			<th>Description</th>
			<th>Due Date</th>
			<th>Responsible Person ID</th>
			<th>Status</th>
		</tr>
		<c:forEach items="${myToDoList}" var="toDoItem">
			<tr>				
				<td><c:out value="${toDoItem.listid}" /></td>
				<td><c:out value="${toDoItem.itemdescription}" /></td>
				<td><c:out value="${toDoItem.duedate}" /></td>
				<td><c:out value="${toDoItem.doerid}" /></td>
				<td><c:out value="${toDoItem.statusid}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>