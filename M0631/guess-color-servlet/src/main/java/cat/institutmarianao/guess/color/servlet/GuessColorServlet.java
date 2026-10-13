package cat.institutmarianao.guess.color.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuessColorServlet
 */
@WebServlet(urlPatterns = { "/guess-color" }, initParams = { @WebInitParam(name = "color", value = "green") })
public class GuessColorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String initColor;

	/**
	 * @see HttpServlet#init(ServletConfig)
	 */
	// Method init is executed once when the servlet is first loaded into memory.
	// It is used to perform any initialization tasks that the servlet needs before
	// it can handle requests.
	@Override
	public void init(ServletConfig config) throws ServletException {
		// Call the superclass's init method to ensure proper initialization
		super.init(config);
		// Get the initial color from the servlet configuration
		initColor = config.getInitParameter("color");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
			String result;

			// Get the color parameter from the request
			String paramColor = request.getParameter("color");

			if (initColor.equalsIgnoreCase(paramColor)) {
				result = "Congratulations! You guess the color";
			} else {
				result = "Sorry, you lost!";
			}

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("	<title>Guess color</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("	<header>");
			out.println("		<h1>Guess Color</h1>");
			out.println("		<p>An app by Institut Marianao</p>");
			out.println("	</header>");
			out.println("	<h3>" + result + "</h3>");
			out.println("	<a href=\"guess-color.html\">Try again</a>");
			out.println("</body>");
			out.println("</html>");
		}
	}

}
