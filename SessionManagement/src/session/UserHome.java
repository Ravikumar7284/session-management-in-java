package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserHome")
public class UserHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserHome() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "destroy":
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+"/UserLogin?action=login");
			break;
		case "userHome":
			request.getRequestDispatcher("userHome.jsp").forward(request, response);
			break;
		case "restrictedUser":
			request.getRequestDispatcher("restrictedUser.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}

}
