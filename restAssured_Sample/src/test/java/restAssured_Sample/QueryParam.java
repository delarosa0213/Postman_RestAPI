package restAssured_Sample;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class QueryParam {
  @Test
  public void queryParameter() {
    RestAssured.baseURI = "https://demoqa.com/BookStore/v1";
    RequestSpecification httpRequest = RestAssured.given();
    
    Response response = httpRequest.queryParam("ISBN", "9781449325862").get("/Book");
    
    ResponseBody body = response.body();
    
    String contentType = response.contentType();
    System.out.println("Content Type: " + contentType);
    
    String rbdy = body.asString();
    System.out.println("Response Body: " + rbdy);
    
    JsonPath jpath = new JsonPath(rbdy);
    
    String title = jpath.getString("title");
    if (title != null) {
        System.out.println("The book title is - " + title);
    } else {
        System.out.println("Title not found in response.");
    }
  }
}
