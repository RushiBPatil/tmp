package com.baseClassObject;
import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matcher.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.stream.IntStream;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class paymentPageRequest {
	@Test
	public String payPageURL() throws FileNotFoundException, IOException, ParseException{		
		JSONParser parser = new JSONParser();		
		Object obj = parser.parse(new FileReader(".\\jsonRequest\\transRequest.json"));
		String req=obj.toString();
		Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider()).mappingProvider(new JacksonMappingProvider()).build();
		DocumentContext json = com.jayway.jsonpath.JsonPath.using(configuration).parse((req));
		String referenceNumberPath = "TransRequest.ReferenceNumber";
		Random random = new Random();
		int newRefNo=random.nextInt(10000000);
		System.out.println("new reference no after random-"+newRefNo);
		System.out.println("updated values is"+(json.set(referenceNumberPath, ""+newRefNo).jsonString()));
		
		System.out.println("after update json printing:---"+json.jsonString());
		Properties prop= new Properties();
		InputStream is= new FileInputStream(".//src/test/java/com/baseClassObject/config.properties");
		prop.load(is);
		Response postresp= given()
				.auth().none()
				.header("Content-Type","application/json")
				.contentType(ContentType.JSON)
				.when()
				.body(json.jsonString())
				.post(prop.getProperty("sdkTransURL"));

		System.out.println("post resp is:"+postresp.asString());			
		JsonPath js= postresp.jsonPath();
		
		String payPageUrl=js.get("TransResponse.TransDetailsData.TransDetailData.PaypageUrl");
		String sessionID =js.get("TransResponse.TransDetailsData.TransDetailData.SessionId");
		System.out.println("Paypage URL is: "+payPageUrl+"\n"+ "Session id is "+sessionID);
		return payPageUrl;
	}

};
