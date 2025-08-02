package com.opdheal.auth_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

}
/*
 * Sign in with Google Access blocked: This app’s request is invalid You can’t sign in because this app sent an invalid request. You can try again later or contact the developer about this issue. Learn more about this error If you are a developer of this app, see error details. Error 400: redirect_uri_mismatch resolved this issue. im getting this when trying to login with google
 */