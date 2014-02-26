package com.qait.automation.stik.actionfixtures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Reporter;

public class FacebookAppFixture extends BaseFixture{
	public String knewDealAppId = "192344528646";
	public String knewDealAccessToken = "192344528646|zhE7_sG8zg009QDYCngvUSCYSqg";
	String userId = null;
	
	public String smallBusinessAppId = "154407880175";
	public String smallBusinessAccessToken = "154407880175|oEym9AoDNTGOHemtX9JWmcnUxMg";
	
	
	public String createUserOnFacebook(String app, String userName){
		//https://graph.facebook.com/<<AppID>>/accounts/test-users?installed=true&name=<<UserName>>&locale=en_US&permissions=read_stream&method=post&access_token=<<AccessToken>>
		//https://graph.facebook.com/oauth/access_token?grant_type=client_credentials&client_id=192344528646&client_secret=19d6ad33d73f7c985fdc7975095c9db1
		String url = null;
		if(app.equalsIgnoreCase("knewdeal")){
			url = "https://graph.facebook.com/appId/accounts/test-users?installed=true&name=UserName&locale=en_US&permissions=read_stream&method=post&access_token=accessToken";
			url = url.replaceAll("appId", knewDealAppId);
			url = url.replaceAll("UserName",userName);
			url = url.replaceAll("accessToken", knewDealAccessToken);
		}else if(app.equalsIgnoreCase("Small Business")){
			url = "https://graph.facebook.com/appId/accounts/test-users?installed=true&name=UserName&locale=en_US&permissions=read_stream&method=post&access_token=accessToken";
			url = url.replaceAll("appId", smallBusinessAppId);
			url = url.replaceAll("UserName",userName);
			url = url.replaceAll("accessToken", smallBusinessAccessToken);
		}
		String userNamePassword = getUserNamePassword(getResponse(url));
		Reporter.log("Email & Password: "+userNamePassword);
		System.out.println("Email & Password: "+userNamePassword);
		return userNamePassword;
	}
	
	public String getResponse(String link) {
		HttpURLConnection urlConnection = null;

		try {
			
			URL url = new URL(link);
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setConnectTimeout(30000); 
			urlConnection.setReadTimeout(30000); 
			urlConnection.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
		    String response = in.readLine();
		    in.close();
		    System.out.println(response);
		    return response;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (urlConnection != null) {
				urlConnection.disconnect();
			}
		}
	}
	
	public String getUserNamePassword(String response){
		String userNamePassword = get_value(response,"email"); 
	    userNamePassword = userNamePassword + ";" + get_value(response,"password");
	    userId = get_value(response, "id");
		return userNamePassword;
	}
	
	public String get_value(String response, String key){
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(response);
			JSONObject jsonObject = (JSONObject) obj;
			String email = (String) jsonObject.get(key);
			return email;
		}catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public boolean deleteUserOnFacebook(){
		//https://graph.facebook.com/UserID?method=delete&access_token=App_AccessToken
		System.out.println("Inside delete method....");
		if(userId==null) return true;
		
		if(driver.getCurrentUrl().toLowerCase().contains("knewbies")){
			String link = "https://graph.facebook.com/"+userId+"?method=delete&access_token="+smallBusinessAccessToken;
			return Boolean.valueOf(getResponse(link));
		}else if(driver.getCurrentUrl().toLowerCase().contains("knewdeal")){
			String link = "https://graph.facebook.com/"+userId+"?method=delete&access_token="+knewDealAccessToken;
			return Boolean.valueOf(getResponse(link));
		}
		return false;
	}
}
