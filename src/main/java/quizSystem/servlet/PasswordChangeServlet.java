package quizSystem.servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quizSystem.dao.PasswordChangeDAO;

/**
 * Servlet implementation class PasswordChangeServlet
 */
@WebServlet("/PasswordChangeServlet")
public class PasswordChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordChangeServlet() {
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
		
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
System.out.println("変更対象のid番号は？");
System.out.println(id);
		String accountname = request.getParameter("accountName");
System.out.println("accountnameの情報が取得できているか確認");
System.out.println(accountname);
		String passwordByteString = request.getParameter("passwordByteString");
		String inputPasswordChange = request.getParameter("passwordChange");
System.out.println("変更するパスワード");
System.out.println(inputPasswordChange);
		
		//入力されたpasswordをハッシュ化
		byte[] inputPasswordChangeByte = null ;
		StringBuilder inputPasswordChangeByteSB = null;
		String inputPasswordChangeByteString = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(inputPasswordChange.getBytes());
			inputPasswordChangeByte = digest.digest();
			inputPasswordChangeByteSB = new StringBuilder(2*inputPasswordChangeByte.length);
			for(byte b : inputPasswordChangeByte){
				inputPasswordChangeByteSB.append(String.format("%02x",b&0xff));
			}
			inputPasswordChangeByteString = new String(inputPasswordChangeByteSB);
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		PasswordChangeDAO dao = new PasswordChangeDAO();
		dao.passwordChange(id,inputPasswordChangeByteString);

		List<String> afterUser = new ArrayList<>();
		afterUser.add(ids);
		afterUser.add(accountname);
		afterUser.add(inputPasswordChange);
		afterUser.add(inputPasswordChangeByteString);
System.out.println("afterUserの中身は？");
System.out.println(afterUser);

		HttpSession session = request.getSession();//
		session.setAttribute("afterUser",afterUser);//
		
		String jsp = "passwordChangeComplete.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(jsp);//
		rd.forward(request, response);
	}

}
