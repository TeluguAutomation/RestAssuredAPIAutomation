package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.LoggingFilter.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * BaseService acts as a wrapper for all common Rest Assured functionality.
 * It sets up the base URI and provides reusable methods for making HTTP requests.
 */
public class BaseService {

    // Base URI for all API calls
    private static final String BASE_URL = "https://swift.techwithjatin.com";

    /**
     * RequestSpecification is a Rest Assured interface that allows you to
     * define and reuse request configurations like headers, authentication,
     * content types, query parameters, etc.
     *
     * Here, we use it to initialize all requests with the base URI.
     */
    private RequestSpecification requestSpecification;
    
    static{
    RestAssured.filters(new LoggingFilter());
    }

    public BaseService() {
        // Initialize the RequestSpecification with base URI
        requestSpecification = given().baseUri(BASE_URL);
    }

    
    protected void setAuthToken(String token) {
        requestSpecification.header("Authorization", "Bearer " +token);
    }

    
    /**
     * Sends a POST request to the given endpoint with the specified payload.
     *
     * @param payload  The request body to be sent (in JSON format).
     *                 We use Object type here because it is the parent of all classes.
     *                 This allows us to pass any request model class without overloading the method.
     * @param endpoint The relative endpoint (e.g., "/sign-in").
     * @return The Response object returned by Rest Assured.
     */
    protected Response postRequest(Object payload, String endpoint) {
        return requestSpecification
                .contentType(ContentType.JSON)
                .body(payload)
                .post(endpoint);
    }
    
    protected Response putRequest(Object payload, String endpoint) {
        return requestSpecification
                .contentType(ContentType.JSON)
                .body(payload)
                .put(endpoint);
    }
    
    protected Response getRequest(String endpoint) {
    	return requestSpecification
    			.contentType(ContentType.JSON)
    			.get(endpoint);
    }
}
