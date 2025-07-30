package com.api.tests;

import org.testng.annotations.Test;
import com.api.base.AuthService;
import io.restassured.response.Response;

public class ForgotPasswordTest {

    /**
     * Test Case: Verify if Forgot Password API is working correctly.
     */
    @Test(description = "Verify if Forgot Password API is working...")
    public void forgotPasswordTest() {
        
        // Step 1: Create an object of AuthService to access forgotPassword API
        AuthService authService = new AuthService();
        
        // Step 2: Call forgotPassword method with the test email address
        Response response = authService.forgotPassword("testautomationacademy33@gmail.com");
        
        // Step 3: Print the API response in a readable JSON format
        System.out.println(response.asPrettyString());
        
        // (Optional) You can add assertions here, for example:
        // Assert.assertEquals(response.statusCode(), 200);
        // Assert.assertTrue(response.asPrettyString().contains("Email sent successfully"));
    }
}
