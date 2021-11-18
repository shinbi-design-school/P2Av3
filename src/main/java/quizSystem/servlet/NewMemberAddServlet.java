package quizSystem.servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
		
		//ブラウザから値が取れているか確認
		String inputAccountname = request.getParameter("accountname");
		String inputPassword = request.getParameter("password");
		
System.out.println("ブラウザ入力の確認");
System.out.println(inputAccountname);
System.out.println(inputPassword);
		
		//入力されたpasswordをハッシュ化
		byte[] inputPasswordByte = null ;
		StringBuilder inputPasswordByteSB = null;
		String inputPasswordByteString = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(inputPassword.getBytes());
			inputPasswordByte = digest.digest();
			inputPasswordByteSB = new StringBuilder(2*inputPasswordByte.length);
			for(byte b : inputPasswordByte){
				inputPasswordByteSB.append(String.format("%02x",b&0xff));
			}
			inputPasswordByteString = new String(inputPasswordByteSB);
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
System.out.println("パスワードのハッシュ化確認");
System.out.println(inputPasswordByteString);

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
		List<String> passwordByteStringList = new ArrayList<>();
		List<Time> answerTimeList = new ArrayList<>();
		List<Integer> correctNumber = new ArrayList<>();
		
		
		//結果を格納するリスト
		List<String> result = new ArrayList<>();
		
		
		//sqlから持ってきたデータをリストへ格納
		for(int i=0; i<userList.size();i++) {
			dto = (LoginDTO)userList.get(i);
			idList.add(dto.getId());
			accountList.add(dto.getAccountname());
			passwordList.add(dto.getPassword());
			passwordByteStringList.add(dto.getPasswordByteString());
			answerTimeList.add(dto.getAnswerTime());
			correctNumber.add(dto.getCorrectNumber());
			
			List<Object> tempList = new ArrayList<>();
			tempList.add(dto.getId());
			tempList.add(dto.getAccountname());
			tempList.add(dto.getPassword());
			tempList.add(dto.getPasswordByteString());
			//ソートするメソッド入れないとだめでは、、、、
			tempList.add(dto.getAnswerTime());
			//同上
			tempList.add(dto.getCorrectNumber());
			
			userObjectList.add(tempList);
			
		}
System.out.println("sqlデータが取得できているか確認");
System.out.println(idList);
System.out.println(accountList);
System.out.println(passwordList);
System.out.println(passwordByteStringList);
System.out.println(answerTimeList);
System.out.println(correctNumber);
		
		//同じアカウント名やパスワードがないか確認
		if(accountList.contains(inputAccountname)) {
			String errorMessage ="同じアカウント名が既に登録されています。お手数ですが別のアカウント名を登録してください。";
			String jsp="error.jsp";
			HttpSession session = request.getSession();//
			session.setAttribute("errorMessage",errorMessage);//
			
			RequestDispatcher rd = request.getRequestDispatcher(jsp);//
			rd.forward(request,response);
		}else if(passwordByteStringList.contains(inputPasswordByteString)) {
			String errorMessage ="同じパスワードが既に登録されています。お手数ですが別のパスワードを登録してください。";
			String jsp="error.jsp";
			HttpSession session = request.getSession();//
			session.setAttribute("errorMessage",errorMessage);//
			
			RequestDispatcher rd = request.getRequestDispatcher(jsp);//
			rd.forward(request,response);
		}
		else {//同じアカウント名やパスワードがなければ登録
System.out.println("登録する情報が届いているか確認");
System.out.println(inputAccountname);
System.out.println();
			NewMemberAddDAO userAddDAO = new NewMemberAddDAO();//DBアクセスのオブジェクトをインスタンス
			NewMemberAddDTO addUser = userAddDAO.addUserInfromationToDatabase(inputAccountname,inputPasswordByteString);//

System.out.println("addUserに情報が入っているか確認");
System.out.println(addUser.getId());
System.out.println(addUser.getAccountname());
System.out.println(addUser.getPasswordByteString());

			HttpSession session = request.getSession();//
			session.setAttribute("addUser",addUser);//
			session.setAttribute("inputPassword",inputPassword);
			
			RequestDispatcher rd = request.getRequestDispatcher("NewMemberAddCompleted.jsp");//
			rd.forward(request,response);
		
		}

		
	}

}
