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

import quizSystem.dao.TochigiQuiz_DataAccessObject;
import quizSystem.dto.TochigiQuiz_DataTransferObject;

/**
 * Servlet implementation class WorldListDisplay
 */
//mysqlに登録されたデータベースのテーブルの中身を表示するクラス
@WebServlet("/TochigiQuiz_QuizShowServlet")
public class TochigiQuiz_QuizShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TochigiQuiz_QuizShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //htmlよちformメソッドのaction=getで情報が送信された場合、このメソッドが実行される。
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);//doPostメソッド実行
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//htmlでform ation=postで情報送信された場合、このメソッド実行
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charaset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		//ブラウザから情報取得できているか
		String quizName = request.getParameter("quizName");
		String accountName = request.getParameter("accountName");
		String id = request.getParameter("id");
System.out.println("ブラウザから情報が主遠くできているか");
System.out.println(quizName);
System.out.println(accountName);
System.out.println(id);
		//返信する情報の作成--------
		//データベースにアクセスするオブジェクトメソッドをインスタンス
		TochigiQuiz_DataAccessObject quizDAO = new TochigiQuiz_DataAccessObject();
		//データベースから情報を写す型のオブジェクトのリストを左辺にして、右辺にデータベースの接続クラスのメソッドを指定し、データベースの接続とデータベースから情報を引き出すメソッドを実行
		List<TochigiQuiz_DataTransferObject> quizList = quizDAO.pullInfromationCountryFromDatabase(quizName);


		
		//System.out.println(quizName);
		//セッションの開始//左辺でセッションオブジェクト、右辺でrequest情報の中にあるsessionの情報をgetするメソッドの実行
		HttpSession session = request.getSession();
		//sessionに
		//.setAttribute(name,value)
		session.setAttribute("quizList",quizList);
		session.setAttribute("quizName", quizName);
		session.setAttribute("accountName", accountName);
		session.setAttribute("id", id);
	//返信する情報の作成-------
	
	//返信する情報を送る
		/*
		 クライアントからリクエストを受信し、サーバー上の任意のリソース（サーブレット、HTML ファイル、JSP ファイルなど）
		 に送信するオブジェクトを定義します。サーブレットコンテナーは RequestDispatcher オブジェクトを作成します。
		 これは、特定のパスにあるか、特定の名前で指定されたサーバーリソースのラッパーとして使用されます。
		 */
		//つまり、左辺にrdによって返信する情報の小包（中身の入ったつつみ）を準備して、右辺：requestにworldList.jspをrequestの中身として入れる。
		RequestDispatcher rd = request.getRequestDispatcher("TochigiQuiz_quizList.jsp");
		//rd(つつみ）をrequestとresponseに返して送信？
		rd.forward(request,response);
	//返信する情報を送る
		
	}

}