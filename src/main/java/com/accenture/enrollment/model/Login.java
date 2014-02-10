package com.accenture.enrollment.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the login database table.
 * 
 */
@Entity
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="login_id")
	private int loginId;

	private String password;

	@Column(name="user_id")
	private int userId;

	public Login() {
	}

	public int getLoginId() {
		return this.loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}