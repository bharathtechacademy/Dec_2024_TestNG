package com.creatio.crm.api.tests;

import org.testng.annotations.Test;

import com.creatio.crm.api.pages.ApiPage;
import com.creatio.crm.framework.api.commons.ApiCommons;

public class ApiTest extends ApiCommons{
	
	String repoName = "SampleRepoFromRestAssured";
	
	@Test(priority=1)
	public void verifyCreateRepositoryRequestWithValidUser() {
		getResponse("POST", "/user/repos", ApiPage.createRepoRequestBody(repoName, true));
		verifyStatusCode(201);
		verifyStatusMessage("Created");
		verifyResponseTime(2);
		verifyResponseBody("name",repoName);
		verifyResponseBody("private","true");
	}
	
	@Test(priority=2)
	public void verifyUpdateRepositoryRequestWithValidUser() {
		getResponse("PATCH", "/repos/bharathtechacademy5/"+repoName, ApiPage.updateRepoRequestBody(false));
		verifyStatusCode(200);
		verifyStatusMessage("OK");
		verifyResponseTime(2);
		verifyResponseBody("name",repoName);
		verifyResponseBody("private","false");
	}
	
	@Test(priority=3)
	public void verifyGetRepositoryRequestWithValidUser() {
		getResponse("GET", "/repos/bharathtechacademy5/"+repoName);
		verifyStatusCode(200);
		verifyStatusMessage("OK");
		verifyResponseTime(2);
		verifyResponseBody("name",repoName);
		verifyResponseBody("private","false");
	}
	
	@Test(priority=4)
	public void verifyDeleteRepositoryRequestWithValidUser() {
		getResponse("DELETE", "/repos/bharathtechacademy5/"+repoName);
		verifyStatusCode(204);
		verifyStatusMessage("No Content");
		verifyResponseTime(2);
	}

}
