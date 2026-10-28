package cat.institutmarianao.servlet;

import java.io.IOException;


import cat.institutmarianao.dao.ModuleDao;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO Implement the servlet to handle student registration, including form validation
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@EJB
	private ModuleDao moduleDao;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Esta funcion se encarga de recibir los datos del formulario de registro y
			// enviarlos a la página register.jsp para su validación y posterior registro
			// del estudiante.
//			request.setCharacterEncoding("UTF-8");
//			String cycle = request.getParameter("cycle");
//
//			request.setAttribute("cycle", cycle);
//			request.getRequestDispatcher("register.jsp").forward(request, response);
		} catch (Exception e) {
			throw new IllegalArgumentException("Error al procesar los datos del formulario de registro", e);
		}

	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("modules", moduleDao.findAllByCycleCode(request.getParameter("cycle")));
			request.setAttribute("cycle",request.getParameter("cycle"));
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} catch (Exception e) {
			throw new IllegalArgumentException("Error al procesar la solicitud GET para el registro", e);
		}
	}

}
