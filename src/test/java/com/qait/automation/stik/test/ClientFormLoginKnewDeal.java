package com.qait.automation.stik.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class ClientFormLoginKnewDeal {
	static String redirectUrl;

	public static void main(String[] args) throws Exception {

		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpContext HTTP_CONTEXT = new BasicHttpContext();
		String userAgent = "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.110 Safari/537.36";
		HTTP_CONTEXT.setAttribute(CoreProtocolPNames.USER_AGENT, userAgent);
		HTTP_CONTEXT.setAttribute(CoreProtocolPNames.PROTOCOL_VERSION,	HttpVersion.HTTP_1_1);
		String url = "https://www.facebook.com/login.php?skip_api_login=1&api_key=192344528646&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fdialog%2Foauth%3Fredirect_uri%3Dhttp%253A%252F%252Fstatic.ak.facebook.com%252Fconnect%252Fxd_arbiter.php%253Fversion%253D25%2523cb%253Df1e77268de29326%2526origin%253Dhttp%25253A%25252F%25252Fwww.knewdeal.com%25252Ff48ce2bff7431%2526domain%253Dwww.knewdeal.com%2526relation%253Dopener%2526frame%253Df26822cf9cc3cac%26display%3Dpopup%26scope%3Demail%252Cuser_work_history%252Cread_friendlists%252Cfriends_education_history%252Cfriends_work_history%26response_type%3Dtoken%252Csigned_request%26domain%3Dwww.knewdeal.com%26client_id%3D192344528646%26ret%3Dlogin%26sdk%3Djoey&cancel_uri=http%3A%2F%2Fstatic.ak.facebook.com%2Fconnect%2Fxd_arbiter.php%3Fversion%3D25%23cb%3Df1e77268de29326%26origin%3Dhttp%253A%252F%252Fwww.knewdeal.com%252Ff48ce2bff7431%26domain%3Dwww.knewdeal.com%26relation%3Dopener%26frame%3Df26822cf9cc3cac%26error%3Daccess_denied%26error_code%3D200%26error_description%3DPermissions%2Berror%26error_reason%3Duser_denied%26e2e%3D%257B%257D&display=popup";
		HttpGet httpGetRequest;
		HttpResponse response;
		HttpEntity entity;
		HttpPost httpPostRequest;
		
		try {
			
//			/******** GET request using httpClient ***********/
//			httpGetRequest = new HttpGet("http://www.knewdeal.com");
//			httpGetRequest.addHeader("accept-language", "en-US,en;q=0.8");
//			httpGetRequest.addHeader("host", "www.knewdeal.com");
//			httpGetRequest.addHeader("user-agent","Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.110 Safari/537.36");
//			httpGetRequest.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//			httpGetRequest.addHeader("cache-control", "max-age=0");
//			httpGetRequest.addHeader("Referer", "http://www.knewdeal.com/");
//			httpGetRequest.addHeader("__CT_Data", "gpv=1");
//
//			response = httpclient.execute(httpGetRequest,HTTP_CONTEXT);
//			Thread.sleep(5000);
//			entity = response.getEntity();
//
//			System.out.println("GET request using Knewdeal: "+ response.getStatusLine());
//			print_Headers(response);
//			// print_Contents(entity);
//			EntityUtils.consume(entity);
//			print_Cookies(httpclient);
//
//			System.out.println("\n**************************************************************************************");
//
//			/******** GET request using httpClient ***********/
//			httpGetRequest = new HttpGet("http://www.snapengage.com/snapabug/ServiceGetConfig?w=804c510f-51bd-4dc0-8937-fd9f667903f8&p=1");
//			httpGetRequest.addHeader("accept-language", "en-US,en;q=0.8");
//			httpGetRequest.addHeader("host", "www.snapengage.com");
//			httpGetRequest.addHeader("user-agent","Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.110 Safari/537.36");
//			httpGetRequest.addHeader("accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//			httpGetRequest.addHeader("cache-control", "max-age=0");
//			httpGetRequest.addHeader("Referer", "http://www.knewdeal.com/");
//
//			response = httpclient.execute(httpGetRequest, HTTP_CONTEXT);
//			entity = response.getEntity();
//
//			System.out.println("GET request using snapengage: "+ response.getStatusLine());
//			print_Headers(response);
//			// print_Contents(entity);
//			EntityUtils.consume(entity);
//			print_Cookies(httpclient);
//
//			System.out.println("\n**************************************************************************************");

			/******** GET request using httpClient ***********/
			httpGetRequest = new HttpGet("https://www.facebook.com/dialog/oauth?client_id=192344528646&redirect_uri=http://www.knewdeal.com");
			httpGetRequest.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			httpGetRequest.addHeader("accept-language", "en-US,en;q=0.8");
			httpGetRequest.addHeader("user-agent","Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.110 Safari/537.36");
			httpGetRequest.addHeader("Connection","keep-alive");
			httpGetRequest.addHeader("Host", "www.facebook.com");

			response = httpclient.execute(httpGetRequest);
			Thread.sleep(5000);
			entity = response.getEntity();

			System.out.println("GET request using facebook: "+ response.getStatusLine());
			print_Headers(response);
//			print_Contents(entity);
			EntityUtils.consume(entity);
			print_Cookies(httpclient);
			if (response.getStatusLine().getStatusCode() == 302) {
				get_redirectURL(response);
			}
			

			System.out.println("\n**************************************************************************************");

			/************* Post request using httpClient ****************/
			httpPostRequest = new HttpPost("https://www.facebook.com/dialog/oauth?client_id=192344528646&redirect_uri=http://www.knewdeal.com");
			httpGetRequest.addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			httpGetRequest.addHeader("accept-language", "en-US,en;q=0.8");
			httpGetRequest.addHeader("user-agent","Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.110 Safari/537.36");
			httpGetRequest.addHeader("Connection","keep-alive");
			httpGetRequest.addHeader("Host", "www.facebook.com");;

			List<NameValuePair> nvp = new ArrayList<NameValuePair>();
			nvp.add(new BasicNameValuePair("email",	"mayank.joshi@qainfotech.net"));
			nvp.add(new BasicNameValuePair("pass", "123mayank"));

			httpPostRequest.setEntity(new UrlEncodedFormEntity(nvp));

			response = httpclient.execute(httpPostRequest, HTTP_CONTEXT);
			entity = response.getEntity();

			System.out.println("Post request using Facebook.com: "	+ response.getStatusLine());
			print_Headers(response);
			if (entity != null) {
				entity.consumeContent();
			}

			EntityUtils.consume(entity);

			print_Cookies(httpclient);
			System.out.println("Status code after POST: "+ response.getStatusLine().getStatusCode());

			if (response.getStatusLine().getStatusCode() == 302) {
				get_redirectURL(response);
			}

			System.out.println("\n**************************************************************************************");
//
//			
//			
//			/************ GET request using httpClient Knewdeal Index Page **************/
//			httpGetRequest = new HttpGet("http://www.knewdeal.com");
//			httpGetRequest.addHeader("accept-language", "en-US,en;q=0.8");
////			httpGetRequest.addHeader("host", "www.facebook.com");
//			httpGetRequest.addHeader("user-agent","Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.110 Safari/537.36");
//			httpGetRequest.addHeader("accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//			httpGetRequest.addHeader("cache-control", "max-age=0");
//			//httpGetRequest.addHeader("Referer", "http://www.knewdeal.com/");
//
//			response = httpclient.execute(httpGetRequest, HTTP_CONTEXT);
//			entity = response.getEntity();
//
//			System.out.println("GET request using Index Page: "	+ response.getStatusLine());
//
//			/* Store values of cookies in temp hashmap */
//			System.out.println("GET homepage cookies:");
//
//			System.out.println("GET request using Knewdeal: "+ response.getStatusLine());
//			print_Headers(response);
//			print_Contents(entity);
//			EntityUtils.consume(entity);
//			print_Cookies(httpclient);

		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}

	// Printing response headers...
	public static void print_Headers(HttpResponse response) {
		System.out.println("Printing Response Headers.....");
		Header[] headers = response.getAllHeaders();
		System.out.println("Header Length: " + headers.length);
		for (int i = 0; i < headers.length; i++) {
			System.out.println("Header: " + headers[i]);
		}
	}

	// Printing contents of Page
	public static void print_Contents(HttpEntity entity) {
		System.out.println("Printing Contents.....");
		try {
			System.out.println(EntityUtils.toString(entity));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Printing cookies
	public static void print_Cookies(DefaultHttpClient httpclient) {
		System.out.println("Printing Cookies.....");
		List<Cookie> cookies = httpclient.getCookieStore().getCookies();
		if (cookies.isEmpty()) {
			System.out.println("None");
		} else {
			for (int i = 0; i < cookies.size(); i++) {
				System.out.println(cookies.get(i).getName() + ": "	+ cookies.get(i).getValue());
			}
		}
	}

	public static void get_redirectURL(HttpResponse response) {
		Header[] headers = response.getAllHeaders();
		Header locationHeader = response.getFirstHeader("Location");
		if (locationHeader != null) {
			redirectUrl = locationHeader.getValue();
			System.out.println("Redirect Location: " + redirectUrl);
		} else {
			System.out.println("Warning: Got no redirect location.");
		}
	}
}
