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
import quizSystem.dto.LoginDTO;

/**
 * Servlet implementation class MembersServlet
 */
@WebServlet("/MembersServlet")
public class MembersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MembersServlet() {
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
		//文字コードなどの設定
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
		List<String> passwordByteStringList = new ArrayList<>();
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
			passwordByteStringList.add(dto.getPasswordByteString());
			answerTimeList.add(dto.getAnswerTime());
			correctNumber.add(dto.getCorrectNumber());
			
			List<Object> tempList = new ArrayList<>();
			tempList.add(dto.getId());
			tempList.add(dto.getAccountname());
			tempList.add(dto.getPasswordByteString());
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
System.out.println(passwordByteStringList);
System.out.println(answerTimeList);
System.out.println(correctNumber);


		List<String> memberList = new ArrayList<>();
		for(int i=0; i<idList.size(); i++) {
			String tempId = Integer.toString(idList.get(i));
			memberList.add(tempId);
			memberList.add(accountList.get(i));
			memberList.add(passwordByteStringList.get(i));
		}
		HttpSession session = request.getSession();//
		session.setAttribute("memberList",memberList);//

		RequestDispatcher rd = request.getRequestDispatcher("allMemberList.jsp");//
		rd.forward(request,response);
		
	}

}
