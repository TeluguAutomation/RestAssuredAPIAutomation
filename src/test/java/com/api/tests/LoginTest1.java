package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginTest1 {
	
	   @Test(description = "Verify if Login API is working...")
	    public void loginTest() {
	        // Set Base URI
	        RestAssured.baseURI = "https://swift.techwithjatin.com";

	        // Create request
	        RequestSpecification request = RestAssured
	                .given()
	                .header("Content-Type", "application/json")
	                .body("{\"username\": \"bhaskar_99\", \"password\": \"Sel$hi@8\"}");

	        // Send POST request
	        Response response = request.post("/api/auth/login");

	        // Print response
	        System.out.println(response.asPrettyString());
	        
	        Assert.assertEquals(response.getStatusCode(), 200);
   }
}
