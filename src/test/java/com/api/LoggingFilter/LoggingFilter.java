package com.api.LoggingFilter;

//Import necessary libraries for logging and REST Assured specifications
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;

public class LoggingFilter implements Filter { // Custom filter class for logging API requests and responses

 // Logger instance for this class (static so it can be used globally)
 private static final Logger Logger = LogManager.getLogger(LoggingFilter.class);

 /**
  * This method is called during the request-response filtering process.
  * It logs the details of both the request and the response.
  */
 @Override
 public Response filter(FilterableRequestSpecification requestSpec, 
                        FilterableResponseSpecification responseSpec, 
                        FilterContext ctx) {
     
     logRequest(requestSpec);  // Log the request details
     Response response = ctx.next(requestSpec, responseSpec); // Request is going to execute
     logResponse(response);    // Log the response details
     
     return response;  // Return the response for assertion in tests
 }

 /**
  * Logs details of the HTTP request such as base URI, headers, and payload.
  */
 public void logRequest(FilterableRequestSpecification requestSpec) {
     Logger.info("BASE URI: " + requestSpec.getBaseUri());        // Log base URI of the request
     Logger.info("Request Header: " + requestSpec.getHeaders());  // Log all request headers
     Logger.info("Request Payload: " + requestSpec.getBody());    // Log request body/payload
 }

 /**
  * Logs details of the HTTP response such as status code, headers, and body.
  */
 public void logResponse(Response response) {
     Logger.info("STATUS CODE: " + response.getStatusCode());     // Log response status code
     Logger.info("Response Header: " + response.headers());       // Log all response headers
     Logger.info("Response Body: " + response.getBody().prettyPrint());  // Log response body in formatted text
 }
}
