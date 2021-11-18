package quizSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import quizSystem.dto.InqueryFormDTO;

public class InqueryFormDAO {
	//mysqlのDBのURL
	private static final String url ="jdbc:mysql://localhost:3306/quiz?useSSL=false";
	//mysql user ID
	private static final String user = "root";
	//mysql user password
	private static final String pass = "";
	//
	InqueryFormDTO queryDTO = new InqueryFormDTO();
	int userid;
	List<String> accountnames = new ArrayList<>();
	List<InqueryFormDTO> inqueryAll = new ArrayList<>();
	List<InqueryFormDTO> inquerySelectAll = new ArrayList<>();

	//データベース
	//戻りの値の型をList<>にして、データベースから必要な情報を取得し、worldListに格納するメソッド
	public InqueryFormDTO queryPut(int userid,String accountname,String mailaddress,String query){
		//JDBC読み込み
		try{
			//登録するときに同じアカウント名、パスワードがないか確認
			//(1)データベース接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url,user,pass);
			
			//(2)sqlの実行
			//String SQL = "INSERT INTO テーブル名(列名, 列名, …) VALUES( ?, ?, …) ";
			String sqlQuery = "INSERT INTO inqueryForm(userid,accountname,mailaddress,query) VALUES(?,?,?,?) ";
			PreparedStatement psQuery = connect.prepareStatement(sqlQuery);
			//上のsql文の?にこのprepareStatement#setXXXでセットする。
			psQuery.setInt(1,userid);
			psQuery.setString(2,accountname);
			psQuery.setString(3,mailaddress);
			psQuery.setString(4,query);
			psQuery.executeUpdate();
			//PreparedStatementでは、SQLのselect文を実行するとき、executeQueryメソッドを使います。検索結果として、ResultSetが返されます。
			String sql = "SELECT * FROM inqueryForm ORDER BY id DESC LIMIT 1";
			PreparedStatement ps = connect.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			//(3)sqlの実行結果の処理
			while(rs.next()) {
				int tempUserid =rs.getInt("userid");
				queryDTO.setUserid(tempUserid);
				String tempAccountname = rs.getString("accountname");
				queryDTO.setAccountname(tempAccountname);
				String tempMailaddress = rs.getString("mailaddress");
				queryDTO.setMailaddress(tempMailaddress);
				String tempQueryMessage = rs.getString("query");
				queryDTO.setQuery(tempQueryMessage);
			}
			//(4)終了
			//また、insert, update, deleteのような、データベースの更新を行う処理には、executeUpdateメソッドを使います。更新された行数が返されます。
			psQuery.close();
			ps.close();
			rs.close();
			connect.close();

		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return queryDTO;
	}
	
	
	
	
	public int useridSearch(String accountname) {
		try{
			//登録するときに同じアカウント名、パスワードがないか確認
			//(1)データベース接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url,user,pass);
			
			//(2)sqlの実行
			//String SQL = "INSERT INTO テーブル名(列名, 列名, …) VALUES( ?, ?, …) ";
			String sqlSearch = "SELECT id FROM `usertable` WHERE accountname = ?  ";
			PreparedStatement psSearch = connect.prepareStatement(sqlSearch);
			//上のsql文の?にこのprepareStatement#setXXXでセットする。
			psSearch.setString(1,accountname);
			ResultSet rsSearch = psSearch.executeQuery();

			//(3)sqlの実行結果の処理
			while(rsSearch.next()) {
				userid =rsSearch.getInt("id");
			}
			//(4)終了
			//また、insert, update, deleteのような、データベースの更新を行う処理には、executeUpdateメソッドを使います。更新された行数が返されます。
			psSearch.close();
			rsSearch.close();
			connect.close();

		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userid;
		
	}
	
	public List<String> userAccountSearch(String accountname) {
		try{
			//登録するときに同じアカウント名、パスワードがないか確認
			//(1)データベース接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url,user,pass);
			
			//(2)sqlの実行
			//String SQL = "INSERT INTO テーブル名(列名, 列名, …) VALUES( ?, ?, …) ";
			String sqlAccountSearch = "SELECT accountname FROM usertable ";
			PreparedStatement psAccountSearch = connect.prepareStatement(sqlAccountSearch);
			//上のsql文の?にこのprepareStatement#setXXXでセットする。
			ResultSet rsAccountSearch = psAccountSearch.executeQuery();

			//(3)sqlの実行結果の処理
			while(rsAccountSearch.next()) {
				String tempAccountname =rsAccountSearch.getString("accountname");
				accountnames.add(tempAccountname);
			}
			//(4)終了
			//また、insert, update, deleteのような、データベースの更新を行う処理には、executeUpdateメソッドを使います。更新された行数が返されます。
			psAccountSearch.close();
			rsAccountSearch.close();
			connect.close();

		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return accountnames;
		
	}
	
	public List<InqueryFormDTO> inqueryAll() {
		try{
			//登録するときに同じアカウント名、パスワードがないか確認
			//(1)データベース接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url,user,pass);
			
			//(2)sqlの実行
			//String SQL = "INSERT INTO テーブル名(列名, 列名, …) VALUES( ?, ?, …) ";
			String sqlAll = "SELECT * FROM inqueryForm ";
			PreparedStatement psAll = connect.prepareStatement(sqlAll);
			//上のsql文の?にこのprepareStatement#setXXXでセットする。
			ResultSet rsAll = psAll.executeQuery();

			//(3)sqlの実行結果の処理
			while(rsAll.next()) {
				InqueryFormDTO tempDTO = new InqueryFormDTO();
				tempDTO.setId(rsAll.getInt("id"));
				tempDTO.setUserid(rsAll.getInt("userid"));
				tempDTO.setAccountname(rsAll.getString("accountname"));
				tempDTO.setMailaddress(rsAll.getString("mailaddress"));
				tempDTO.setQuery(rsAll.getString("query"));
				tempDTO.setReply(rsAll.getString("reply"));
				
				inqueryAll.add(tempDTO);
			}
			//(4)終了
			//また、insert, update, deleteのような、データベースの更新を行う処理には、executeUpdateメソッドを使います。更新された行数が返されます。
			psAll.close();
			rsAll.close();
			connect.close();

		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return inqueryAll;
		
	}
	
	
	public void queryReply(String reply , int queryId){
		//JDBC読み込み
		try{
			//登録するときに同じアカウント名、パスワードがないか確認
			//(1)データベース接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url,user,pass);
			
			//(2)sqlの実行
			//String SQL = "INSERT INTO テーブル名(列名, 列名, …) VALUES( ?, ?, …) ";
			String sqlReply = "UPDATE `inqueryform` SET `reply` = ? WHERE `inqueryform`.`id` = ?  ";//Userのfield
			//PreparedStatementではオブジェクトが生成されるときにSQL文が渡されます。PreparedStatementでは、SQL文はプリコンパイルされ、データベースで高速に処理されます。
			PreparedStatement psReply = connect.prepareStatement(sqlReply);//idはsqlDBでauto incrimentで自動生成されるはずなのでいれず。
			//上のsql文の?にこのprepareStatement#setXXXでセットする。
			psReply.setString(1,reply);
			psReply.setInt(2,queryId);
			int temp = psReply.executeUpdate();
			//(4)終了
			//また、insert, update, deleteのような、データベースの更新を行う処理には、executeUpdateメソッドを使います。更新された行数が返されます。
			psReply.close();
			connect.close();

		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<InqueryFormDTO> queryAnswer(int userid){
		//JDBC読み込み
		try{
			//登録するときに同じアカウント名、パスワードがないか確認
			//(1)データベース接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url,user,pass);
			
			//(2)sqlの実行
			//String SQL = "INSERT INTO テーブル名(列名, 列名, …) VALUES( ?, ?, …) ";
			String sqlSelectReply = "SELECT * FROM `inqueryform` WHERE userid = ? ";//Userのfield
			//PreparedStatementではオブジェクトが生成されるときにSQL文が渡されます。PreparedStatementでは、SQL文はプリコンパイルされ、データベースで高速に処理されます。
			PreparedStatement psSelectReply = connect.prepareStatement(sqlSelectReply);//idはsqlDBでauto incrimentで自動生成されるはずなのでいれず。
			//上のsql文の?にこのprepareStatement#setXXXでセットする。
			psSelectReply.setInt(1,userid);
			ResultSet rsSelectAll = psSelectReply.executeQuery();
			
			while(rsSelectAll.next()) {
				InqueryFormDTO tempDTO = new InqueryFormDTO();
				tempDTO.setId(rsSelectAll.getInt("id"));
				tempDTO.setUserid(rsSelectAll.getInt("userid"));
				tempDTO.setAccountname(rsSelectAll.getString("accountname"));
				tempDTO.setMailaddress(rsSelectAll.getString("mailaddress"));
				tempDTO.setQuery(rsSelectAll.getString("query"));
				tempDTO.setReply(rsSelectAll.getString("reply"));
				
				inquerySelectAll.add(tempDTO);
			}
			//(4)終了
			//また、insert, update, deleteのような、データベースの更新を行う処理には、executeUpdateメソッドを使います。更新された行数が返されます。
			psSelectReply.close();
			rsSelectAll.close();
			connect.close();

		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return inquerySelectAll;
	}
	

}
