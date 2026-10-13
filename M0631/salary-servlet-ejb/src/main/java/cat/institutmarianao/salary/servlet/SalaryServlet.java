package cat.institutmarianao.salary.servlet;

import static cat.institutmarianao.salary.servlet.ejb.SalaryCalculationBeanLocal.MIN_CHILDREN;
import static cat.institutmarianao.salary.servlet.ejb.SalaryCalculationBeanLocal.MIN_GROSS_SALARY;

import java.io.IOException;

import cat.institutmarianao.salary.servlet.ejb.SalaryCalculationBeanLocal;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet that handles salary calculations. It receives the gross salary and
 * number of children from the request, calculates the withholding and net
 * salary using the SalaryCalculationBean EJB, and forwards the results to a JSP
 * page for display.
 */
@WebServlet("/salary")
public class SalaryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Inject the EJB for salary calculation. DO NOT INSTANTIATE IT DIRECTLY; LET
	// THE CONTAINER MANAGE IT.
	@EJB
	private SalaryCalculationBeanLocal salaryCalculationBean;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// Get the gross salary and number of children from the request parameters
		double grossSalary = Math.max(MIN_GROSS_SALARY, Integer.parseInt(request.getParameter("grossSalary")));
		int children = Math.max(MIN_CHILDREN, Integer.parseInt(request.getParameter("children")));

		// Calculate the withholding and net salary using the EJB
		double withholding = salaryCalculationBean.calculateWithholding(children);
		double netSalary = salaryCalculationBean.calculateNetSalary(grossSalary, children);

		// Set the calculated values as request attributes to be used in the JSP
		request.setAttribute("grossSalary", grossSalary);
		request.setAttribute("children", children);
		request.setAttribute("withholding", withholding);
		request.setAttribute("netSalary", netSalary);

		// Forward the request to the JSP page for displaying the results
		request.getRequestDispatcher("net_salary.jsp").forward(request, response);
	}
}