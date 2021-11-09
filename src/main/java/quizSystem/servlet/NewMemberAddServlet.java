package quizSystem.servlet;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quizSystem.dao.LoginDAO;
import quizSystem.dao.NewMemberAddDAO;
import quizSystem.dto.LoginDTO;
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
		//既存のアカウントやパスワードがあるか確認（LoginServletより抜粋）
		LoginDAO dao = new LoginDAO();
		List<LoginDTO> userList = dao.userDAO();
		LoginDTO dto;
		
		//sqlからデータを持ってきてリスト化するためのリスト
		List<List<Object>> userObjectList = new ArrayList<>();
		List<Integer> idList = new ArrayList<>();
		List<String> accountList = new ArrayList<>();
		List<String> passwordList = new ArrayList<>();
		List<Time> answerTimeList = new ArrayList<>();
		List<Integer> correctNumber = new ArrayList<>();
		
		//次の画面を出力するためにURLを格納する変数
		String jsp = null;
		
		//結果を格納するリスト
		List<String> result = new ArrayList<>();
		
		
		//sqlから持ってきたデータをリストへ格納
		for(int i=0; i<userList.size();i++) {
			dto = (LoginDTO)userList.get(i);
			idList.add(dto.getId());
			accountList.add(dto.getAccountname());
			passwordList.add(dto.getPassword());
			answerTimeList.add(dto.getAnswerTime());
			correctNumber.add(dto.getCorrectNumber());
			
			List<Object> tempList = new ArrayList<>();
			tempList.add(dto.getId());
			tempList.add(dto.getAccountname());
			tempList.add(dto.getPassword());
			//ソートするメソッド入れないとだめでは、、、、
			tempList.add(dto.getAnswerTime());
			//同上
			tempList.add(dto.getCorrectNumber());
			
			userObjectList.add(tempList);
		System.out.println("tempListが存在するか");
		System.out.println(tempList);
			
		}
		System.out.println("sqlからとってきたaccountList,passwordListがそろっているか");
		System.out.println(idList);
		System.out.println(accountList);
		System.out.println(passwordList);
		System.out.println(answerTimeList);
		System.out.println(correctNumber);
		
		//同じアカウント名やパスワードがないか確認
		if(accountList.contains(accountname)) {
			String errorMessage ="同じアカウント名が既に登録されています。お手数ですが別のアカウント名を登録してください。";
			jsp="error.jsp";
			HttpSession session = request.getSession();//
			session.setAttribute("errorMessage",errorMessage);//
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");//
			rd.forward(request,response);
		}else if(passwordList.contains(password)) {
			String errorMessage ="同じパスワードが既に登録されています。お手数ですが別のパスワードを登録してください。";
			jsp="error.jsp";
			HttpSession session = request.getSession();//
			session.setAttribute("errorMessage",errorMessage);//
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");//
			rd.forward(request,response);
		}
		else {//同じアカウント名やパスワードがなければ登録
			NewMemberAddDAO userAddDAO = new NewMemberAddDAO();//DBアクセスのオブジェクトをインスタンス
			NewMemberAddDTO addUser = userAddDAO.addUserInfromationToDatabase(accountname,password);//
	System.out.println("コンソール表示：新規ユーザー情報が変数に格納できているか確認");
	System.out.println(addUser);
	System.out.println(addUser.getId());
	System.out.println(addUser.getAccountname());
	System.out.println(addUser.getPassword());
	System.out.println(addUser.getPasswordBytes());
	
			HttpSession session = request.getSession();//
			session.setAttribute("addUser",addUser);//
			
			RequestDispatcher rd = request.getRequestDispatcher("NewMemberAddCompleted.jsp");//
			rd.forward(request,response);
		
		}

		
	}

}
