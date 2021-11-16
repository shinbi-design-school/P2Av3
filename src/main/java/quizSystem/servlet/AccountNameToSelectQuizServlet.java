package quizSystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccountNameToSelectQuizServlet
 */
@WebServlet("/AccountNameToSelectQuizServlet")
public class AccountNameToSelectQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountNameToSelectQuizServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charaset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		
		String accountName = request.getParameter("accountName");
		String id = request.getParameter("id");
		
		//ブラウザに情報を送信する準備
		HttpSession session = request.getSession();//
		session.setAttribute("accountName",accountName);//
		session.setAttribute("id", id);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("SelectQuiz.jsp");//
		rd.forward(request,response);
		
		
		
		
		
	}

}
