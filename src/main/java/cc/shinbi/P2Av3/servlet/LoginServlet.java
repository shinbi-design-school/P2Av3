package cc.shinbi.P2Av3.servlet;


import java.sql.Connection;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.shinbi.P2Av3.model.dao.MessageDao;
import cc.shinbi.P2Av3.model.dao.UserDao;
import cc.shinbi.P2Av3.model.Pair;
import cc.shinbi.P2Av3.model.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends JspServlet {
	private static final long serialVersionUID = 1L;

	/**
	* @see HttpServlet#HttpServlet()
	*/
	public LoginServlet() {
		super(true);
}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected String view(HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception {

		String jsp = null;
		String error = "";
		User user = null;

		UserDao dao = new UserDao(connection);
		MessageDao messagedao = new MessageDao(connection);

		String account = request.getParameter("account");
		if(account == null || account.isEmpty()) {
			error = error + "アカウント名を入力してください。";
		}
		String password = request.getParameter("password");
		if(password == null || password.isEmpty()) {
			error = error + "パスワードを入力してください。";
		}
		if(error.isEmpty()) {

		}
		if(user == null) {
			if(error.isEmpty()) {
				error = "ユーザー名もしくはパスワードが違います。";
			}
			request.setAttribute("error", error);
			jsp = "/WEB-INF/jsp/login.jsp";
		}
		else {
			HttpSession session = request.getSession();
			request.setAttribute("user", user);

			List<Pair> pairs = messagedao.findVisible(user.getId());
			request.setAttribute("pairs", pairs);

			jsp = "/WEB-INF/jsp/top.jsp";
		}
		return jsp;
	}
}
