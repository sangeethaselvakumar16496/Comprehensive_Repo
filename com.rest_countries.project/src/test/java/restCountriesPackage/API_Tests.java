package restCountriesPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API_Tests {

	String validCountryFullName = "aruba";
	String invalidCountryFullName = "usa";

	@Test(priority = 1)
	public void positiveCase() {
		String url = "https://restcountries.com/v3.1/name/" + validCountryFullName + "?fullText=true";
		Response res = RestAssured.get(url);
		System.out.println("******************** Positive case ********************");
		System.out.println("Response: " + res.asString());
		int statusCode = res.getStatusCode();
		System.out.println("Status code: " + statusCode);
		System.out.println(res.getStatusLine() + "\n");
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 2)
	public void negativeCase() {
		String url = "https://restcountries.com/v3.1/name/" + invalidCountryFullName + "?fullText=true";
		Response res = RestAssured.get(url);
		System.out.println("******************** Negative case ********************");
		System.out.println("Response: " + res.asString());
		int statusCode = res.getStatusCode();
		System.out.println("Status code: " + statusCode);
		System.out.println(res.getStatusLine() + "\n");
		Assert.assertEquals(statusCode, 404);
	}

}