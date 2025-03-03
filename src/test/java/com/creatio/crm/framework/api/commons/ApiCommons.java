package com.creatio.crm.framework.api.commons;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.creatio.crm.framework.reports.Reports;
import com.creatio.crm.framework.utilities.PropUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiCommons extends Reports {

	public static Response response = null;
	public static Properties prop = PropUtil.readData("Config.properties");

	// print message in report
	public static void log(String status, String message) {
		if (status.equalsIgnoreCase("pass")) {
			Reports.logger.pass(message);
		} else if (status.equalsIgnoreCase("fail")) {
			Reports.logger.fail(message);
		} else if (status.equalsIgnoreCase("warning")) {
			Reports.logger.warning(message);
		} else if (status.equalsIgnoreCase("info")) {
			Reports.logger.info(message);
		}
	}

	// Method to get the response and store response
	public static void getResponse(String requestType, String endPoint, String requestBody) {
		RestAssured.baseURI = prop.getProperty("api_base_url");
		String token = prop.getProperty("api_token");
		switch (requestType) {

		case "POST":
			response = given().headers("Authorization", token).body(requestBody).when().post(endPoint);
			break;
		case "PUT":
			response = given().headers("Authorization", token).body(requestBody).when().put(endPoint);
			break;
		case "PATCH":
			response = given().headers("Authorization", token).body(requestBody).when().patch(endPoint);
			break;
		default:
			Assert.fail("Invalid request Type : " + requestType);
		}

	}
	
	// Method to get the response and store response
		public static void getResponse(String requestType, String endPoint) {
			RestAssured.baseURI = prop.getProperty("api_base_url");
			String token = prop.getProperty("api_token");
			switch (requestType) {

			case "GET":
				response = given().headers("Authorization", token).when().get(endPoint);
				break;
			case "DELETE":
				response = given().headers("Authorization", token).when().delete(endPoint);
				break;
			default:
				Assert.fail("Invalid request Type : " + requestType);
			}

		}

	// Verify status code
	public static void verifyStatusCode(int expStatusCode) {
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expStatusCode);
		log("pass", "Status code is matching , actual status code is " + actualStatusCode);
	}

	// Verify status message
	public static void verifyStatusMessage(String expMessage) {
		String actualStatus = response.getStatusLine();
		Assert.assertTrue(actualStatus.contains(expMessage));
		log("pass", "Status message is matching , actual status is " + actualStatus);
	}

	// Verify Response time
	public static void verifyResponseTime(long expResponseTime) {
		long actualResponseTime = response.getTimeIn(TimeUnit.SECONDS);
		Assert.assertTrue(actualResponseTime <= expResponseTime);
		log("pass", "Response Time is as expected , actual response time is " + actualResponseTime);
	}
	
//	//verify response body
	public static void verifyResponseBody(String key, String expValue) {
		String actualValue = response.getBody().jsonPath().getString(key);
		Assert.assertEquals(actualValue, expValue);
		log("pass", "Response Body is as expected , actual response body value is " + actualValue + "for the Key "+key);
	}
	
	//verify response is having specific key
	public static void verifyResponseKey(String key) {
		String actualKey = response.getBody().jsonPath().get(key);
		Assert.assertNotNull(actualKey);
		log("pass","Response Body is as expected ,"+key+" Key is Present  with in the response");
	}

	//verify response body
	public static void verifyResponseHeaders(String key, String expValue) {
		String actualValue = response.getHeader(key);
		Assert.assertEquals(actualValue, expValue);
		log("pass", "Response Headers are as expected , actual response header value is " + actualValue + "for the Key "+key);
	}
	

	

}
