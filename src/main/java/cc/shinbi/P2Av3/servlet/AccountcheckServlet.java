package cc.shinbi.P2Av3.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.shinbi.P2Av3.model.AccountBeans;

/**
 * Servlet implementation class AccountcheckServlet
 */
@WebServlet("/Accountcheck")
public class AccountcheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	* @see HttpServlet#HttpServlet()
	 */
	public AccountcheckServlet() {
		super();
	// TODO Auto-generated constructor stub
}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// セッションからログイン情報を取得
	HttpSession session = request.getSession();
	AccountBeans ab = (AccountBeans) session.getAttribute("account");

		// ロールでフォワード先を振り分ける
	if(ab.getRole() == 1) {
	RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
	rd.forward(request, response);
}
	else if(ab.getRole() == 2) {
		RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
	rd.forward(request, response);
	}
	else {
		RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
		rd.forward(request, response);
	}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
