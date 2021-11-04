package quizSystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quizSystem.dao.NewMemberAddDAO;
import quizSystem.dto.NewMemberAddDTO;

/**
 * Servlet implementation class NewMemberRegisterServlet
 */
@WebServlet("/NewMemberRegisterServlet")
public class NewMemberAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewMemberAddServlet() {
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
		
		String accountname = request.getParameter("accountname");
		String password = request.getParameter("password");
System.out.println("ブラウザから送られた情報が取得できているか確認");
System.out.println(accountname);
System.out.println(password);
		
//DAO,DTOのインスタンス
		NewMemberAddDAO userAddDAO = new NewMemberAddDAO();//DBアクセスのオブジェクトをインスタンス
		NewMemberAddDTO addUser = userAddDAO.addUserInfromationToDatabase(accountname,password);//
System.out.println("コンソール表示：新規ユーザー情報が変数に格納できているか確認");
System.out.println(addUser);
System.out.println(addUser.getId());
System.out.println(addUser.getAccountname());
System.out.println(addUser.getPassword());

		HttpSession session = request.getSession();//
		session.setAttribute("addUser",addUser);//
		
		RequestDispatcher rd = request.getRequestDispatcher("NewMemberAddCompleted.jsp");//
		rd.forward(request,response);

		
	}

}
