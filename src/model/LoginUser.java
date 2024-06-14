package model;

import java.io.Serializable;

public class LoginUser implements Serializable {
	private int id;	// ログイン時のnumber

	public LoginUser() {
		this(null);
	}

	public LoginUser(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setUserId(int id) {
		this.id = id;
	}
}
