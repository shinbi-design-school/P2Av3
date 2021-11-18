package quizSystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quizSystem.dao.InqueryFormDAO;

/**
 * Servlet implementation class InqueryFormReplyServlet
 */
@WebServlet("/InqueryFormReplyServlet")
public class InqueryFormReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InqueryFormReplyServlet() {
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
		
		String queryIdString = request.getParameter("queryId");
		int queryId = Integer.parseInt(queryIdString); 
		String userid = request.getParameter("userid");
		String accountname = request.getParameter("accountname");
		String mailaddress = request.getParameter("email");
		String reply = request.getParameter("reply");
		
		InqueryFormDAO dao = new InqueryFormDAO();
		dao.queryReply(reply,queryId);
		
		RequestDispatcher rd = request.getRequestDispatcher("inqueryFormAllShow.jsp");//
		rd.forward(request,response);
	}

}
