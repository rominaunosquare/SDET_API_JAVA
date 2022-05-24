/*Create a POST Request using JSON Files
Create 2 scripts using POST Requests from: https://reqres.in/  

The scripts should load the JSON file and then convert it into a JSON Object

The script should print the following on the HTML Report:

Response body ok
Response code ok
JSON body that you are sending ok
URL*/

package com.unosquare;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RomiPostPrueba {
	@Test
	public static void main(String[] args) throws IOException, ParseException {
					File file = new File("C:\\Users\\romina.milillo\\eclipse-workspace\\JavaAPI\\Json\\add.Json");
					RestAssured.baseURI = "https://reqres.in/api"; 
					JSONParser json = new JSONParser();

					FileReader fr = new FileReader(file);
					Object obj = json.parse(fr);
					System.out.println("json:"+ obj.toString()); 
					
					String var = "/users";

					Response resp = RestAssured.given().
							contentType(ContentType.JSON).
							body(file).
							
							when().
							post(var).
							
							then().assertThat().statusCode(201).
							extract().response();
							Reporter.log("201 Created");
							
							System.out.println("Status:"+ resp.statusCode()); 
							System.out.println("Resp:"+ resp.asString()); 
							
							
							System.out.println("url:"+ RestAssured.baseURI + var); 
					}
	}



		
		
		

