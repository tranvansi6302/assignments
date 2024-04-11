package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.TodoService;

import java.io.IOException;

import dtos.TodoDTO;

public class CreateTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateTodo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		TodoService todoService = new TodoService();
		String message = "";
		String todoTitle = request.getParameter("title");
		
		// Validate title
		if (todoTitle == null || todoTitle.isEmpty()) {
			message = "Title is required";
			request.setAttribute("message", message);
			request.getRequestDispatcher("ListTodo").forward(request, response);
			return;
		}
		if (todoService.duplicateTitle(todoTitle)) {
			message = "Title already exists";
			request.setAttribute("message", message);
			request.getRequestDispatcher("ListTodo").forward(request, response);
			return;
		}
		TodoDTO todo = new TodoDTO(todoTitle);
		todoService.createTodo(todo);
		response.sendRedirect("ListTodo");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
