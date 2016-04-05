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
	<br>
	<form action="ToDoListProcess" method="post">
	<h3>Update List:</h3>
		<p>
			<input type="hidden" name="page" value="2"> 			
			List ID: <input type="text" name="listid"><br> 
			Description: <input type="text" name="descrip"><br> 
			Due Date: <input type="date" name="duedate" min="2016-01-01" max="2017-01-01"><br>			
			Complete Date: <input type="date" name="completedate" min="2016-01-01" max="2017-01-01"><br>
			Responsible: <input type="number" name="responsible" min="1" max="3"><br>
			Status: <input type="number" name="status" min="1" max="3"><br>
			<input type="submit" value="Update"> <br>
		</p>
	</form>
	<br>

<form action="ToDoListProcess" method="post">
	<h3>Add List:</h3>
		<p>
			<input type="hidden" name="page" value="3"> 			
			List ID: <input type="text" name="listid"><br> 
			Description: <input type="text" name="descrip"><br> 
			Due Date: <input type="date" name="duedate" min="2016-01-01" max="2017-01-01"><br>			
			Complete Date: <input type="date" name="completedate" min="2016-01-01" max="2017-01-01"><br>			
			Responsible: <input type="number" name="responsible" min="1" max="3"><br>
			Status: <input type="number" name="status" min="1" max="3"><br>
			<input type="submit" value="Add"> <br>
		</p>
	</form>
	
	<form action="ToDoListProcess" method="post">
	<h3>Completed ToDo List:</h3>
		<p>
			<input type="hidden" name="page" value="4"> 			
			<input type="submit" value="Report"> <br>
		</p>
	</form>

</body>
</html>