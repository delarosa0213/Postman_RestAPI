package restAssured_Sample;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;



public class Validation {

	public void IteratingHeaders() {
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		RequestSpecification httpRequest = RestAssured.given();
		
		
		Response response = httpRequest.get();
		
		Headers allHeaders = response.headers();
		for (Header header : allHeaders) {
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue() );
		}
	}
	
	public void GetBookHeaders() {
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.get();
		
		String contentType = response.header("Content-Type");
		
		System.out.println("Content Type value: " + contentType);
		
		String serverType = response.header("Server");
		
		System.out.println("Server value " + serverType);
	}

}
