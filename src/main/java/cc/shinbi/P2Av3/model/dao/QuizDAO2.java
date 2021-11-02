package cc.shinbi.P2Av3.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class QuizDAO2 {

	//接続用の情報をフィールドに定数として定義
		private static final String RDB_DRIVE="com.mysql.cj.jdbc.Driver";
	 	private static final String URL="jdbc:mysql://localhost/wordquiz";
	 	private static final String USER="root";
	 	private static final String PASSWD="root";
	 
	 	// データベース接続を行うメソッド
	 	// 
	 	private static Connection getConnection(){
	 		try{
	 			Class.forName(RDB_DRIVE);
	 			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
	 			return con;
	 		}catch(Exception e){
	 			throw new IllegalStateException(e);
	 		}
	 	}
//	 	public ArrayList<QuizDTO> selectAll(){	 
	 	// 
	 	public ArrayList<QuizDTO> findAll(){
	 	
	 		// 変数宣言
	 		Connection con = null;	// DBコネクション
	 		Statement smt = null;	// SQLステートメント
	 
	 		// 配列宣言
	 		ArrayList<QuizDTO> quizList = new ArrayList<QuizDTO>();
	 
	 		// SQL文作成
	 		String sql = "SELECT * FROM question01";
	 
	 		try{
	 			// DBに接続
	 			con = QuizDAO2.getConnection();
	 			smt = con.createStatement();
	 
	 			// SQL文発行
	 			ResultSet rs = smt.executeQuery(sql);
	 
	 			// 
	 			while(rs.next()){
	 				int id = rs.getInt("id");
	 				String question = rs.getString("question");
	 				String Answer = rs.getString("Answer");
	 				String subject01 = rs.getString("subject01");
	 				String subject02 = rs.getString("subject02");
	 				String subject03 = rs.getString("subject03");
	 				
//	 				objDto.setSubject04(rs.getString("subject04"));
//	 				objDto.setOthers(rs.getString("others"));
	 				QuizDTO quizDTO = new QuizDTO(id, question, Answer, subject01, subject02, subject03);
	 				
	 				quizList.add(quizDTO);
	 			}
	 
	 		}catch(SQLException e){
	 			System.out.println("Errorが発生しました！\n"+e);
	 		}finally{
	 			// リソースの開放
	 			if(smt != null){
	 				try{smt.close();}catch(SQLException ignore){}
	 			}
	 			if(con != null){
	 				try{con.close();}catch(SQLException ignore){}
	 			}
	 		}
	 		return quizList;
	 	}
	 ////////////////////
//	 	 public boolean create(QuizDAO2 quizDAO2) {
		 		// 変数宣言
//		 		Connection con2 = null;	// DBコネクション
//		 		Connection conn = null;	// DBコネクション
//		 		Statement smt2 = null;	// SQLステートメント
	 		 
	 	    // データベース接続
//	 	    try{
//	//	    smt2 = con2.createStatement();

	 	      // INSERT文の準備(idは自動連番なので指定しなくてよい）
//	 	      String sql = "INSERT INTO question01(question, Answer, subject01, subject02, subject03) VALUES(?, ?, ?, ?, ?)";
	// 	      PreparedStatement pStmt = conn.prepareStatement(sql);
	 	      // INSERT文中の「?」に使用する値を設定しSQLを完成
	// 	      pStmt.setString(1, quizDAO2.getQuestion());
	// 	      pStmt.setString(2, quizDAO2.getAnswer());
	// 	     pStmt.setString(3, quizDAO2.getsubject01());
	// 	    pStmt.setString(4, quizDAO2.getsubject02());
	// 	   pStmt.setString(5, quizDAO2.getsubject03());
	 	      
	 	      
	 	      
	 	      

	 	      // INSERT文を実行
	// 	      int result = pStmt.executeUpdate();

	// 	      if (result != 1) {
	// 	        return false;
	// 	      }
	// 	    } catch (SQLException e) {
	// 	      e.printStackTrace();
	// 	      return false;
	// 	    }
	// 	    return true;
	// 	  }
	 	
	 	///////////////////
	 	
	 	
}
