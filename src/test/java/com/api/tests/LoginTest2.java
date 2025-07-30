package com.api.tests;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class LoginTest2 {


    @Test(description = "Verify if Login API is working...")
    public void loginTest() {
        Response response = given()
                .baseUri("https://swift.techwithjatin.com")
                .header("Content-Type", "application/json")
                .body("{\"username\": \"bhaskar_99\", \"password\": \"Sel$hi@8\"}")
                .post("/api/auth/login");

        System.out.println(response.asPrettyString());

        // Assert status code is 200
        Assert.assertEquals(response.getStatusCode(), 200);
	}
}
