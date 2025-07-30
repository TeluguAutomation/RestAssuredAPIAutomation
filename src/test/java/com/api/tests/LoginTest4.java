package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class LoginTest4 {

	@Test
	public void loginTest() {
		 // Step 1: Create a login request payload with username and password
        LoginRequest loginRequest = new LoginRequest("bhaskar_99", "Sel$hi@8");

        // Step 2: Create an instance of the AuthService to hit the login API
        AuthService authService = new AuthService();

        // Step 3: Send the login request and capture the response
        Response response = authService.login(loginRequest);

        // Step 4: Print the raw response (as JSON string) to the console for debugging
        System.err.println(response.asPrettyString());

        // Step 5: Deserialize the JSON response into a POJO (LoginResponse.class)
        LoginResponse loginResponse = response.as(LoginResponse.class);

        // Step 6: Optionally print the deserialized object’s token field
        System.out.println("Token received: " + loginResponse.getToken());
        System.out.println("Email:" + loginResponse.getEmail());
        Assert.assertTrue(loginResponse.getToken()!=null);
        
	}
}
