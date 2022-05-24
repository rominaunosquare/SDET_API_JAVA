package finalpullrequest;
import java.io.File;
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

public class FinalPullRequest {
	@Test
	public void MainTests() throws IOException, ParseException, org.json.simple.parser.ParseException{

		//1 Get list users https://reqres.in/api/users?page=2 
		Response GetListUsers = BeforeSuite().GetRequests("/users?page=2");
		Assert.assertEquals(200, GetListUsers.statusCode());
		Reporter.log("Success 200 validation GetListUsers");	

		//2 Get single user  https://reqres.in/api/users/2
		Response GetSingleUser = BeforeSuite().GetRequests("/users/2");
		Assert.assertEquals(200, GetSingleUser.statusCode());
		Reporter.log("Success 200 validation GetSingleUser");	

		//3 Get list resource https://reqres.in/api/unknown
		Response GetListResource = BeforeSuite().GetRequests("/unknown");
		Assert.assertEquals(200, GetListResource.statusCode());
		Reporter.log("Success 200 validation GetListResource");	

		//4 Get single resource https://reqres.in/api/unknown/2 
		Response GetSingleResource = BeforeSuite().GetRequests("/unknown/2");
		Assert.assertEquals(200, GetSingleResource.statusCode());
		Reporter.log("Success 200 validation GetSingleResource");	

		//5 Post create https://reqres.in/api/users 
		Response PostCreateUser = BeforeSuite().PostPutRequests(".\\Json\\PostCreateUser.json", "/users");
		Assert.assertEquals(201, PostCreateUser.statusCode());
		Reporter.log("200 OK PostCreateUser");

		//6 Post register success https://reqres.in/api/register 
		Response PostRegisterSuccess = BeforeSuite().PostPutRequests(".\\Json\\PostRegisterSuccess.json", "/register"); 
		Assert.assertEquals(200, PostRegisterSuccess.statusCode());
		Reporter.log("200 OK PostRegisterSuccess");

		//7 Post login success https://reqres.in/api/login 
		Response PostLoginSuccess  = BeforeSuite().PostPutRequests(".\\Json\\PostLoginSuccess.json", "/login");
		Assert.assertEquals(200, PostLoginSuccess.statusCode());
		Reporter.log("200 OK PostLoginSuccess");

		//8 Post login unsuccessful https://reqres.in/api/login 
		Response PostLoginUnsuccessful = BeforeSuite().PostPutRequests(".\\Json\\PostLoginUnsuccessful.json","/login");
		Assert.assertEquals(400, PostLoginUnsuccessful.statusCode());
		Reporter.log("400 Missing password PostLoginUnsuccessful");

		//9 Put update https://reqres.in/api/users/2 
		Response PutUpdateUser = BeforeSuite().PostPutRequests(".\\Json\\PutUpdateUser.json", "/users/2");
		Assert.assertEquals(201, PutUpdateUser.statusCode());
		Reporter.log("200 OK PutUpdateUser");
	}

	@BeforeSuite
	private Tests BeforeSuite() {
		Tests tests = new Tests();
		return tests;
	}

	private class Tests {
		private Response GetRequests(String queryParams) throws IOException, org.json.simple.parser.ParseException {
			Options options = new Options();
			options.setQueryParams(queryParams);
			RestAssured.baseURI = "https://reqres.in/api/";

			Response response = RestAssured.given().
					contentType(ContentType.JSON).when().get(options.queryParams).then().extract().response();
			return response; 						
		}

		private Response PostPutRequests(String jsonFile, String queryParams) throws IOException, org.json.simple.parser.ParseException {
			Options options = new Options();
			options.setQueryParams(queryParams);
			options.setJsonFile(jsonFile);
			File file = new File(options.jsonFile);
			RestAssured.baseURI = "https://reqres.in/api/";
			JSONParser json = new JSONParser();
			FileReader fr = new FileReader(file);
			Object obj = json.parse(fr);
			System.out.println("json:"+ obj.toString()); 
			String var = options.queryParams;

			Response resp = RestAssured.
					given().contentType(ContentType.JSON).body(file).
					when().post(var).
					then().extract().response();
			return resp; 	
		}

		private class Options extends Tests{
			private String jsonFile;
			private String queryParams;

			public String getJsonFile() {
				return jsonFile;
			}
			public void setJsonFile(String jsonFile) {
				this.jsonFile = jsonFile;
			}
			public String getQueryParams() {
				return queryParams;
			}
			public void setQueryParams(String queryParams) {
				this.queryParams = queryParams;
			}
		} 		

	} 

}



















