package quizSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PasswordChangeDAO {
	//mysqlのDBのURL
		private static final String url ="jdbc:mysql://localhost:3306/quiz?useSSL=false";
		//mysql user ID
		private static final String user = "root";
		//mysql user password
		private static final String password = "";
		//入れるデータのリスト化する型

		public void passwordChange(int id, String inputPasswordChangeByteString){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connect = DriverManager.getConnection(url,user,password);
				
				String passwordUpdateSQL = "UPDATE usertable SET passwordByteString = ? WHERE usertable.id = ? ";
				PreparedStatement ps = connect.prepareStatement(passwordUpdateSQL);
				ps.setString(1,inputPasswordChangeByteString);
				ps.setInt(2,id);
				int temp = ps.executeUpdate();
System.out.println("update文が実行されているかtempで確認");
System.out.println(temp);
				//(4)終了
				ps.close();
				connect.close();
			}catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

}
