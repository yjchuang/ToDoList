

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ToDoListDB;
import model.Todolist;

/**
 * Servlet implementation class ToDoListProcess
 */
@WebServlet("/ToDoListProcess")
public class ToDoListProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ToDoListProcess() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		String _assignmentName = "";
		long toDoLisCount = 0;
		ToDoListDB listFromDb = new ToDoListDB();
		HttpSession session = request.getSession();

		List<Todolist> myToDoList=null;
		String _name="";

		if(request.getParameter("page").equals("1")==true)
		{
			_name=request.getParameter("name"); 
			toDoLisCount = listFromDb.findAnyToDoList();
			if(toDoLisCount > 0)
			{

				myToDoList = listFromDb.findAllTodolistWithName().getResultList();

				//System.out.println("We have something in the assignmentList");
				request.setAttribute("myToDoList", myToDoList);
				request.getRequestDispatcher("/MyToDoListPage.jsp").forward(request, response);

			}
		}
	}
}
