package cat.institutmarianao.guess.color2.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import jakarta.servlet.RequestDispatcher;
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
@WebServlet(urlPatterns = { "/guess-color2" }, initParams = { @WebInitParam(name = "color", value = "red") })
public class GuessColor2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String initColor;

	private static final String WIN_HTML = "win.html";
	private static final String LOOSE_HTML = "loose.html";

	private Set<String> ip;

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
		ip = new HashSet<>();
		// Get the initial color from the servlet configuration
		initColor = config.getInitParameter("color");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Comment one of the following lines, but not both, to test redirect and
		// forward
		redirect(request, response);
		// forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String paramColor = request.getParameter("color");
		
		if (initColor.equalsIgnoreCase(paramColor)) {
			response.sendRedirect(WIN_HTML);

		} else {
			response.sendRedirect(LOOSE_HTML);
		}
	}

	private void forward(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rs;
		String requestIp = request.getRemoteAddr();

		if (ip.add(requestIp)) {
			rs = request.getRequestDispatcher(WIN_HTML);
		} else {
			rs = request.getRequestDispatcher(LOOSE_HTML);
		}
		rs.forward(request, response);
	}

}
