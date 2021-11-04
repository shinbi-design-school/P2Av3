package quizSystem.servlet.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import quizSystem.dto.NewMemberAddDTO;

public class NewMemberAddTest {
	public static void main(String[] args) {
		//mysqlのDBのURL
		final String url ="jdbc:mysql://localhost:3306/quiz?useSSL=false";
		//mysql user ID
		final String user = "momose";
		//mysql user password
		final String pass = "momose";
		//
		NewMemberAddDTO addUser = new NewMemberAddDTO();

		
		PreparedStatement preId = null;
		ResultSet idset = null;
		ResultSet idset2 = null;
		
			//JDBC読み込み
			try{
				//(1)データベース接続
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connect = DriverManager.getConnection(url,user,pass);
				
				
				//(2)sqlの実行
				//String SQL = "INSERT INTO テーブル名(列名, 列名, …) VALUES( ?, ?, …) ";
				//String sqlAddUser = "INSERT INTO usertable(id,accountname,password) VALUES(?,?,?) ";//Userのfield
				//String idLast = "SELECT * FROM usertable ORDER BY id DESC LIMIT 1";
				
				
				//PreparedStatementではオブジェクトが生成されるときにSQL文が渡されます。PreparedStatementでは、SQL文はプリコンパイルされ、データベースで高速に処理されます。
				PreparedStatement pre = connect.prepareStatement("INSERT INTO usertable(id,accountname,password) VALUES(?,?,?) ");
				Scanner sc = new Scanner(System.in);
				System.out.println("idを入力ください。");
				int id = Integer.parseInt(sc.nextLine());
				System.out.println("追加するid番号");
				System.out.println(id);
				
				System.out.println("名前を入力してください。");
				String accountname = sc.nextLine();
				
				System.out.println("パスワードを入力してください。");
				String password = sc.nextLine();
				
				
				//preId = connect.prepareStatement(idLast);
				//System.out.println("idの最後の番号を記入してください。");
				//int id = Integer.parseInt(sc.nextLine());
				
				//idset2 = preId.executeQuery();
				//while(idset2.next()) {
					//id = idset2.getInt("id");
					//id = id + 1;
				//}

				//上のsql文の?にこのprepareStatement#setXXXでセットする。1番目の?にidをセットする。
				pre.setInt(1,id);
				pre.setString(2,accountname);
				pre.setString(3,password);
				int count = pre.executeUpdate();
				//PreparedStatementでは、SQLのselect文を実行するとき、executeQueryメソッドを使います。検索結果として、ResultSetが返されます。
				//ResultSet rs = pre.executeQuery();
				//(3)sqlの実行結果の処理
				//while(rs.next()) {
					//id = rs.getInt("id");
					//accountname = rs.getString("accuntname");
					//password = rs.getString("password");
					
					//addUser.setId(id);
					//addUser.setAccountname(accountname);
					//addUser.setPassword(password);
					
					//System.out.println(addUser.getId());
					//System.out.println(addUser.getAccountname());
					//System.out.println(addUser.getPassword());
				//}
				//(4)終了
				//また、insert, update, deleteのような、データベースの更新を行う処理には、executeUpdateメソッドを使います。更新された行数が返されます。
				//rs.close();
				pre.close();
				connect.close();
		
			}
			catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
				System.out.println("登録完了しました。");
			}
	}		
}

