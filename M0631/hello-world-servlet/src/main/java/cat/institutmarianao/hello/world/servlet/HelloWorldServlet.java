package cat.institutmarianao.hello.world.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet(name = "HelloWorld", urlPatterns = { "/hello-world" })
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// Method doGet is executed every time the servlet receives a GET request
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Set the content type of the response to HTML with UTF-8 encoding
		response.setContentType("text/html;charset=UTF-8");
		// Get the PrintWriter to write the response
		// The response is sent back to the client (browser)
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet HelloWorld</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("	<header>");
			out.println("		<h1>Servlet " + request.getServletPath() + " at " + request.getContextPath() + "</h1>");
			out.println("		<p>An app by Institut Marianao</p>");
			out.println("	</header>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
