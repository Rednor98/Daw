package cat.institutmarianao.servlet;

import java.io.IOException;

import cat.institutmarianao.service.StudentService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO Implement the servlet to handle student removal
@WebServlet(urlPatterns = { "/remove" })
public class RemoveServlet extends HttpServlet {

	@EJB
	private StudentService studentService;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dni = request.getParameter("dni");
		try {
			studentService.removeByDni(dni);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/students");

	}
}
