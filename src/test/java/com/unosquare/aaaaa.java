import java.io.File;

import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.Reporter;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//FileReader fr = new FileReader(file);
					        //BufferedReader br = new BufferedReader(fr);
					        //String line;
					       // while ((line = br.readLine()) != null) {
					        //    System.out.println(line);
					        //}
//
					        //br.close();
					  
					  
					  //Response response = httpRequest.post("/users");
					  //String responseBody=response.getBody().asString();
					  //System.out.println("Response Body is:"+responseBody);

					  /*
					  JSONParser json = new JSONParser();
					  String userDir = System.getProperty("user.dir");File sarasa = new File("C:\\Test\\SARASA.TXT"); 
				
					  /*
					  
					  // System.out.println(System.getProperty("user.dir"));
					  //if (sarasa.exists()) {  System.out.println(System.getProperty("user.dir"));
					  //}
					   FileReader reader = new FileReader(".\\add.json");	
					  // Object obj = json.parse(reader)//
					  httpRequest.headers("Content-Type", "application/json");
					  
					  // httpRequest.body(reader);
					  httpRequest.post();

					 //  Response response = httpRequest.post("/users");
					  
					  String responseBody=response.getBody().asString();
					  System.out.println("Response Body is:"+responseBody); 
					  
						try{
            // Create new file
            String content = "This is the content to write into create file";
            String path="C:\\Users\\romina.milillo\\eclipse-workspace\\JavaAPI\\Json\\hi.txt";
            File file = new File(path);

            // If file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            // Write in file
            bw.write(content);

            // Close connection
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
					  */






 //FileReader fr = new FileReader(file);
						  //System.out.println(fr);
						  
						  //JSONObject requestParams =new JSONObject();
						  //System.out.println("requestParams: " + requestParams);
 
					 // catch (FileNotFoundException e) {
					       // System.out.println("File not found: " + file);
					      //  }




Extract response, into a string

RestAssured.baseURI="https://rahulshettyacademy.com";
String response = given().log().all().queryParam("key", "qaclick123").header("Content-type", "application/json")
.body(payload.Addplace()).when().post("maps/api/place/add/json")
.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();

System.out.println(response);




''''''''''''''''''''''''''''''



Response response = httpRequest.post("/users");			
	  
int statusCode = response.getStatusCode();
System.out.println("status:"+ statusCode); 
Assert.assertEquals(statusCode,201);
Reporter.log("201 Created");
	 
String body=response.getBody().asString();
System.out.println("Response body: "+ body); 

Reporter.log(response.body().asString());
¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿

Response resp = given().
		header("Content-Type","application/json").
		body(file).
		when().
		post("/users").
		then().assertThat().statusCode(201).
		extract().response();
		JsonPath js= ReusableMethods.rawToJson(resp);
		String id=js.get("ID");
		System.out.println(id);

		
		String response=given().relaxedHTTPSValidation().header("Content-Type","application/json").body("{\r\n" +
				"    \"username\": \"RahulShetty\",\r\n" +
				"    \"password\": \"XXXX11\"\r\n" +
				"}").log().all().filter(session).when().post("/rest/auth/1/session").then().log().all().extract().response().asString();

   

//String URL = RestAssured.baseURI = "https://reqres.in/api"; 
RequestSpecification httpRequest=RestAssured.given();
JSONParser json = new JSONParser();
//httpRequest.contentType(ContentType.JSON);
httpRequest.body(file);
Response response = httpRequest.post("/users"); 
int statusCode = response.getStatusCode();
System.out.println("status:"+ statusCode); 

Assert.assertEquals(statusCode,201);
Reporter.log("201 Created");
String body=response.getBody().asString();
System.out.println("Response body: "+ body); 
Reporter.log(response.body().asString());



//RestAssured.baseURI="https://rahulshettyacademy.com";
String response = given().log().all().queryParam("key", "qaclick123").header("Content-type", "application/json")
.body(payload.Addplace()).when().post("maps/api/place/add/json")
.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();

System.out.println(response);
''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''



File file = new File("C:\\Users\\romina.milillo\\eclipse-workspace\\JavaAPI\\Json\\add.Json");
RestAssured.baseURI="https://reqres.in/api";
JSONParser json = new JSONParser();
String response = given().log().all().header("Content-type", "JSON")
.body(payload.Addplace()).when().post("maps/api/place/add/json")







