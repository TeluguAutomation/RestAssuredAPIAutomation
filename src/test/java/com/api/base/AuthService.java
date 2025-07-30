package com.api.base;

import java.util.HashMap;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService {
    
    // BASE_PATH: Defines the common API path prefix for all authentication-related endpoints.
    private static final String BASE_PATH = "/api/auth/";

    /**
     * Login method to call the login API
     * @param payload - LoginRequest object (contains username & password)
     * @return Response object (contains the API response)
     */
    public Response login(LoginRequest payload) {
        // Calls the generic postRequest() method from BaseService to send a POST request.
        return postRequest(payload, BASE_PATH + "login");
    }

    /**
     * SignUp method to call the signup API
     * @param payload - SignUpRequest object (contains signup details)
     * @return Response object
     */
    public Response signUp(SignUpRequest payload) {
        return postRequest(payload, BASE_PATH + "signup");
    }

    /**
     * Forgot Password method
     * @param emailAddress - Email address of the user who forgot the password
     * @return Response object
     * 
     * Since its having only one field, not creating a POJO class
     */
    public Response forgotPassword(String emailAddress) {
        // Creating a HashMap to send email as JSON payload: { "email": "value" }
        HashMap<String, String> payload = new HashMap<String, String>();
        payload.put("email", emailAddress);
        
        // Sends POST request to the forgot-password API endpoint
        return postRequest(payload, BASE_PATH + "forgot-password");
    }
}
