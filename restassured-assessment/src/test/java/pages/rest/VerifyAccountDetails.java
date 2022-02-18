package pages.rest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lib.rest.RestAssuredBase;

public class VerifyAccountDetails extends RestAssuredBase {
	@Test(dependsOnMethods= {"pages.rest.Login.loginUiBank"})
	public void verifyAccountsDetails() {

		// Endpoint to verify account details
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api/accounts";

		//Initiate Get Request to retrieve account details
		Response response = RestAssured.given().contentType("application/JSON")
				.header("authorization",id)
				.queryParam("filter[where][userId]", "620f1ea2c380ad006e3023e5")
				.get();

		//Assert and print Status code
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(response.getStatusCode(), "200");
		System.err.println(response.statusCode());

		//Print response
		response.prettyPrint();
	}
}
