package cat.institutmarianao.salary.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
/**
 * Servlet that handles salary calculations. It receives the gross salary and
 * number of children from the request, calculates the withholding and net
 * salary, and forwards the results to a JSP page for display.
 */
@WebServlet("/salary")
public class SalaryServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
 
	private static final double MIN_GROSS_SALARY = 1424.50; // Minimum gross salary in Spain for 2026
	private static final int MIN_CHILDREN = 0; // Minimum number of children
	private static final double MIN_WITHHOLDING = 0; // Minimum withholding percentage
 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
 
		// Get the gross salary and number of children from the request parameters
		double grossSalary = Math.max(MIN_GROSS_SALARY, Integer.parseInt(request.getParameter("grossSalary")));
		int children = Math.max(MIN_CHILDREN, Integer.parseInt(request.getParameter("children")));
 
		// Simulated withholding calculation based on the number of children
		double withholding = Math.max(MIN_WITHHOLDING, (21 - 5 * children) / 100.0);
 
		// You can improve this calculation by using a more accurate formula based on
		// the Spanish tax system and the number of children.
		double netSalary = grossSalary * (1 - withholding);
 
		// Set the calculated values as request attributes to be used in the JSP
		request.setAttribute("grossSalary", grossSalary);
		request.setAttribute("children", children);
		request.setAttribute("withholding", withholding);
		request.setAttribute("netSalary", netSalary);
 
		// Forward the request to the JSP page for displaying the results
		request.getRequestDispatcher("net_salary.jsp").forward(request, response);
	}
}