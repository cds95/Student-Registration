
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseFiles.DatabaseManager;
import StudentFiles.Course;
import StudentFiles.Student;

/**
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid = Integer.parseInt((String) request.getParameter("cid"));
		String action = request.getParameter("choice");
		Student student = (Student) request.getSession().getAttribute("student");
		DatabaseManager manager = (DatabaseManager) request.getSession().getAttribute("manager");
		Course course = manager.getCourse(cid);
		RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
		if(action.equals("Register")) {
			boolean registered = manager.registerUser(student, course);	
			if(!registered) {  
				PrintWriter out = response.getWriter();
				out.write("Sorry, there was a problem with your registration");
				rd.include(request, response);
			}
		} else {
			manager.removeClass(student, course);
		}
		rd.forward(request, response);
		
	}

}
