package restAssuredPackage;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API_Tests {

	private ExcelConfig xl;
	private String countryName;

	@BeforeSuite
	public void configExcel() {
		String fileName = "API_TestData.xlsx";
		String sheetName = "TestData";
		xl = new ExcelConfig(fileName);
		xl.getXlSheet(sheetName);
	}

	@BeforeTest
	public void setBaseURI() {
		RestAssured.baseURI = "https://restcountries.com";
	}

	@AfterSuite
	public void closeXlConnections() {
		xl.closeXl();
	}

	@Test(priority = 1)
	public void germanyTest() {
		for (int i = 1; i <= xl.getRowNum(); i++) {
			countryName = xl.getCellData("Country 1", i);
		}
		System.out.println("******************** Translation Name {Germany} ********************");
		Response response = given().pathParam("translation", countryName).get("/v3.1/translation/{translation}").then()
				.extract().response();
		int statusCode = response.statusCode();
		System.out.println("Status code: " + statusCode);
		System.out.println("Translation name: " + countryName);
		Assert.assertEquals(statusCode, 200, "Status code is Invalid!");
	}

	@Test(priority = 2)
	public void alemaniaTest() {
		for (int i = 1; i <= xl.getRowNum(); i++) {
			countryName = xl.getCellData("Country 2", i);
		}
		System.out.println("\n******************** Translation Name {Alemania} ********************");
		Response response = given().pathParam("translation", countryName).get("/v3.1/translation/{translation}").then()
				.extract().response();
		int statusCode = response.statusCode();
		System.out.println("Status code: " + statusCode);
		System.out.println("Translation name: " + countryName);
		Assert.assertEquals(statusCode, 200, "Status code is Invalid!");
	}

	@Test(priority = 3)
	public void saksamaaTest() {
		for (int i = 1; i <= xl.getRowNum(); i++) {
			countryName = xl.getCellData("Country 3", i);
		}
		System.out.println("\n******************** Translation Name {Saksamaa} ********************");
		Response response = given().pathParam("translation", countryName).get("/v3.1/translation/{translation}").then()
				.extract().response();
		int statusCode = response.statusCode();
		System.out.println("Status code: " + statusCode);
		System.out.println("Translation name: " + countryName + "\n");
		Assert.assertEquals(statusCode, 200, "Status code is Invalid!");
	}

}