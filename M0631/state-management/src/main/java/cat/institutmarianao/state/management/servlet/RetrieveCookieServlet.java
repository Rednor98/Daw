package cat.institutmarianao.state.management.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/retrieve_cookie" })
public class RetrieveCookieServlet extends HttpServlet {
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
		request.setAttribute("field", getCookieValue(request, "field"));
		request.getRequestDispatcher("/show_field.jsp").forward(request, response);
	}

	private String getCookieValue(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (var cookie : request.getCookies()) {
				if (cookieName.equals(cookie.getName())) {
					return URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8);
				}
			}
		}
		return null;
	}
}