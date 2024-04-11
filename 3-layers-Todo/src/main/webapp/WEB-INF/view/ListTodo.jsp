<%@page import="models.Todo"%>
<%@page import="java.util.List"%>
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
<title>TodoList</title>
</head>
<body>
	<%
	String message = (String) request.getAttribute("message");
	%>
	<div class="container">
		<h1 class="mt-5">Todo List</h1>
	
		<form id="todoForm" class="mt-3 needs-validation" method="get"
			action="CreateTodo">
			<div class="form-group">
				<input type="text" class="form-control <%=(message!=null) ? "is-invalid": ""%>"
					placeholder="Enter your todo here" name="title"
					>
				<div class="invalid-feedback"><%= (message!=null) ? message: "" %></div>
				<div class="mt-3">
					<button class="btn btn-primary px-5" type="submit" id="button-addon2"
						form="todoForm">Create Todo</button>
				</div>
			</div>
		</form>

		<ul id="todoList" class="mt-3 flex"
			style="list-style-type: none; padding: 0;">
			<%
			// Lặp qua danh sách todos và hiển thị chúng
			Object obj = request.getAttribute("todos");
			if (obj instanceof List<?>) {
				List<?> todos = (List<?>) obj;
				for (Object todo : todos) {
					if (todo instanceof Todo) {
				Todo todoItem = (Todo) todo;
			%>
			<li
				class="todo-item d-flex justify-content-between align-items-center text-primary mb-3"
				style="width: 100%;">
				<div style="flex-basis: 70%;">
					<%=todoItem.getTitle()%>
				</div>
				<div
					style="flex-basis: 30%; display: flex; justify-content: flex-end;">
					<a href="./DeleteTodo?id=<%=todoItem.getId()%>"
						class="btn btn-sm btn-danger delete-btn me-2">Delete</a> <a
						href="./EditTodo?id=<%=todoItem.getId()%>"
						class="btn btn-sm btn-warning edit-btn">Edit</a>
				</div>
			</li>
			<%
			}
			}
			}
			%>
		</ul>

	</div>
</body>
</html>
