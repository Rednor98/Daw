package cat.institutmarianao.post.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import cat.institutmarianao.post.servlet.ejb.PostBeanLocal;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

/**
 * Servlet implementation class PostServlet. This servlet handles POST requests
 * for submitting user input data such as email, age, and message. It validates
 * the input data using Bean Validation and forwards the request to the
 * appropriate JSP page based on whether there are validation errors or not.
 */
@WebServlet("/post")
public class PostServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Inject the Validator to perform Bean Validation on the PostBean. DO NOT
	// INSTANTIATE IT DIRECTLY; LET THE CONTAINER MANAGE IT.
	@Resource
	private Validator validator;

	private PostBeanLocal postBean;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Look up the PostBean EJB using JNDI
			postBean = (PostBeanLocal) new InitialContext().lookup("java:global/post-servlet-ejb/PostBean");
			RequestDispatcher dispatcher = request.getRequestDispatcher("send_post.jsp");
			request.setAttribute("postBean", postBean);
			dispatcher.forward(request, response);
		} catch (NamingException e) {
			Logger.getLogger(PostServlet.class.getName()).log(java.util.logging.Level.SEVERE,
					"Error looking up PostBean", e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// Set the character encoding to UTF-8 to handle special characters in the
		// request parameters
		request.setCharacterEncoding("UTF-8");

		// List to hold validation errors
		List<ConstraintViolation<PostBeanLocal>> errors = new ArrayList<>();

		// Retrieve parameters from the request
		String mail = request.getParameter("email");
		String age = request.getParameter("age");
		String message = request.getParameter("message");

		// Set the values in the PostBean
		postBean.setMessage(message);
		postBean.setEmail(mail);
		postBean.setAge(age);

		// Validate the PostBean and collect any validation errors
		errors.addAll(validator.validate(postBean));

		// Determine the appropriate JSP page to forward to based on validation results
		RequestDispatcher dispatcher;
		if (errors.isEmpty()) {
			dispatcher = request.getRequestDispatcher("post_success.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("send_post.jsp");
			request.setAttribute("errors", errors);
		}

		// Set the PostBean as a request attribute for use in the JSP
		request.setAttribute("postBean", postBean);

		// Forward the request and response to the selected JSP page
		dispatcher.forward(request, response);
	}
}
