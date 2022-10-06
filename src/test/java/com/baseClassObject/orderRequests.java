package com.baseClassObject;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class orderRequests {
	paypageOperations po= new paypageOperations();
	String sessionID;
	DocumentContext jsonReq;
	int invoiceNo;
	
	@Test(priority = 1)
	public void orderStatus() throws InterruptedException, FileNotFoundException, IOException, ParseException{
		sessionID=po.submitPage();		
		JSONParser parser = new JSONParser();		
		Object obj = parser.parse(new FileReader(".\\jsonRequest\\orderRequest.json"));
		String req=obj.toString();
		Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider()).mappingProvider(new JacksonMappingProvider()).build();
		jsonReq = com.jayway.jsonpath.JsonPath.using(configuration).parse((req));				
		jsonReq.set("OrderRequest.SessionID", sessionID);
		jsonReq.set("OrderRequest.OrderTransType", "06").jsonString();
		System.out.println("Order status request:-"+jsonReq.jsonString());
		
		Response postresp= given()
				.auth().none()
				.header("Content-Type","application/json")
				.contentType(ContentType.JSON)
				.when()
				.body(jsonReq.jsonString())
				.post("https://uatds42.auruspay.com/aurus-adsdk-web-service/auruspay/adsdk/orderrequest");

		System.out.println("Order Status resp:-:"+postresp.asString());			
		JsonPath js= postresp.jsonPath();
		String statusCode=js.get("OrderResponse.StatusCode");
		Assert.assertEquals(statusCode, "11");
		Assert.assertEquals(statusCode, "11");
	}
	
	@Test(priority = 1, dependsOnMethods={"orderStatus"})
	public void orderConfirm() {			
		Random random = new Random();
		invoiceNo=random.nextInt(10000000);
		jsonReq.set("OrderRequest.OrderTransType", "01").jsonString();
		jsonReq.set("OrderRequest.InvoiceNumber",""+invoiceNo).jsonString();
		System.out.println("Order Confirm request:-"+jsonReq.jsonString());
		
		Response postresp= given()
				.auth().none()
				.header("Content-Type","application/json")
				.contentType(ContentType.JSON)
				.when()
				.body(jsonReq.jsonString())
				.post("https://uatds42.auruspay.com/aurus-adsdk-web-service/auruspay/adsdk/orderrequest");

		System.out.println("Order Confirm resp:-"+postresp.asString());			
		JsonPath js= postresp.jsonPath();		
		Assert.assertEquals(js.get("OrderResponse.StatusCode"), "21");
		Assert.assertEquals(js.get("OrderResponse.ResponseCode"), "00000");
		Assert.assertEquals(js.get("OrderResponse.ResponseText"), "APPROVAL");
		
	}
	
	@Test(priority = 3)
	public void orderLookup() {		
		jsonReq.set("OrderRequest.OrderTransType", "06").jsonString();
		jsonReq.set("OrderRequest.SubTransType", "1").jsonString();
		System.out.println("Order Lookup request:-"+jsonReq.jsonString());
		
		Response postresp= given()
				.auth().none()
				.header("Content-Type","application/json")
				.contentType(ContentType.JSON)
				.when()
				.body(jsonReq.jsonString())
				.post("https://uatds42.auruspay.com/aurus-adsdk-web-service/auruspay/adsdk/orderrequest");

		System.out.println("Order Lookup resp:-"+postresp.asString());			
		JsonPath js= postresp.jsonPath();
		Assert.assertEquals(js.get("OrderResponse.StatusCode"), "11");
		Assert.assertEquals(js.get("OrderResponse.ResponseCode"), "00000");
		Assert.assertEquals(js.get("OrderResponse.ResponseText"), "APPROVAL");		
	}

	@Test(priority = 4)
	public void orderUpdate() {		
		jsonReq.set("OrderRequest.OrderTransType", "03").jsonString();
		jsonReq.set("OrderRequest.SubTransType", "").jsonString();
		jsonReq.set("OrderRequest.TransAmountDetails.TransTotalAmount", "10.00").jsonString();
		System.out.println("Order Update request:-"+jsonReq.jsonString());
		
		Response postresp= given()
				.auth().none()
				.header("Content-Type","application/json")
				.contentType(ContentType.JSON)
				.when()
				.body(jsonReq.jsonString())
				.post("https://uatds42.auruspay.com/aurus-adsdk-web-service/auruspay/adsdk/orderrequest");

		System.out.println("Order Update resp:-"+postresp.asString());			
		JsonPath js= postresp.jsonPath();		
		Assert.assertEquals(js.get("OrderResponse.ResponseCode"), "00000");
		Assert.assertEquals(js.get("OrderResponse.ResponseText"), "APPROVAL");		
	}
	
	@Test(priority = 5,dependsOnMethods = "orderUpdate")
	public void orderProcess() {		
		jsonReq.set("OrderRequest.OrderTransType", "02").jsonString();
		jsonReq.set("OrderRequest.SubTransType", "").jsonString();		
		System.out.println("Order Process request:-"+jsonReq.jsonString());
		
		Response postresp= given()
				.auth().none()
				.header("Content-Type","application/json")
				.contentType(ContentType.JSON)
				.when()
				.body(jsonReq.jsonString())
				.post("https://uatds42.auruspay.com/aurus-adsdk-web-service/auruspay/adsdk/orderrequest");

		System.out.println("Order Process resp:-"+postresp.asString());			
		JsonPath js= postresp.jsonPath();		
		Assert.assertEquals(js.get("OrderResponse.ResponseCode"), "00000");
		Assert.assertEquals(js.get("OrderResponse.ResponseText"), "APPROVAL");		
	}
	
	@Test(priority = 6)
	public void orderRefund() {		
		jsonReq.set("OrderRequest.OrderTransType", "04").jsonString();			
		System.out.println("Order Refund request:-"+jsonReq.jsonString());
		
		Response postresp= given()
				.auth().none()
				.header("Content-Type","application/json")
				.contentType(ContentType.JSON)
				.when()
				.body(jsonReq.jsonString())
				.post("https://uatds42.auruspay.com/aurus-adsdk-web-service/auruspay/adsdk/orderrequest");

		System.out.println("Order Refund resp:-"+postresp.asString());			
		JsonPath js= postresp.jsonPath();
		Assert.assertEquals(js.get("OrderResponse.ResponseCode"), "00000");
		Assert.assertEquals(js.get("OrderResponse.ResponseText"), "APPROVAL");
	}
}
