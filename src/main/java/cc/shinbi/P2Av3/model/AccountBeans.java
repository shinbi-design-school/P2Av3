package cc.shinbi.P2Av3.model;

import java.io.Serializable;

public class AccountBeans implements Serializable {
	private static final long serialVersionUID = 1L;

	private String loginId;
	private String pass;
	private String name;
	private int role;

	public String getLoginId() {
	return loginId;
}
	public void setLoginId(String loginId) {
	this.loginId = loginId;
}
	public String getPass() {
	return pass;
}
	public void setPass(String pass) {
	this.pass = pass;
}
	public String getName() {
	return name;
}
	public void setName(String name) {
	this.name = name;
}
	public int getRole() {
	return role;
	}
    public void setRole(int role) {
	this.role = role;
	}
}

