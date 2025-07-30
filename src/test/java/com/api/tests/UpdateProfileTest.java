package com.api.tests;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class UpdateProfileTest {

	@Test(description = "Update the profile")
	public void UpdateProfileInfoTest() {
		AuthService authService= new AuthService();
		Response response = authService.login(new LoginRequest("bhaskar_99", "Sel$hi@8"));
	    LoginResponse loginResponse= response.as(LoginResponse.class);
		//System.out.println(response.asPrettyString());
	    
		//System.out.println("<----------------------->");
		
	    UserProfileManagementService userProfileManagementService= new UserProfileManagementService();
	   response=userProfileManagementService.getProfile(loginResponse.getToken());
	  //  System.out.println(response.asPrettyString());
       UserProfileResponse userProfileResponse= response.as(UserProfileResponse.class);
       Assert.assertEquals(userProfileResponse.getUsername(), "bhaskar_99");
       
     //  System.out.println("<----------------------->");
   	
	
       ProfileRequest profileRequest=new ProfileRequest.Builder()
    		   .setId(userProfileResponse.getId())  // Set from fetched profile
    		   .setUsername(userProfileResponse.getUsername())
    		   .setFirstName("BhaskarYadaterla")
    		   .setLastName("YadaterlaSwetha")
    		   .setEmail("bhaskary@gmail.com")
    		   .setMobileNumber("9573390932")
    		   .build();
       
      response= userProfileManagementService.updateProfile(loginResponse.getToken(),profileRequest);
	  //System.out.println(response.asPrettyString());
	  //System.out.println(profileRequest.asPrettyString());
	}
}
