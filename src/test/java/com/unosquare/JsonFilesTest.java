/*Create a POST Request using JSON Files
Create 2 scripts using POST Requests from: https://reqres.in/  

The scripts should load the JSON file and then convert it into a JSON Object

The script should print the following on the HTML Report:

Response body okkk
Response code okkkkk
JSON body that you are sending  
URL*/

package com.unosquare;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class JsonFilesTest {
	@Test
	public static void main(String[] args) throws IOException, ParseException {
					File file = new File("C:\\Users\\romina.milillo\\eclipse-workspace\\JavaAPI\\Json\\add.Json");
					String URL = RestAssured.baseURI = "https://reqres.in/api"; 
					RequestSpecification httpRequest=RestAssured.given();
						  
					//Return status code:
					JSONParser json = new JSONParser();
					httpRequest.contentType(ContentType.JSON);

					httpRequest.body(file);
					
					//System.out.println(URL + json); 

					//httpRequest.body(json.toString());
					FileReader fr = new FileReader(file);
					Object obj = json.parse(fr);
					System.out.println("json:"+ obj.toString()); 
					
					//httpRequest.headers("Content-Type", "application/json");

					Response response = httpRequest.post("/users");
						  

					//System.out.println("json body request: "+ json); 

						  
					int statusCode = response.getStatusCode();
					System.out.println("status:"+ statusCode); 
					Assert.assertEquals(statusCode,201);
					Reporter.log("201 Created");
						 
					//RequestBody body = response.getBody();
					String body=response.getBody().asString();
					System.out.println("Response body: "+ body); 

					Reporter.log(response.body().asString());

					  }
	}



		
		
		

