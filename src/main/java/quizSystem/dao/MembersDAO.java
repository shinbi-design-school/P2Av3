package quizSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import quizSystem.dto.MemberDTO;

public class MembersDAO {
	//mysqlのDBのURL
		private static final String url ="jdbc:mysql://localhost:3306/quiz?useSSL=false";
		//mysql user ID
		private static final String user = "momose";
		//mysql user password
		private static final String password = "momose";
		//入れるデータのリスト化する型
		public  List<MemberDTO> allMembersList = new ArrayList<MemberDTO>();
		public MemberDTO member = new MemberDTO();
		
		//データベース
		//戻りの値の型をList<>にして、データベースから必要な情報を取得し、worldListに格納するメソッド
		
		
		//DBよりusertable情報を格納したリストを返す。
		public List<MemberDTO> memberDAO(){
			//JDBC読み込み
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");//これがないとlistにアイテムが入っていないというエラー：NullPointExceptionがでてしまう、、、、
				Connection connect = DriverManager.getConnection(url,user,password);
				
				//データベースからquizテーブルにあるカラムを全選択（SQL文）
				String sqlMember = "SELECT * from usertable ";
				PreparedStatement psMember = connect.prepareStatement(sqlMember);
				ResultSet rsMember = psMember.executeQuery();
				
				while(rsMember.next()) {
					member.setId(rsMember.getInt("id"));
					member.setAccountname(rsMember.getString("accountname"));
					member.setPassword(rsMember.getString("password"));
					
					allMembersList.add(member);
				}
				rsMember.close();
				psMember.close();
			}
			catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			return allMembersList;
		}
				
	}