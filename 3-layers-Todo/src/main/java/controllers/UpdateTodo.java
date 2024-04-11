package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Todo;
import services.TodoService;

import java.io.IOException;

import dtos.TodoDTO;


public class UpdateTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTodo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodoService todoService = new TodoService();
		String id = request.getParameter("id");
		Todo todoEdit = todoService.getTodoById(Integer.parseInt(id));
		String title = request.getParameter("title");
		// Validate title
		if (title == null || title.isEmpty()) {
			request.setAttribute("message", "Title is required");
			request.getRequestDispatcher("ListTodo").forward(request, response);
			return;
		}
		if (title != todoEdit.getTitle() &&todoService.duplicateTitle(title)) {
			request.setAttribute("message", "Title already exists");
			request.getRequestDispatcher("ListTodo").forward(request, response);
			return;
		}
		TodoDTO todo = new TodoDTO(Integer.parseInt(id), title);
		todoService.updateTodo(todo);
		response.sendRedirect("ListTodo");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
