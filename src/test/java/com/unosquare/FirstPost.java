package com.unosquare;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FirstPost {
		@Test
		public void main() {
			  RestAssured.baseURI = "https://reqres.in/api"; 
			  RequestSpecification httpRequest=RestAssured.given();
			  JSONObject requestParams=new JSONObject();			  
			  requestParams.put("name","JohnAPI");
			  requestParams.put("job","QA");
			
			  httpRequest.headers("Content-Type", "application/json");
			  
			  httpRequest.body(requestParams.toString());
			  
			  Response response = httpRequest.post("/users");
			  
			  String responseBody=response.getBody().asString();
			  System.out.println("Response Body is:"+responseBody);
        }
}













































