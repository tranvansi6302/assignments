<%@page import="models.Todo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<title>Update Todo</title>
</head>
<body>
	<div class="container">
		<%
			Todo todo = (Todo) request.getAttribute("todo");
		%>
		<h1 class="mt-5">Update Todo</h1>
		<form id="todoForm" class="mt-3" method="get" action="UpdateTodo">
    <div class="input-group mb-3">
        <input value="<%=todo.getTitle() %>" type="text" class="form-control" placeholder="Enter your todo here" name="title" aria-label="Recipient's username" aria-describedby="button-addon2">
        <div class="input-group-append">
            <button class="btn btn-primary" type="submit" id="button-addon2" form="todoForm">Update Todo</button>
            <input type="hidden" name="id" value="<%=todo.getId() %>">
        </div>
    </div>
</form>

		
	</div>
</body>
</html>