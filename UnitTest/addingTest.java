import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.TypedQuery;

import org.junit.Test;

import model.ToDoListDB;
import model.Todolist;

public class addingTest {

	Todolist S = new Todolist();
	ToDoListDB tdb = new ToDoListDB();
	long count=0;
	List<Todolist> myToDoList=null;


	@Test
	public void test_findAnyToDoList() {
		
		count = tdb.findAnyToDoList();
		
		System.out.println("Test if findAnyToDoList works...") ;

		assertTrue(count > 0) ;
	}

	@Test
	public void test_findAllTodolist() {
		System.out.println("Test if findAllTodolist works...") ;
		
		myToDoList = tdb.findAllTodolist().getResultList();
		System.out.println("==== myToDoList =====> " + myToDoList + " <===========");

		assertTrue(myToDoList!=null) ;
	}

	@Test
	public void test_findAllCompletedLis() {
		System.out.println("Test if findAllCompletedLis works...") ;
	
		myToDoList = tdb.findAllCompletedLis().getResultList();
		System.out.println("==== myToDoList =====> " + myToDoList + " <===========");


		assertTrue(myToDoList!=null) ;
	}
	
	@Test
	public void test_findAnyCompletedList() {
		
		count = tdb.findAnyCompletedList();
		
		System.out.println("Test if findAnyCompletedList works...") ;

		assertTrue(count > 0) ;
	}

}
