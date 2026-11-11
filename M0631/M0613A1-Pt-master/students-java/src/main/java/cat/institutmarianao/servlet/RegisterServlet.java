package cat.institutmarianao.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
			request.setAttribute("modules", moduleService.findAllByCycleCode(request.getParameter("cycle")));
			request.setAttribute("cycle", request.getParameter("cycle"));
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Error al procesar la solicitud GET para el registro", e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String cycleCode = request.getParameter("cycle");

			Student student = new Student();
			student.setDni(request.getParameter("dni"));
			student.setName(request.getParameter("name"));
			student.setSurname(request.getParameter("surname"));
			student.setEmail(request.getParameter("email"));

			List<Module> modules = new ArrayList<>();
			String[] moduleCodes = request.getParameterValues("moduleCode");
			if (moduleCodes != null) {
				for (String code : moduleCodes) {
					modules.add(moduleService.findByPk(code, cycleCode));
				}
			}
			student.setModules(modules);

			Set<ConstraintViolation<Student>> errors = validator.validate(student);

			if (errors.isEmpty()) {
				studentService.add(student);
				response.sendRedirect(request.getContextPath() + "/students");
			} else {
				request.setAttribute("errors", errors);
				request.setAttribute("student", student);
				request.setAttribute("cycle", cycleCode);
				request.setAttribute("modules", moduleService.findAllByCycleCode(cycleCode));
				request.getRequestDispatcher("register.jsp").forward(request, response);

			}

		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Error al procesar los datos del formulario de registro", e);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
