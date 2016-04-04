package model;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ToDoListDB {

	public TypedQuery<Todolist> findAllTodolistWithName() {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		return (TypedQuery<Todolist>) (em.createQuery(
				"SELECT t FROM Todolist t"));
}

	public long findAnyToDoList() {

		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
		TypedQuery queryCount = (TypedQuery) em1.createQuery(
				"SELECT Count(t) FROM Todolist t");
		long count = (long) queryCount.getSingleResult();
		return count;
	}

}
