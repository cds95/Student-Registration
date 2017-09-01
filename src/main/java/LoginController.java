


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseFiles.DatabaseManager;
import StudentFiles.PrivateInformation;
import StudentFiles.Student;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseManager manager = new DatabaseManager();
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		PrivateInformation credentials = manager.getCredentials(username);
		if(credentials.getPassword().equals(password) ) {
			Student student = manager.getStudent(credentials.getSid());
			request.getSession().setAttribute("manager", manager);
			request.getSession().setAttribute("student", student);
			response.sendRedirect("Success.jsp");
		}
	}

}
