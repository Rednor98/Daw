package cat.institutmarianao.state.management.servlet;
 
import java.io.IOException;
 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
@WebServlet({ "/retrieve_session" })
public class RetrieveSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getFieldAndShow(request, response);
	}
 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getFieldAndShow(request, response);
	}
 
	private void getFieldAndShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// Do nothing, cause session is accessible in the JSP page
		request.getRequestDispatcher("/show_field.jsp").forward(request, response);
	}
}