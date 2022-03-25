package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		// login as key value
		case "login":
			request.getRequestDispatcher("userLogin.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "loginsubmit":
			doAuthenticate(request,response);
			break;

		default:
			break;
		}
	}

	public void doAuthenticate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");

		if (userName.equals("admin") && passWord.equals("1234")) {
			// invalidate session if any present
			request.getSession().invalidate();
			// to create new session
			HttpSession session = request.getSession(true);
			// session timeout
			session.setMaxInactiveInterval(300);
			session.setAttribute("username", userName);
			// when cookies are disabled
			String encode = response.encodeURL(request.getContextPath());
			response.sendRedirect(encode + "/UserHome?action=userHome");

		} else {
			response.sendRedirect(request.getContextPath()+"/UserLogin?action=login");
		}
	}

}
