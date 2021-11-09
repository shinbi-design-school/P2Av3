package quizSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import quizSystem.dto.LoginDTO;

public class MemberDeleteDAO {
	//mysqlのDBのURL
	private static final String url ="jdbc:mysql://localhost:3306/quiz?useSSL=false";
	//mysql user ID
	private static final String user = "momose";
	//mysql user password
	private static final String pass = "momose";
	//
	private List<LoginDTO> userList = new ArrayList<>();
	

	//データベース
	//戻りの値の型をList<>にして、データベースから必要な情報を取得し、worldListに格納するメソッド
	public List<LoginDTO> deleteUserInfromationToDatabase(int inputId,String inputAccountname, String inputPasswordByteString){
		//JDBC読み込み
		try{
			//(1)データベース接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url,user,pass);
			
			//(2)sqlの実行
			//String SQL = "INSERT INTO テーブル名(列名, 列名, …) VALUES( ?, ?, …) ";
			String sqlDeleteUser = "DELETE FROM usertable WHERE usertable.id = ? AND usertable.accountname = ? AND usertable.passwordByteString = ? ";//Userのfield
			//PreparedStatementではオブジェクトが生成されるときにSQL文が渡されます。PreparedStatementでは、SQL文はプリコンパイルされ、データベースで高速に処理されます。
			PreparedStatement psDeleteUser = connect.prepareStatement(sqlDeleteUser);//idはsqlDBでauto incrimentで自動生成されるはずなのでいれず。
			//上のsql文の?にこのprepareStatement#setXXXでセットする。
			psDeleteUser.setInt(1,inputId);
			psDeleteUser.setString(2,inputAccountname);
			psDeleteUser.setString(3,inputPasswordByteString);
			int temp = psDeleteUser.executeUpdate();

			//int count = psAddUser.executeUpdate();
			//PreparedStatementでは、SQLのselect文を実行するとき、executeQueryメソッドを使います。検索結果として、ResultSetが返されます。
			//データベースからquizテーブルにあるカラムを全選択（SQL文）
			String user_sql = "SELECT * from usertable ";
			PreparedStatement psUser = connect.prepareStatement(user_sql);
			
			ResultSet resultUser = psUser.executeQuery();
			
			//(3)実行結果の確認
			while(resultUser.next()) {
				//データベースから取得した値をセットする
				LoginDTO  dto = new LoginDTO();
				//DTOのメソッドset××（）よりSQLよりとってきたカラムのフィールドにあるフィールドｔと値をセット
				dto.setId(resultUser.getInt("id"));
				dto.setAccountname(resultUser.getString("accountname"));
				dto.setPasswordByteString(resultUser.getString("passwordByteString"));
				
				//listにいれてリスト形式で格納
				userList.add(dto);
			}
			//(4)終了
			resultUser.close();
			psUser.close();
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userList;
	}	
		
	
}
