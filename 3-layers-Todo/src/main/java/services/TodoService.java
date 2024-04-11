package services;

import java.util.List;

import dtos.TodoDTO;
import models.Todo;
import repositories.TodoRepository;

public class TodoService implements ITodoService {
	private TodoRepository todoRepository;

	public TodoService() {
		this.todoRepository = new TodoRepository();
	}

	@Override
	public void createTodo(TodoDTO todoDTO) {
	
		todoRepository.createTodo(todoDTO);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTodo(TodoDTO todoDTO) {
		todoRepository.updateTodo(todoDTO);
		
	}

	@Override
	public void deleteTodo(Integer id) {
		todoRepository.deleteTodo(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Todo> readTodo() {
		// TODO Auto-generated method stub
		return todoRepository.readTodo();
	}

	@Override
	public Todo getTodoById(Integer id) {
		// TODO Auto-generated method stub
		return todoRepository.getTodoById(id);
	}

	@Override
	public Boolean duplicateTitle(String title) {
		// TODO Auto-generated method stub
		return todoRepository.duplicateTitle(title);
	}
	

	

}
