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
import quizSystem.dao.MemberDeleteDAO;
import quizSystem.dto.LoginDTO;

/**
 * Servlet implementation class DeleteMemberServlet2
 * @param <MemberDeleteDTO>
 */
@WebServlet("/DeleteMemberServlet")
public class DeleteMemberServlet<MemberDeleteDTO> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charaset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		//
		String inputIdString = request.getParameter("deleteId");
		int inputId = Integer.parseInt(inputIdString);
		String inputAccountname = request.getParameter("deleteAccountname");
		String inputPassword = request.getParameter("deletePassword");
		
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
System.out.println("ブラウザからパラメーターが取得できているか");
System.out.println(inputId);
System.out.println(inputAccountname);
System.out.println(inputPasswordByteString);
		
		//DAO,DTOのインスタンス
		//入力された既存のアカウントやパスワードがあるか確認（LoginServletより抜粋）
		LoginDAO dao = new LoginDAO();
		List<LoginDTO> userList = dao.userDAO();
		LoginDTO dto;
		
		//sqlからデータを持ってきてリスト化するためのリスト
		List<Integer> idList = new ArrayList<>();
		List<String> accountList = new ArrayList<>();
		List<String> passwordByteStringList = new ArrayList<>();
		List<Time> answerTimeList = new ArrayList<>();
		List<Integer> correctNumber = new ArrayList<>();
		//メンバー削除後のリスト
		List<Integer> idListDeleteAfter = new ArrayList<>();
		List<String> accountListDeleteAfter = new ArrayList<>();
		List<String> passwordByteStringListDeleteAfter = new ArrayList<>();
		List<Time> answerTimeListDeleteAfter = new ArrayList<>();
		List<Integer> correctNumberDeleteAfter = new ArrayList<>();
		
		//sqlから持ってきたデータをリストへ格納
		for(int i=0; i<userList.size();i++) {
			dto = (LoginDTO)userList.get(i);
			idList.add(dto.getId());
			accountList.add(dto.getAccountname());
			passwordByteStringList.add(dto.getPasswordByteString());
			answerTimeList.add(dto.getAnswerTime());
			correctNumber.add(dto.getCorrectNumber());
			
		}
		System.out.println("sqlからとってきたaccountList,passwordListがそろっているか");
		System.out.println(idList);
		System.out.println(accountList);
		System.out.println(passwordByteStringList);
		System.out.println(answerTimeList);
		System.out.println(correctNumber);
		
		//同じアカウント名やパスワードがないか確認
		if(accountList.contains(inputAccountname) && passwordByteStringList.contains(inputPasswordByteString)) {
			//入力されたアカウント名とパスワードが同じであれば（
			MemberDeleteDAO deleteDAO = new MemberDeleteDAO();
			List<LoginDTO> userListDeleteAfter = deleteDAO.deleteUserInfromationToDatabase(inputId,inputAccountname,inputPasswordByteString);
			
			//sqlから持ってきたデータをリストへ格納
			for(int i=0; i<userListDeleteAfter.size();i++) {
				dto = (LoginDTO)userListDeleteAfter.get(i);
				idListDeleteAfter.add(dto.getId());
				accountListDeleteAfter.add(dto.getAccountname());
				passwordByteStringListDeleteAfter.add(dto.getPasswordByteString());
				answerTimeListDeleteAfter.add(dto.getAnswerTime());
				correctNumberDeleteAfter.add(dto.getCorrectNumber());
			}
			
			List<String> memberList = new ArrayList<>();
			for(int i=0; i<idListDeleteAfter.size(); i++) {
				String tempId = Integer.toString(idListDeleteAfter.get(i));
				memberList.add(tempId);
				memberList.add(accountListDeleteAfter.get(i));
				memberList.add(passwordByteStringListDeleteAfter.get(i));
				
			}
			
			HttpSession session = request.getSession();//
			session.setAttribute("memberList",memberList);//

			RequestDispatcher rd = request.getRequestDispatcher("memberDeleteAfterUsers.jsp");//
			rd.forward(request,response);
		}
		else {
			String errorMessage ="アカウント名又はパスワードが間違っています。再度アカウント名とパスワードを確認し削除処理を行ってください。";
			String jsp="error.jsp";
			HttpSession session = request.getSession();//
			session.setAttribute("errorMessage",errorMessage);//
			
			RequestDispatcher rd = request.getRequestDispatcher(jsp);//
			rd.forward(request,response);
		}
		
		
	}

}

