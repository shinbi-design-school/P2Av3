package quizSystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quizSystem.dao.InqueryFormDAO;
import quizSystem.dto.InqueryFormDTO;

/**
 * Servlet implementation class InqueryFormServlet
 */
@WebServlet("/InqueryFormServlet")
public class InqueryFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InqueryFormServlet() {
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
		
		//ブラウザから値が取れているか確認
		String inputAccountname = request.getParameter("accountname");
		String inputEmail = request.getParameter("email");
		String inputInquery = request.getParameter("inquery");
		
System.out.println("ブラウザ入力の確認");
System.out.println(inputAccountname);
System.out.println(inputEmail);
System.out.println(inputInquery);

		InqueryFormDAO dao = new InqueryFormDAO();
		List<String> accountnames = dao.userAccountSearch(inputAccountname);
System.out.println("accountnamesの情報があるか");
System.out.println(accountnames);

		if(accountnames.contains(inputAccountname)) {
		
			int userid = dao.useridSearch(inputAccountname);
			InqueryFormDTO dto = dao.queryPut(userid,inputAccountname,inputEmail,inputInquery);
			
			HttpSession session = request.getSession();//
			session.setAttribute("dto",dto);//
			
			String jsp = "InqueryFromComplete.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(jsp);//
			rd.forward(request,response);
			
		}else {
			String errorMessage = "入力されたアカウント名が登録されておりません。アカウント名をもう一度お確かめ頂き入力ください。";
			String jsp="error.jsp";
			HttpSession session = request.getSession();//
			session.setAttribute("errorMessage",errorMessage);//
			
			RequestDispatcher rd = request.getRequestDispatcher(jsp);//
			rd.forward(request,response);
			
		}

	}

}
