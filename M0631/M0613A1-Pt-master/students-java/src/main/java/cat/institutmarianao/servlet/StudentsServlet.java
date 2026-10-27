package cat.institutmarianao.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import cat.institutmarianao.dao.CycleDao;
import cat.institutmarianao.dao.StudentDao;
import cat.institutmarianao.model.Cycle;
import cat.institutmarianao.model.Student;

//TODO Implement the servlet to handle student listing

@WebServlet("/students")
public class StudentsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@EJB
	private CycleDao cycleDao;
	@EJB
	private StudentDao studentDao;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Cycle> cycles = cycleDao.findAll();
			List<Student> students = studentDao.findAll();

			RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
			request.setAttribute("cycles", cycles);
			request.setAttribute("students", students);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
//		try {
//			procesarDatos(request, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}
