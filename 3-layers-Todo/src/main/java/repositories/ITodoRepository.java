package repositories;

import java.util.List;

import dtos.TodoDTO;
import models.Todo;

public interface ITodoRepository {
	public void createTodo(TodoDTO todoDTO);

	public List<Todo> readTodo();

	public void updateTodo(TodoDTO todoDTO);

	public void deleteTodo(Integer id);
	
	public Todo getTodoById(Integer id);
	
	public Boolean duplicateTitle(String title);
}
