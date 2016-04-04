<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyToDoListPage</title>
</head>
<body>

<h2>I have these items on ToDo list:</h2>
	<table>
		<tr>
			<th>Description</th>
			<th>Due Date</th>
			<th>Responsible Person ID</th>
			<th>Status</th>
		</tr>
		<c:forEach items="${myToDoList}" var="toDoItem">
			<tr>
				<td><c:out value="${toDoItem.itemdescription}" /></td>
				<td><c:out value="${toDoItem.duedate}" /></td>
				<td><c:out value="${toDoItem.doerid}" /></td>
				<td><c:out value="${toDoItem.statusid}" /></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form action="ToDoListProcess" method="post">
	<h3>Update List:</h3>
		<p>
			<input type="hidden" name="page" value="2"> Description: <input
				type="text" name="descrip"><br> 
				<!-- Enter Due Date: <input type="text" name="assign_name">
				<br>
			Enter Assignment Type: <input type="text" name="assign_type"><br>
			Enter Student Grade: <input type="text" name="grades"><br> -->
			<input type="submit" value="Update"> <br>
		</p>
	</form>



</body>
</html>