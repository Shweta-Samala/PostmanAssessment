package pages.rest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lib.rest.RestAssuredBase;

public class VerifyRegisteredProfileDetails extends RestAssuredBase {
	
	@Test(dependsOnMethods= {"pages.rest.Login.loginUiBank"})
	public void verifyRegisteredProfileDetails() {
		
		// Endpoint to verify registered profile details
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api/users/620f1ea2c380ad006e3023e5";
		
		//Initiate Request
		Response response = RestAssured.given().contentType("application/JSON")
				.header("authorization",id)
				.get();

		//Assert and print Status code
		//SoftAssert sa = new SoftAssert();
		Assert.assertEquals(response.statusCode(), 200);
		System.err.println(response.statusCode());

		//Print response
		response.prettyPrint();
	}

}
