package com.identityservice.entity;

import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.identityservice.dto.AuthRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class ConfirmationToken {
	
	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public AuthRequest getAuthRequest() {
		return authRequest;
	}

	public void setAuthRequest(AuthRequest authRequest) {
		this.authRequest = authRequest;
	}

	@Id
	private String confirmationToken;
	private AuthRequest authRequest;
	
	public ConfirmationToken(AuthRequest authRequest) {
		this.authRequest = authRequest;
//		confirmationToken = UUID.randomUUID().toString();
		Random random = new Random();
		confirmationToken = String.format("%04d", random.nextInt(10000));
	}
	
}
