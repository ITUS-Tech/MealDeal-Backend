package com.itus.mealdeal.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="otps")
public class ResetPassword {
	@Id
	private String email;
	private String otp;
	private String password;
	
	public ResetPassword() {
		super();
	}

	public ResetPassword(String email, String otp, String password) {
		super();
		this.email = email;
		this.otp = otp;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ResetPassword [email=" + email + ", otp=" + otp + ", password=" + password + "]";
	}
	
	
}
