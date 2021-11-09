package quizSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import quizSystem.dto.LoginDTO;



public class LoginDAO {
	//mysqlのDBのURL
	private static final String url ="jdbc:mysql://localhost:3306/quiz?useSSL=false";
	//mysql user ID
	private static final String user = "momose";
	//mysql user password
	private static final String password = "momose";
	//入れるデータのリスト化する型
	private List<LoginDTO> userList = new ArrayList<>();
	private List<LoginDTO> answerTimeList = new ArrayList<>();
	private List<LoginDTO> theNumberOfCorrectAnswerList = new ArrayList<>();

	PreparedStatement psUser = null;
	PreparedStatement psAnswerTime = null;
	PreparedStatement psTheNumberOfCorrectAnswer = null;
	ResultSet resultUser = null;
	ResultSet resultAnswerTime = null;
	ResultSet resultTheNumberOfCorrectAnswer = null;
	//データベース
	//戻りの値の型をList<>にして、データベースから必要な情報を取得し、worldListに格納するメソッド


	//DBよりusertable情報を格納したリストを返す。
	public List<LoginDTO> userDAO(){
		//JDBC読み込み
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");//これがないとlistにアイテムが入っていないというエラー：NullPointExceptionがでてしまう、、、、

			Connection connect = DriverManager.getConnection(url,user,password);

			//データベースからquizテーブルにあるカラムを全選択（SQL文）
			String user_sql = "SELECT * from usertable ";

			PreparedStatement psUser = connect.prepareStatement(user_sql);
			
			resultUser = psUser.executeQuery();

			while(resultUser.next()) {
				//データベースから取得した値をセットする
				LoginDTO loginDTO = new LoginDTO();
				//DTOのメソッドset××（）よりSQLよりとってきたカラムのフィールドにあるフィールドｔと値をセット
				loginDTO.setId(resultUser.getInt("id"));
				loginDTO.setAccountname(resultUser.getString("accountname"));
				loginDTO.setPassword(resultUser.getString("password"));
				loginDTO.setPasswordBytes(resultUser.getBytes("passwordBytes"));
				
				//listにいれてリスト形式で格納
				userList.add(loginDTO);
				
			}
			resultUser.close();
			psUser.close();
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userList;
	}

	public List<LoginDTO> answerTimeDAO(){
		//JDBC読み込み
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");//これがないとlistにアイテムが入っていないというエラー：NullPointExceptionがでてしまう、、、、

			Connection connect = DriverManager.getConnection(url,user,password);
			
			String answertime_sql = "SELECT * from answertime ";

			PreparedStatement psAnswerTime = connect.prepareStatement(answertime_sql);
			
			ResultSet resultAnswerTime = psAnswerTime.executeQuery();
			
			while(resultAnswerTime.next()) {
				//データベースから取得した値をセットする
				LoginDTO  loginDTO = new LoginDTO();
				//DTOのメソッドset××（）よりSQLよりとってきたカラムのフィールドにあるフィールドｔと値をセット
				loginDTO.setId(resultAnswerTime.getInt("id"));
				loginDTO.setUserId(resultAnswerTime.getInt("userid"));
				//for(int i=0; answerTime１、２，３、、、のように繰り返し処理で全部のDBのこのテーブルのフィールドをとる

				loginDTO.setAnswerTime(resultAnswerTime.getTime("answerTime"));
				
				//listにいれてリスト形式で格納
				answerTimeList.add(loginDTO);
/*
for(int i=0;answerTimeList.size(); i++){
	System.out.println(answerTimeList.get(i));
}
*/
			}
			resultAnswerTime.close();
			psAnswerTime.close();
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return answerTimeList;
	}

	public List<LoginDTO> theNumberOfCorrectAnswer(){
		//JDBC読み込み
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");//これがないとlistにアイテムが入っていないというエラー：NullPointExceptionがでてしまう、、、、

			Connection connect = DriverManager.getConnection(url,user,password);
			
			String thenumberofcorrectanswer_sql = "SELECT * from thenumberofcorrectanswer ";
			psTheNumberOfCorrectAnswer = connect.prepareStatement(thenumberofcorrectanswer_sql);
			//左辺：SQL文の結果を格納するための変数　　　右辺：SQL文の実行
			resultTheNumberOfCorrectAnswer = psTheNumberOfCorrectAnswer.executeQuery();

			while(resultTheNumberOfCorrectAnswer.next()) {
				//データベースから取得した値をセットする
				LoginDTO  loginDTO = new LoginDTO();
				//DTOのメソッドset××（）よりSQLよりとってきたカラムのフィールドにあるフィールドｔと値をセット

				loginDTO.setId(resultTheNumberOfCorrectAnswer.getInt("id"));
				loginDTO.setUserId(resultTheNumberOfCorrectAnswer.getInt("userid"));
				loginDTO.setCorrectNumber(resultTheNumberOfCorrectAnswer.getInt("CorrectNumber"));
				
				//listにいれてリスト形式で格納
				theNumberOfCorrectAnswerList.add(loginDTO);
/*
for(int i=0;theNumberOfCorrectAnswerList.size(); i++){
	System.out.println(theNumberOfCorrectAnswerList.get(i));
}
*/
			}
			resultTheNumberOfCorrectAnswer.close();
			psTheNumberOfCorrectAnswer.close();
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return theNumberOfCorrectAnswerList;
	}

}