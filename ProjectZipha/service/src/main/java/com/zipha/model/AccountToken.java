package com.zipha.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class AccountToken implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String token;
    private String id;
    private String email;
    
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getSessionData() {
		return sessionData;
	}

	public void setSessionData(String sessionData) {
		this.sessionData = sessionData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	private String userId;
    
  
    private Date loginDate;
    
  
    private Date expirationDate;
    
    
    private String sessionData;
    
}

