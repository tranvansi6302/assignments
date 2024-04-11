package repositories;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dtos.TodoDTO;
import models.Todo;
import utils.HibernateUtil;

public class TodoRepository implements ITodoRepository {

	@Override
	public void createTodo(TodoDTO todoDTO) {

		Todo todo = new Todo();
		todo.setTitle(todoDTO.getTitle());
		todo.setCompleted(false);
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(todo);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
            session.close();
        }

	}

	@Override
	public List<Todo> readTodo() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			TypedQuery<Todo> query = session.createQuery("FROM Todo", Todo.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
		return null;

	}

	@Override
	public void updateTodo(TodoDTO todoDTO) {
		// TODO Auto-generated method stub
		Todo todo = new Todo();
		todo.setId(todoDTO.getId());
		todo.setTitle(todoDTO.getTitle());
		todo.setCompleted(false);
		Session session = HibernateUtil.getSessionFactory().openSession();
		try  {
			Transaction transaction = session.beginTransaction();
			session.update(todo);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void deleteTodo(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try  {
			Transaction transaction = session.beginTransaction();
			Todo todo = session.get(Todo.class, id);
			session.delete(todo);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public Todo getTodoById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Todo todo = session.get(Todo.class, id);
			return todo;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Boolean duplicateTitle(String title) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			TypedQuery<Todo> query = session.createQuery("FROM Todo WHERE title = :title", Todo.class);
			query.setParameter("title", title);
			if (query.getResultList().size() > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

}
