package cat.institutmarianao.promo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PromoServlet
 */
public class PromoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private int visitsCounter;

	private int initCouter = 0;
	private String promoUrl;
	private Set<String> ip;

	/**
	 * @see HttpServlet#init()
	 */
	// Method init is executed only once when the servlet is first loaded into
	// memory
	@Override
	public void init() throws ServletException {
		ip = new HashSet<>();
		initCouter++;
		visitsCounter = 0;
		promoUrl = getServletConfig().getInitParameter("url");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// Method service is executed every time the servlet receives a request (GET,
	// POST, etc.)
	// IMPORTANT: We should not use the service method to handle requests, we should
	// use doGet or doPost methods instead
	// However, in this case we are using the service method to educative purposes
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String requestIp = request.getRemoteAddr();
		String outMessage = ip.add(requestIp) ? getFirstTimeMessage() : getNotFirstTimeMessage();

		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Promo Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("	<header>");
			out.println("		<h1>Promo Servlet</h1>");
			out.println("		<p>An app by Institut Marianao</p>");
			out.println("	</header>");
			out.println(outMessage);
			out.println("	<h5>This page has " + ++visitsCounter + " visits up to now</h5>");
			out.println("	<h5>The init method has been called " + initCouter + " times</h5>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	private String getFirstTimeMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("	<h3>Thats is your first access to this page. Welcome!</h3>");
		sb.append("	<p style=\"color:red;\">Access to promo clicking this link: </p>");
		sb.append("	<a href=\"").append(promoUrl).append("\">Promo web</a>");
		return sb.toString();
	}

	private String getNotFirstTimeMessage() {
		return "	<h3>Thanks for comming to this page. You will see the promo no more</h3>";
	}
}