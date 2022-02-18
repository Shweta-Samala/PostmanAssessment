package pages.rest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lib.rest.RestAssuredBase;

public class CreateNewAccount extends RestAssuredBase {
	
	
	@Test(dependsOnMethods= {"pages.rest.Login.loginUiBank"})
	public void createNewAccount() {
		
		// Endpoint to create new account
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api/accounts";
		
		//Initiate post request to create new account
		Response response = RestAssured.given().contentType("application/JSON")
				.header("authorization",id)
				.body("{\n" + 
						"    \"friendlyName\": \"Pallavi\",\n" + 
						"    \"type\": \"savings\",\n" + 
						"    \"userId\": \"620f1ea2c380ad006e3023e5\",\n" + 
						"    \"balance\": 100,\n" + 
						"    \"accountNumber\": 77306064\n" + 
						"}")
				.post();

		//Assert and print Status code
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(response.getStatusCode(), "200");
		System.err.println(response.statusCode());

		//Print response
		response.prettyPrint();

	}
}
