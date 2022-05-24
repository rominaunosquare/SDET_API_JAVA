package com.unosquare;
//import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Unknown {
	@Test
	public void main() {
		System.out.println("Inicia test");
		
		RestAssured.baseURI = "https://reqres.in/api/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("unknown/2");
		
		
		System.out.println(Integer.toString(statusCode));
		
		// Assert status code
		Assert.assertEquals(statusCode,200);
		Reporter.log("Success 200 validation");
		
		//Assert all the items 
		response.then().
         body("data.id", equalTo(2)).
         body("data.name", equalTo("fuchsia rose")).
         body("data.year", equalTo(2001)).
         body("data.color", equalTo("#C74375")).
         body("data.pantone_value", equalTo("17-2031")).
         body("support.url", equalTo("https://reqres.in/#support-heading")).
         body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
		 Reporter.log(response.body().asString());
	}

}
		
			