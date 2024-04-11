package main;

import java.util.List;

import models.Todo;
import services.TodoService;


public class Main {
	public static void main(String[] args) {
		
		// Test
		 TodoService service = new TodoService();
		 
		 List<Todo> todos =  service.readTodo();
			for (Todo todo : todos) {
				System.out.println(todo.getTitle());
			}
		 
	}
}
