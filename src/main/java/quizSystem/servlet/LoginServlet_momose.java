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

/**
 * Servlet implementation class LoginServlet_momose
 */
@WebServlet("/LoginServlet_momose")
public class LoginServlet_momose extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet_momose() {
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

			//dao,dtoインスタンス
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

System.out.println("userObjectListが存在するか");
System.out.println(userObjectList);
System.out.println(userObjectList.get(0));
System.out.println(userObjectList.get(1));
System.out.println(userObjectList.get(0).get(0));
System.out.println(userObjectList.get(0).get(1));
System.out.println(userObjectList.get(0).get(2));
System.out.println(userObjectList.get(0).get(3));
System.out.println("MapにList型で紐づけして、Listに格納されている特定の値、文字列：momoseを検出できるか試し");
System.out.println(userObjectList.contains("momose"));//false

			Map<Integer,List<Object>> userObjectListMap = new HashMap<>();
			for(int i=0; i<idList.size();i++) {
				userObjectListMap.put(idList.get(i),userObjectList.get(i));
			}
			System.out.println("MapにList型で紐づけして、Listに格納されている特定の値、文字列：momoseを検出できるか試し2");
System.out.println(userObjectListMap.containsValue("momose"));//false

System.out.println("idListとList<Object>（個別のユーザー情報を格納したリスト）をmapで紐づけしたのでidListを検索すれば、そのidの人の個別情報を持つリストをとることができるよね、、、試し");
System.out.println(userObjectListMap.containsKey("1"));//false
System.out.println(userObjectListMap.containsValue("momose"));//false
System.out.println(userObjectListMap.containsKey(1));//true
System.out.println(userObjectListMap.get(0));//0がnull？なぜ？
System.out.println(userObjectListMap.get(1));//結果、ユーザーidがわかればそのユーザーの情報をとれるようにはなった。

			//リスト化したaccountListとpasswordListをmapで紐づけ
			Map<Integer,String> idAccountMap = new HashMap<Integer,String>();
			Map<String, String> accountPasswordMap = new HashMap<String, String>();
			for(int i=0;i<idList.size();i++) {
				idAccountMap.put(idList.get(i),accountList.get(i));
				accountPasswordMap.put(accountList.get(i),passwordList.get(i));
			}
System.out.println("accountPasswordMapの内容確認");
System.out.println(accountPasswordMap);
System.out.println(accountPasswordMap.get(0));//null
System.out.println(accountPasswordMap.get(1));//null

System.out.println("idAccountPasswordMapの内容確認");
System.out.println(idAccountMap);
System.out.println(idAccountMap.get(0));//null
System.out.println(idAccountMap.get(1));



System.out.println("userMap:mapで紐づけしたsqlから抽出したaccountListとpasswordListが紐づいているかどうか");
System.out.println(accountPasswordMap);

			String inputAccount = request.getParameter("account");
			String inputPassword = request.getParameter("password");
			System.out.println("入力されたアカウント、パスワードがブラウザからとれているか");
			System.out.println(inputAccount);
			System.out.println(inputPassword);

System.out.println("userMapにinputAccountの情報があるか確認");
System.out.println(accountPasswordMap.containsKey(inputAccount));
			//DBに入力されたaccount/passwordがあるかどうか確認。
			String passString = null;
			if(accountPasswordMap.containsKey(inputAccount)) {//inputAcocuntがuserMapの中に含まれているならば
				//String pass = userMap.KeySet(inputAccount);
				passString = accountPasswordMap.get(inputAccount);//String型に格納
			}
			else {
					String errorMessage = "入力されたアカウント名が登録されておりません。アカウント名をもう一度お確かめ頂き入力ください。";
					jsp="http://localhost:8080/shinbi_GraduationWork_QuizSystem/loginSystem/error.jsp";
					HttpSession session = request.getSession();//
					session.setAttribute("errorMessage",errorMessage);//

					RequestDispatcher rd = request.getRequestDispatcher("error.jsp");//
					rd.forward(request,response);
			}

System.out.println("passStringに値が格納されているか確認");
System.out.println(passString);
System.out.println("inputPasswordの値が格納されているか確認");
System.out.println(inputPassword);

int passInt = Integer.parseInt(passString);
int inputPasswordInt = Integer.parseInt(inputPassword);
			//if(passString == inputPassword) {//String型だとfalseになってしまう、、、なぜ、、、、
			if(passInt == inputPasswordInt) {//accountと紐づいたパスワードと入力されたパスワードが同じかどうか
					jsp = "UserStatus.jsp";//ログイン後のUserStatus画面
					Map<String,Integer> tempMap = new HashMap<>();
					for(int i=0; i<idList.size(); i++) {
						tempMap.put(accountList.get(i),idList.get(i));
					}
					int id = tempMap.get(inputAccount);
					Object userStatus = userObjectListMap.get(id);
					HttpSession session = request.getSession();//
					session.setAttribute("userStatus",userStatus);//

					RequestDispatcher rd = request.getRequestDispatcher("UserStatus.jsp");//
					rd.forward(request,response);

			}else {
					String errorMessage = "入力されたパスワードが登録されておりません。パスワードが正しいかもう一度お確かめ頂き入力ください。";
					jsp="http://localhost:8080/shinbi_GraduationWork_QuizSystem/loginSystem/error.jsp";
					HttpSession session = request.getSession();//
					session.setAttribute("errorMessage",errorMessage);//

					RequestDispatcher rd = request.getRequestDispatcher("error.jsp");//
					rd.forward(request,response);
			}
	}

}