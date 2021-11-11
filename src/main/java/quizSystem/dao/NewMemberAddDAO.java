package quizSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import quizSystem.dto.MemberDTO;
import quizSystem.dto.NewMemberAddDTO;

public class NewMemberAddDAO {
	//mysqlのDBのURL
	private static final String url ="jdbc:mysql://localhost:3306/quiz?useSSL=false";
	//mysql user ID
	private static final String user = "momose";
	//mysql user password
	private static final String pass = "momose";
	//
	NewMemberAddDTO addUser = new NewMemberAddDTO();
	MemberDTO member = new MemberDTO();
	List<MemberDTO> allMembers = new ArrayList<MemberDTO>();

	//データベース
	//戻りの値の型をList<>にして、データベースから必要な情報を取得し、worldListに格納するメソッド
	public NewMemberAddDTO addUserInfromationToDatabase(String inputAccountname, String inputPasswordByteString){
		//JDBC読み込み
		try{
			//登録するときに同じアカウント名、パスワードがないか確認
			//(1)データベース接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url,user,pass);
			
			//(2)sqlの実行
			//String SQL = "INSERT INTO テーブル名(列名, 列名, …) VALUES( ?, ?, …) ";
			String sqlAddUser = "INSERT INTO usertable(accountname,passwordByteString) VALUES(?,?) ";//Userのfield
			//PreparedStatementではオブジェクトが生成されるときにSQL文が渡されます。PreparedStatementでは、SQL文はプリコンパイルされ、データベースで高速に処理されます。
			PreparedStatement psAddUser = connect.prepareStatement(sqlAddUser);//idはsqlDBでauto incrimentで自動生成されるはずなのでいれず。
			//上のsql文の?にこのprepareStatement#setXXXでセットする。
			psAddUser.setString(1,inputAccountname);
			psAddUser.setString(2,inputPasswordByteString);
			int temp = psAddUser.executeUpdate();
			//PreparedStatementでは、SQLのselect文を実行するとき、executeQueryメソッドを使います。検索結果として、ResultSetが返されます。
			String sqlUser = "SELECT * FROM usertable ORDER BY id DESC LIMIT 1";
			PreparedStatement psUser = connect.prepareStatement(sqlUser);
			ResultSet rsUser = psUser.executeQuery();

			//(3)sqlの実行結果の処理
			while(rsUser.next()) {
				int id =rsUser.getInt("id");
				String accountname = rsUser.getString("accountname");
				String passwordByteString = rsUser.getString("passwordByteString");
			}
			//(4)終了
			//また、insert, update, deleteのような、データベースの更新を行う処理には、executeUpdateメソッドを使います。更新された行数が返されます。
			psAddUser.close();
			psUser.close();
			rsUser.close();
			connect.close();

		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return addUser;
	}

}
