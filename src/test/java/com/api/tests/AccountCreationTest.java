package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

    @Test(description = "Verify if Login API is working...")
    public void createAccountTest() {

        // Step 1: Create the SignUpRequest object using Builder pattern
        // Instead of passing all parameters in a constructor, we use Builder for readability
        SignUpRequest signUpRequest = new SignUpRequest.Builder()
                .username("dia1234")
                .email("dish13@yahoo.com")
                .firstName("Dis6ha")
                .password("dsh123")
                .lastName("Bhatt")
                .mobileNumber("7777777774")
                .build();

        // Step 2: Call the AuthService to send the sign-up request to the API
        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);

        // Step 3: Print the raw response from the server
        System.out.println(response.asPrettyString());

        // Step 4: Assert (verify) that the response message matches the expected value
        // Since it's a single-line message, no need for a separate response model class
        Assert.assertEquals(response.asPrettyString(), "User registered successfully!");

        // Step 5: Verify that the HTTP status code is 200 (OK)
        Assert.assertEquals(response.statusCode(), 200);
    }
}
