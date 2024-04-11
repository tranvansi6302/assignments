package services;

import java.util.List;

import dtos.TodoDTO;
import models.Todo;

public interface ITodoService {
	public void createTodo(TodoDTO todoDTO);
	public void updateTodo(TodoDTO todoDTO);
	public void deleteTodo(Integer id);
	public List<Todo> readTodo();
	public Todo getTodoById(Integer id);
	public Boolean duplicateTitle(String title);
}
