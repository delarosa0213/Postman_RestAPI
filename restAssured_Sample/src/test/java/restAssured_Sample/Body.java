package restAssured_Sample;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Body {

	
	public void WeatherMessageBody() {
	    RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
	    RequestSpecification httpRequest = RestAssured.given();
	    Response response = httpRequest.get();

	    ResponseBody body = response.getBody();
	    String bodyAsString = body.asString();
	    

	    System.out.println("Response Body is: " + bodyAsString);

	   

	    Assert.assertEquals(bodyAsString.contains("O'Reilly Media"), true);
	}

	public static void main(String[] args) {
	    Body body = new Body();
	    body.WeatherMessageBody();
	}


}
