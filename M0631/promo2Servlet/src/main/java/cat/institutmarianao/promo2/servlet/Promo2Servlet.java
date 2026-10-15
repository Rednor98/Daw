package cat.institutmarianao.promo2.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Promo2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String FIRST_TIME_HTML = "first_time.html";
	private static final String NOT_FIRST_TIME_HTML = "not_first_time.html";

	private Set<String> ip;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	public void init() throws ServletException {
		ip = new HashSet<>();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Comment one of the following lines, but not both, to test redirect and
		// forward
		redirect(request, response);
		// forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestIp = request.getRemoteAddr();

		if (ip.add(requestIp)) {
			response.sendRedirect(FIRST_TIME_HTML);

		} else {
			response.sendRedirect(NOT_FIRST_TIME_HTML);
		}
	}

	private void forward(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rs;
		String requestIp = request.getRemoteAddr();

		if (ip.add(requestIp)) {
			rs = request.getRequestDispatcher(FIRST_TIME_HTML);
		} else {
			rs = request.getRequestDispatcher(NOT_FIRST_TIME_HTML);
		}
		rs.forward(request, response);
	}
}