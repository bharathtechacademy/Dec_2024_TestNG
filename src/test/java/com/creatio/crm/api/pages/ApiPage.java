package com.creatio.crm.api.pages;

import org.json.JSONObject;

public class ApiPage {
	
	public static String createRepoRequestBody(String repoName, boolean visibility) {
		JSONObject jo = new JSONObject();
		jo.put("name", repoName);
		jo.put("description", "Sample Description");
		jo.put("private", visibility);
		return jo.toString();
	}
	
	public static String updateRepoRequestBody(boolean visibility) {
		JSONObject jo = new JSONObject();
		jo.put("private", visibility);
		return jo.toString();
	}

}
