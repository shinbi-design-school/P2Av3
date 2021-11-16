package quizSystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quizSystem.dao.RegistrationOfResultsDAO;

/**
 * Servlet implementation class RegistrationOfResults
 */
@WebServlet("/RegistrationOfResultsServlet")
public class RegistrationOfResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationOfResultsServlet() {
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
		//文字コードなどの設定
		response.setContentType("text/html; charaset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		//ブラウザからのデータ取得
		String useridString = request.getParameter("id");
		int userid = Integer.parseInt(useridString);
		String accountName = request.getParameter("accountName");
		String correctNumber = request.getParameter("correctCount");
		String answerTime = request.getParameter("answerTime");
		String timestamp = request.getParameter("timestamp");
		String quizName = request.getParameter("quizName");
		
System.out.println("ブラウザの情報が取得できているか");
System.out.println(userid);
System.out.println(accountName);
System.out.println(correctNumber);
System.out.println(answerTime);
System.out.println(timestamp);
System.out.println(quizName);


		//DAO
		RegistrationOfResultsDAO add = new RegistrationOfResultsDAO();
		add.resultAdd(userid,correctNumber,answerTime,timestamp,quizName);
		
		/*
		//情報の格納
		List<Integer> correctNumberList = add.selectCorrect(userid);
		List<Integer> answerTimeList = add.selectTime(userid);
		
		//ブラウザに情報を送信する準備
		HttpSession session = request.getSession();//
		session.setAttribute("id",userid);
		session.setAttribute("accountName",accountName);
		session.setAttribute("correctNumberList",correctNumberList);
		session.setAttribute("answerTimeList",answerTimeList);
		
		if(accountName == "ゲスト") {
			RequestDispatcher rd = request.getRequestDispatcher("Top.jsp");//
			rd.forward(request,response);
		}
		else {
		RequestDispatcher rd = request.getRequestDispatcher("UserStatus.jsp");//
		rd.forward(request,response);
		}
		*/
		RequestDispatcher rd = request.getRequestDispatcher("UserStatus.jsp");//
		rd.forward(request,response);
		
		
	}

}
