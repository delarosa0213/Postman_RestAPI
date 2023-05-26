package restAssured_Sample;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class UserRegistration {
  @Test
  public void userRegistrationSuccessful() {
    RestAssured.baseURI = "https://demoqa.com/Account/v1/User";
    RequestSpecification request = RestAssured.given();
    
    JSONObject reqParam = new JSONObject();
    reqParam.put("userName", "test_rest");
    reqParam.put("password", "Testrest@123");
    
    request.body(reqParam.toString());
    
    Response response = request.post(); // Use post() instead of put()
    ResponseBody body = response.getBody();
    
    System.out.println(response.getStatusLine());
    System.out.println(body.asString());
  }
}
