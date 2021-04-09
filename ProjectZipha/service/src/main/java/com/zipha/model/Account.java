package com.zipha.model;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.amazonaws.util.json.JSONObject;


@Document(collection="acount")
public class Account {
	@Email
	@NotNull
	private String Email;
	@NotNull
	private String Password;
	@NotNull
	private String firstName;
	private Optional<String> lastName;
	private Optional<String> Phone;
	@NotNull
	private String Account_Type;
	@Value("Zipha")
	private Optional<String> Signup_Type;
	@Value("False")
	private Optional<Boolean> Is_Super_User;
	@Id
	private String User_Id;
	
	private JSONObject account_details;

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Optional<String> getLastName() {
		return lastName;
	}

	public void setLastName(Optional<String> lastName) {
		this.lastName = lastName;
	}

	public Optional<String> getPhone() {
		return Phone;
	}

	public void setPhone(Optional<String> phone) {
		Phone = phone;
	}

	public String getAccount_Type() {
		return Account_Type;
	}

	public void setAccount_Type(String account_Type) {
		Account_Type = account_Type;
	}

	public Optional<String> getSignup_Type() {
		return Signup_Type;
	}

	public void setSignup_Type(Optional<String> signup_Type) {
		Signup_Type = signup_Type;
	}

	public Optional<Boolean> getIs_Super_User() {
		return Is_Super_User;
	}

	public void setIs_Super_User(Optional<Boolean> is_Super_User) {
		Is_Super_User = is_Super_User;
	}

	public String getUser_Id() {
		return User_Id;
	}

	public void setUser_Id(String user_Id) {
		User_Id = user_Id;
	}

	public JSONObject getAccount_details() {
		return account_details;
	}

	public void setAccount_details(JSONObject account_details) {
		this.account_details = account_details;
	}

	public Account() {
	}

	public Account(@javax.validation.constraints.Email @NotNull String email, @NotNull String password,
			@NotNull String firstName, Optional<String> lastName, Optional<String> phone, @NotNull String account_Type,
			Optional<String> signup_Type, Optional<Boolean> is_Super_User, String user_Id, JSONObject account_details) {
		super();
		Email = email;
		Password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		Phone = phone;
		Account_Type = account_Type;
		Signup_Type = signup_Type;
		Is_Super_User = is_Super_User;
		User_Id = user_Id;
		this.account_details = account_details;
	}
	
	
}
