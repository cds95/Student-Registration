
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseFiles.DatabaseManager;
import StudentFiles.Department;

/**
 * Servlet implementation class BrowseCourseController
 */
public class BrowseCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String departmentName = request.getParameter("department");
		DatabaseManager manager = (DatabaseManager) request.getSession().getAttribute("manager");
		Department department = manager.getDepartment(departmentName);
		request.getSession().setAttribute("department", department);
		response.sendRedirect("courses.jsp");
	}

}
