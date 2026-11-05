package cat.institutmarianao.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cat.institutmarianao.model.Module;
import cat.institutmarianao.model.Student;
import cat.institutmarianao.service.ModuleService;
import cat.institutmarianao.service.StudentService;
import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

//TODO Implement the servlet to handle student registration, including form validation
@WebServlet(urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {

	@Resource
	private Validator validator;
	@EJB
	private ModuleService moduleService;
	@EJB
	private StudentService studentService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Student student = new Student();
			request.getSession().setAttribute("student", student);
			request.setAttribute("modules", moduleService.findAllByCycleCode(request.getParameter("cycle")));
			request.setAttribute("cycle", request.getParameter("cycle"));
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} catch (Exception e) {
			throw new IllegalArgumentException("Error al procesar la solicitud GET para el registro", e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			List<ConstraintViolation<Student>> errors = new ArrayList<>();
			Student student = (Student) request.getSession().getAttribute("student");

			String dni = request.getParameter("dni");
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String email = request.getParameter("email");

			List<String> modulesCodes = new ArrayList<String>();
			for (String mCode : request.getParameterValues("moduleCode")) {
				modulesCodes.add(mCode);
			}
			List<Module> lsModules = new ArrayList<Module>();

			for (String mo : modulesCodes) {
				Module newModule = moduleService.findByPk(mo, request.getParameter("cycle"));

				lsModules.add(newModule);
			}

			student.setDni(dni);
			student.setName(name);
			student.setSurname(surname);
			student.setEmail(email);
			student.setModules(lsModules);


			errors.addAll(validator.validate(student));

			RequestDispatcher dispatcher = null;
			if (errors.isEmpty()) {
				dispatcher = request.getRequestDispatcher("students.jsp");
			} else {
				dispatcher = request.getRequestDispatcher("register.jsp");
				request.setAttribute("errors", errors);
			}
			studentService.add(student);
			request.setAttribute("student", student);
			request.getSession().removeAttribute("student");
			

			dispatcher.forward(request, response);
		} catch (Exception e) {
			throw new IllegalArgumentException("Error al procesar los datos del formulario de registro", e);
		}

	}


}
