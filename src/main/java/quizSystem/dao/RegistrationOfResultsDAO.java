package quizSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import quizSystem.dto.RegistrationOfResultsDTO;

public class RegistrationOfResultsDAO {
	//mysqlのDBのURL
	private static final String url ="jdbc:mysql://localhost:3306/quiz?useSSL=false";
	//mysql user ID
	private static final String user = "root";
	//mysql user password
	private static final String pass = "";
	//
	RegistrationOfResultsDTO userResult = new RegistrationOfResultsDTO();
	List<String> correctNUmberList = new ArrayList<>();
	List<String>  answerTimeList = new ArrayList<>();

	//データベース
	//戻りの値の型をList<>にして、データベースから必要な情報を取得し、worldListに格納するメソッド
	public void resultAdd(int userid,String correctNumber,String answerTime,String timestamp,String quizName){
		//JDBC読み込み
		try{
			//登録するときに同じアカウント名、パスワードがないか確認
			//(1)データベース接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url,user,pass);
			
			//(2)sqlの実行
			//String SQL = "INSERT INTO テーブル名(列名, 列名, …) VALUES( ?, ?, …) ";
			String sqlResultAddCorrect = "INSERT INTO thenumberofcorrectanswer(userid,correctNumber,quizName) VALUES(?,?,?) ";
			String sqlResultAddTime = "INSERT INTO answertime(userid,answerTime,time,quizName) VALUES(?,?,?,?) ";
			//PreparedStatementではオブジェクトが生成されるときにSQL文が渡されます。PreparedStatementでは、SQL文はプリコンパイルされ、データベースで高速に処理されます。
			PreparedStatement psResultAddCorrect = connect.prepareStatement(sqlResultAddCorrect);
			PreparedStatement psResultAddTime = connect.prepareStatement(sqlResultAddTime);
			//上のsql文の?にこのprepareStatement#setXXXでセットする。
			psResultAddCorrect.setInt(1,userid);
			psResultAddCorrect.setString(2,correctNumber);
			psResultAddCorrect.setString(3,quizName);
			psResultAddCorrect.executeUpdate();
			
			psResultAddTime.setInt(1,userid);
			psResultAddTime.setString(2,answerTime);
			psResultAddTime.setString(3,timestamp);
			psResultAddTime.setString(4,quizName);
			psResultAddTime.executeUpdate();
			
			psResultAddCorrect.close();
			psResultAddTime.close();
			connect.close();

		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<String> selectCorrect(int userid){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url,user,pass);

			String sqlCorrect = "SELECT correctNumber FROM `thenumberofcorrectanswer` WHERE userid=? ";
			PreparedStatement psCorrect = connect.prepareStatement(sqlCorrect);
			psCorrect.setInt(1,userid);
			ResultSet rsCorrect = psCorrect.executeQuery();

			while(rsCorrect.next()) {				
				String tempCorrect = rsCorrect.getString("correctNumber");
				correctNUmberList.add(tempCorrect);
				
			}
			psCorrect.close();
			rsCorrect.close();
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return correctNUmberList;
	}
	
	
	public List<String> selectTime(int userid){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url,user,pass);
	
			String sqlTime = "SELECT answerTime,time,quizName FROM `answertime` WHERE userid=? ";
			PreparedStatement psTime = connect.prepareStatement(sqlTime);
			psTime.setInt(1,userid);
			ResultSet rsTime = psTime.executeQuery();
	
			while(rsTime.next()) {				
				String tempTime = rsTime.getString("answerTime");
				answerTimeList.add(tempTime);
				String tempTime2 = rsTime.getString("time");
				answerTimeList.add(tempTime2);
				String tempQuiz = rsTime.getString("quizName");
				answerTimeList.add(tempQuiz);
				
			}
			psTime.close();
			rsTime.close();
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return answerTimeList;
		}
	
	

}