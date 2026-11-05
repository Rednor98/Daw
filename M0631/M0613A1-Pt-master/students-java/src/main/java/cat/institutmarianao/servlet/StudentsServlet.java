package cat.institutmarianao.servlet;

import java.io.IOException;

import cat.institutmarianao.service.CycleService;
import cat.institutmarianao.service.StudentService;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO Implement the servlet to handle student listing

@WebServlet(urlPatterns = { "/students" })
public class StudentsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@EJB
	private CycleService cycleService;
	@EJB
	private StudentService studentService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
			request.setAttribute("cycles", cycleService.findAll());
			request.setAttribute("students", studentService.findAll());
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
