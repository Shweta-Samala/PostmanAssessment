package pages.rest;

import java.util.HashMap;

import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lib.rest.RestAssuredBase;

public class Login extends RestAssuredBase {

	@Test
	public void loginUiBank() {
		
		
		// Endpoint to login
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api/users/login";
		
		
		//Initiate Request to login
		Response response = RestAssured.given().contentType("application/JSON")
				.body("{\n" + 
						"    \"username\": \"ShwetaPulipati\",\n" + 
						"    \"password\": \"Mummy@143\"\n" + 
						"}")
				.post();

		//store response in path variable
		JsonPath path = response.jsonPath();

		//store id value in id variable for authorization purpose and print the value
		id = path.get("id");
		System.err.println(id);


		//Assert Status code
		System.err.println(response.statusCode());
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(response.getStatusCode(), "200");

		//Print response body
		response.prettyPrint();
	}
}
