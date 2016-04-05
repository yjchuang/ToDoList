package model;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ToDoListDB {

	public TypedQuery<Todolist> findAllTodolist() {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		return (TypedQuery<Todolist>) (em.createQuery(
				"SELECT t FROM Todolist t Order by t.listid"));
	}

	public long findAnyToDoList() {

		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
		TypedQuery queryCount = (TypedQuery) em1.createQuery(
				"SELECT Count(t) FROM Todolist t");
		long count = (long) queryCount.getSingleResult();
		return count;
	}

	public int updateToDoList(int listId, int doerId, String description, int statusId) {
		int count=0;
		EntityManager em4 = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em4.getTransaction();
		TypedQuery query = em4.createQuery(
				"UPDATE Todolist t set t.doerid=:_doerid, t.itemdescription=:_description, "
						+ "t.statusid=:_statusid WHERE t.listid=:_listid", Todolist.class)
				.setParameter("_doerid", doerId)
				.setParameter("_description", description)
				.setParameter("_statusid", statusId)
				.setParameter("_listid", listId);

		try {
			trans.begin();
			count=query.executeUpdate();
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em4.close();
		}

		return(count);
	}
	
	
	public static void insert(Todolist list) {
		EntityManager em2 = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em2.getTransaction();
		trans.begin();
		try {
		em2.persist(list);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em2.close();
		}
		}
	
	public TypedQuery<Todolist> findAllCompletedLis() {

		EntityManager em5 = DBUtil.getEmFactory().createEntityManager();
		return (TypedQuery<Todolist>) (em5.createQuery(
				"SELECT t FROM Todolist t where t.statusid=:statusid Order by t.listid" ).setParameter("statusid", 1));
	}

	public long findAnyCompletedList() {

		EntityManager em6 = DBUtil.getEmFactory().createEntityManager();
		TypedQuery queryCount = (TypedQuery) em6.createQuery(
				"SELECT Count(t) FROM Todolist t where t.statusid=:statusif").setParameter("statusif", 1);
		long count = (long) queryCount.getSingleResult();
		return count;
	}
	
	
	public static void update(Todolist list) {
		EntityManager em3 = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em3.getTransaction();
		trans.begin();
		try {
		em3.merge(list);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em3.close();
		}
		}
	
}
