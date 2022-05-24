package com.unosquare;

import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FirstAPITest {
	  @Test
	  public void f() {
		  
			RestAssured.baseURI = "https://reqres.in/api/";
			RequestSpecification httpRequest = RestAssured.given();
			Response response = httpRequest.get("/users/2");
			
			// Assert that correct status code is returned.
			int statusCode = response.getStatusCode();

			Assert.assertEquals(statusCode,200);
			Reporter.log("Success 200 validation");
			
			// Assert first_name and last_name	  
	         response.then().
	         body("data.first_name", equalTo("Janet")).
	         body("data.last_name", equalTo("Weaver"));
			 Reporter.log(response.body().asString());
			
	  }
}













