package restAssured_Sample;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SimpleTestNG {
  @Test
  public void WeatherMessageBody() {
	    RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
	    RequestSpecification httpRequest = RestAssured.given();
	    Response response = httpRequest.get();

	    ResponseBody body = response.getBody();
	    String bodyAsString = body.asString();
	    

	    System.out.println("Response Body is: " + bodyAsString);

	   

	    Assert.assertEquals(bodyAsString.contains("O'Reilly Media"), true);
	}
  @Test
  public void getValueForSpecificJsonPatH() {
	    RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
	    RequestSpecification httpRequest = RestAssured.given();
	    Response response = httpRequest.get();

	    ResponseBody body = response.getBody();
	    JsonPath jpe = response.jsonPath();
	    
	    String val = jpe.getString("[1].address.street");
	    

	    System.out.println("Adress street is : " + val);

	   

	    Assert.assertEquals(val.contains("Victor Plains"), true);
	}
}
