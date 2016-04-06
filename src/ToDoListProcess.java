

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		long toDoLisCount = 0, count=0;
		ToDoListDB listFromDb = new ToDoListDB();
		ToDoListDB addedList = new ToDoListDB();
		ToDoListDB completedList = new ToDoListDB();

		HttpSession session = request.getSession();
		String message="";

		List<Todolist> myToDoList=null;
		
		if(request.getParameter("page").equals("1")==true)
		{
		
			toDoLisCount = listFromDb.findAnyToDoList();
			if(toDoLisCount > 0)
			{
				myToDoList = listFromDb.findAllTodolist().getResultList();

				//System.out.println("We have something in the assignmentList");
				request.setAttribute("myToDoList", myToDoList);
				request.getRequestDispatcher("/MyToDoListPage.jsp").forward(request, response);
			}
		}
		else if(request.getParameter("page").equals("2")==true) //update 
		{
			Todolist _updatelist= new Todolist();
			Date compDate=null, dueDate=null;
			
			try {
				dueDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("duedate"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				compDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("completedate"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int _listid = Integer.parseInt(request.getParameter("listid"));
			int _responsible = Integer.parseInt(request.getParameter("responsible"));
			int _status = Integer.parseInt(request.getParameter("status"));
			
			_updatelist.setListid(Integer.parseInt(request.getParameter("listid")));
			_updatelist.setCompletedate(compDate);
			_updatelist.setDuedate(dueDate);
			_updatelist.setDoerid(Integer.parseInt(request.getParameter("responsible")));
			_updatelist.setStatusid(Integer.parseInt(request.getParameter("status")));
			_updatelist.setItemdescription(request.getParameter("descrip"));
						
			ToDoListDB.update(_updatelist);

//			count=listFromDb.updateToDoList(_listid, _responsible, request.getParameter("descrip"), _status);
//			if(count==1)
//			{
				message+="<td>"+_listid+"</td>";
				message+="<td>"+request.getParameter("descrip")+"</td>";
				message+="<td>"+dueDate+"</td>";
				message+="<td>"+_responsible+"</td>";
				message+="<td>"+_status+"</td>";

				request.setAttribute("message", message);
				request.getRequestDispatcher("/UpdatedList.jsp").forward(request, response);
//			}
		}
		else if(request.getParameter("page").equals("3")==true) //add 
		{
			Todolist _list= new Todolist();
			Date compDate=null, dueDate=null;
			
			try {
				dueDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("duedate"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				compDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("completedate"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			_list.setListid(Integer.parseInt(request.getParameter("listid")));
			_list.setCompletedate(compDate);
			_list.setDuedate(dueDate);
			_list.setDoerid(Integer.parseInt(request.getParameter("responsible")));
			_list.setStatusid(Integer.parseInt(request.getParameter("status")));
			_list.setItemdescription(request.getParameter("descrip"));
						
			ToDoListDB.insert(_list);
			
			toDoLisCount = addedList.findAnyToDoList();
			if(toDoLisCount > 0)
			{
				myToDoList = addedList.findAllTodolist().getResultList();

				//System.out.println("We have something in the assignmentList");
				request.setAttribute("myToDoList", myToDoList);
				request.getRequestDispatcher("/MyToDoListPage.jsp").forward(request, response);
			}
		}
		else if(request.getParameter("page").equals("4")==true) //report 
		{
			toDoLisCount = completedList.findAnyCompletedList();
			if(toDoLisCount > 0)
			{
				myToDoList = completedList.findAllCompletedLis().getResultList();

				//System.out.println("We have something in the assignmentList");
				request.setAttribute("myToDoList", myToDoList);
				request.getRequestDispatcher("/CompletedList.jsp").forward(request, response);
			}
		}

	}
}
