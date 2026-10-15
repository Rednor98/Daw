package cat.institutmarianao.auth.servlet;

import java.io.IOException;

import cat.institutmarianao.auth.ejb.LibraryBeanLocal;
import jakarta.ejb.EJB;
import jakarta.ejb.EJBAccessException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/library" })
public class LibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private LibraryBeanLocal library;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		library(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		library(request, response);
	}

	private void library(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		if (request.isUserInRole("librarian")) {
			request.setAttribute("catalog", library.catalog("java"));
			request.setAttribute("book", "php");
			request.setAttribute("availability", library.checkAvailability("php"));
		}
		if (request.isUserInRole("user")) {
			request.setAttribute("book", "java");
			request.setAttribute("availability", library.checkAvailability("java"));
		}
		try {
			if (library.borrow("java")) {
				// Book borrowed successfully
				request.setAttribute("error", "Java book borrowed successfully");
			}
		} catch (EJBAccessException e) {
			request.setAttribute("error", "You do not have permission to borrow books");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("library.jsp");
		dispatcher.forward(request, response);
	}
}