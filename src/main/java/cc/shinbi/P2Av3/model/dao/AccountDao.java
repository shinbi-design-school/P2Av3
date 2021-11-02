package cc.shinbi.P2Av3.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cc.shinbi.P2Av3.model.AccountBeans;

public class AccountDao {
		// データベース接続に使用する情報
	final String jdbcId = "root";
	final String jdbcPass = "password";
	final String jdbcUrl = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=JST";

	// ログインアカウントを探す
	public AccountBeans findAccount(AccountBeans ab) {

	// 戻り値の用意
	AccountBeans returnAb = new AccountBeans();

	 // データベースへ接続
	try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass)) {

	String sql = "SELECT loginId, pass, name, roleId FROM account WHERE loginId = ? AND pass = ?";
	PreparedStatement ps= con.prepareStatement(sql);

		ps.setString(1, ab.getLoginId());
		ps.setString(2, ab.getPass());

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
		// 見つかったアカウント情報を戻り値にセット
		returnAb.setLoginId(rs.getString("loginId"));
		returnAb.setPass(rs.getString("pass"));
		returnAb.setName(rs.getString("name"));
		returnAb.setRole(rs.getInt("roleId"));
	}
	else {
	// アカウントがなければnullを返す
	return null;

	}
}
	catch (SQLException e) {
		e.printStackTrace();
		return null;
	}

	return returnAb;
	}
}
