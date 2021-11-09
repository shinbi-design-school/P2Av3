package quizSystem.servlet;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quizSystem.dao.LoginDAO;
import quizSystem.dto.LoginDTO;
import quizSystem.dto.MemberDTO;

/**
 * Servlet implementation class LoginServlet_momose
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberDTO member = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
			
			//sqlからデータを持ってきてリスト化するためのリスト
			List<Integer> idList = new ArrayList<>();
			List<String> accountList = new ArrayList<>();
			List<String> passwordList = new ArrayList<>();
			List<byte[]> passwordBytes = new ArrayList<>();
			List<Time> answerTimeList = new ArrayList<>();
			List<Integer> correctNumber = new ArrayList<>();

			
			//sqlのテーブルにあるi番目の行のフィールドの値をリストへ格納
			LoginDAO dao = new LoginDAO();
			List<LoginDTO> userList = dao.userDAO();
			for(int i=0; i<userList.size();i++) {
				LoginDTO dto = (LoginDTO)userList.get(i);//userList.get(i):テーブルのi番目という意味
				idList.add(dto.getId());//i=0のきテーブルの１番目のgetId()
				accountList.add(dto.getAccountname());
				passwordList.add(dto.getPassword());
				passwordBytes.add(dto.getPasswordBytes());
				answerTimeList.add(dto.getAnswerTime());
				correctNumber.add(dto.getCorrectNumber());
			}
System.out.println("sqlからとってきたaccountList,passwordListがそろっているか");
System.out.println(idList);
System.out.println(accountList);
System.out.println(passwordList);
System.out.println(answerTimeList);
System.out.println(correctNumber);

			//ブラウザから入力情報を取得
			String inputAccount = request.getParameter("accountname");
			String inputPassword = request.getParameter("password");
System.out.println("入力されたアカウント、パスワードがブラウザからとれているか");
System.out.println(inputAccount);
System.out.println(inputPassword);


				Map<String,Integer> accountIdMap = new HashMap<>();
				for(int i=0;i<idList.size();i++) {
					accountIdMap.put(accountList.get(i), idList.get(i));
				}
				Map<String,String> accountPasswordMap = new HashMap<>();
				for(int i=0;i<idList.size();i++) {
					accountPasswordMap.put(accountList.get(i), passwordList.get(i));
				}
System.out.println("accountIdMap,accountPasswordMapの情報があるか確認");
System.out.println(accountIdMap);
System.out.println(accountPasswordMap);

				if(accountList.contains(inputAccount)) {
					String loginPassword =accountPasswordMap.get(inputAccount);
System.out.println("パスワード比較");
System.out.println(loginPassword);
System.out.println(inputAccount);
					if(loginPassword.equals(inputPassword)) {
						//String jsp="UserStatus.jsp";
						int loginId = accountIdMap.get(inputAccount);
						var loginIdString = Integer.toString(loginId);
						String[] user = new String[3];
						user[0] = loginIdString;
						user[1] = inputAccount;
						user[2] = inputPassword;
						//member.setId(loginId);
						//member.setAccountname(inputAccount);
						//member.setPassword(inputPassword);
System.out.println("値があるか確認");
System.out.println(loginId);
System.out.println(inputAccount);
System.out.println(inputPassword);
						if(accountIdMap.get(inputAccount) == 1 ) {//管理者のid=1
							String jsp = "AdministratorScreen.jsp";
							HttpSession session = request.getSession();//
							session.setAttribute("user",user);//
							
							RequestDispatcher rd = request.getRequestDispatcher(jsp);//
							rd.forward(request,response);
						}
						else {
							String jsp="UserStatus.jsp";
							HttpSession session = request.getSession();//
							session.setAttribute("user",user);//
							
							RequestDispatcher rd = request.getRequestDispatcher(jsp);//
							rd.forward(request,response);
						}
						
					}
					else {
						String errorMessage = "入力されたパスワードが登録されておりません。パスワードが正しいかもう一度お確かめ頂き入力ください。";
						String jsp="error.jsp";
						HttpSession session = request.getSession();//
						session.setAttribute("errorMessage",errorMessage);//
						
						RequestDispatcher rd = request.getRequestDispatcher(jsp);//
						rd.forward(request,response);
						
					}
				}
				else {
					String errorMessage = "入力されたアカウント名が登録されておりません。アカウント名をもう一度お確かめ頂き入力ください。";
					String jsp="error.jsp";
					HttpSession session = request.getSession();//
					session.setAttribute("errorMessage",errorMessage);//
					
					RequestDispatcher rd = request.getRequestDispatcher(jsp);//
					rd.forward(request,response);
				}
			}
}
