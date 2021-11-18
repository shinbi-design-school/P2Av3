package quizSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import quizSystem.dto.TochigiQuiz_DataTransferObject;

public class TochigiQuiz_DataAccessObject {
	//mysqlのDBのURL
	private static final String url ="jdbc:mysql://localhost:3306/quiz?useSSL=false";
	//mysql user ID
	private static final String user = "root";
	//mysql user password
	private static final String password = "";
	//入れるデータのリスト化する型
	private List<TochigiQuiz_DataTransferObject> nlist = new ArrayList<>();

	Connection connect = null;
	PreparedStatement ps = null;
	ResultSet result = null;
	//データベース
	//戻りの値の型をList<>にして、データベースから必要な情報を取得し、worldListに格納するメソッド
	public List<TochigiQuiz_DataTransferObject> pullInfromationCountryFromDatabase(String quizName){
		//JDBC読み込み
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");//これがないとlistにアイテムが入っていないというエラー：NullPointExceptionがでてしまう、、、、
			connect = DriverManager.getConnection(url,user,password);

			//データベースからquizテーブルにあるカラムを全選択（SQL文）
			String sql = null;
			try {
				if(quizName.equals("栃木クイズ")) {
					sql = "SELECT * from quiz ";
				}else if(quizName.equals("雑学クイズ２")) {
					sql = "SELECT * from quiz2 ";
				}else if(quizName.equals("雑学クイズ３")) {
					sql = "SELECT * from quiz3 ";
				}else if(quizName.equals("world's_Trivia_Quiz_[ENG]")){
					sql = "SELECT * from quiz4 ";
				}else {}
			}
			catch(Exception e) {}
			ps = connect.prepareStatement(sql);

			//左辺：SQL文の結果を格納するための変数　　　右辺：SQL文の実行
			result = ps.executeQuery();

			while(result.next()) {
				//データベースから取得した値をセットする
				TochigiQuiz_DataTransferObject  worldDataTransferObject = new TochigiQuiz_DataTransferObject();
				//DTOのメソッドset××（）よりSQLよりとってきたカラムのフィールドにあるフィールドｔと値をセット
				worldDataTransferObject.setId(result.getInt("id"));
				worldDataTransferObject.setAnswer(result.getInt("answer"));
				worldDataTransferObject.setQuestion(result.getString("question"));
				worldDataTransferObject.setSelection1(result.getString("selection1"));
				worldDataTransferObject.setSelection2(result.getString("selection2"));
				worldDataTransferObject.setSelection3(result.getString("selection3"));
				worldDataTransferObject.setSelection4(result.getString("selection4"));

				//listにいれてリスト形式で格納
				nlist.add(worldDataTransferObject);
			}
			result.close();
			ps.close();
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return nlist;
	}

}