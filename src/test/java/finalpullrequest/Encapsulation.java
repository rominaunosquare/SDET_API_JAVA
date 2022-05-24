package finalpullrequest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.*;

import bsh.ParseException;

public class Encapsulation {

	@Test
	public void PostLogin() throws IOException, ParseException, org.json.simple.parser.ParseException{
		Response test = BeforeSuite().PostLogin(".\\Json\\Register.json", "/Login");
		Assert.assertEquals(200, test.statusCode());
		Reporter.log("200 OK");
	}

	@BeforeSuite
	private ApiCore BeforeSuite() {
		ApiCore apiCore = new ApiCore();
		return apiCore;
	}

	private class ApiCore {
		private Response PostLogin(String loginfile, String requri) throws IOException, org.json.simple.parser.ParseException {
			//Response test = apiCore.PostLogin(".\\Json\\Register.json", "/Login");
			Login login = new Login();
			login.setCredentials(loginfile);
			login.setRequestUri(requri);
			File file = new File(login.Credentials);
			RestAssured.baseURI = "https://reqres.in/api"; 
			JSONParser json = new JSONParser();

			FileReader fr = new FileReader(file);
			Object obj = json.parse(fr);
			System.out.println("json:"+ obj.toString()); 

			String var = login.RequestUri;

			Response resp = RestAssured.given().
					contentType(ContentType.JSON).
					body(file).

					when().
					post(var).

					then().
					//assertThat().statusCode(201).
					extract().response();
			//Reporter.log("201 Created");

			return resp; 
		}
	}
	
	private class Login extends ApiCore{

		private String Credentials;
		private String RequestUri;

		public String getCredentials() {
			return Credentials;
		}
		public void setCredentials(String credentials) {
			Credentials = credentials;
		}
		public String getRequestURI() {
			return RequestUri;
		}
		public void setRequestUri(String requestUri) {
			RequestUri = requestUri;
		}

	} 

}



