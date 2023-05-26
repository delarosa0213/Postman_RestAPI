package restAssured_Sample;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.List;

public class bookAssignment{

    @Test
    public void testLibraryBookAssignmentAndReturn() {

        // Step 1: Generate Token for Authorization
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();

        JSONObject authParams = new JSONObject();
        authParams.put("userName", "red");
        authParams.put("password", "Red@123");

        request.body(authParams.toJSONString());
        Response authResponse = request.post("/Account/v1/GenerateToken");

        Assert.assertEquals(authResponse.getStatusCode(), 200);

        String token = authResponse.getBody().jsonPath().getString("token");

        // Step 2: Get List of available books in the library
        request = RestAssured.given();
        request.header("Authorization", "Bearer " + token);

        Response bookListResponse = request.get("/BookStore/v1/Books");

        Assert.assertEquals(bookListResponse.getStatusCode(), 200);

        String bookId = bookListResponse.getBody().jsonPath().getString("[0].isbn");

        // Step 3: Add a book from the list to the user
        request = RestAssured.given();
        request.header("Authorization", "Bearer " + token);
        request.header("Content-Type", "application/json");

        JSONObject assignBookParams = new JSONObject();
        assignBookParams.put("isbn", bookId);
        assignBookParams.put("userId", "08139");

        request.body(assignBookParams.toJSONString());

        Response assignBookResponse = request.post("/BookStore/v1/Books");

        Assert.assertEquals(assignBookResponse.getStatusCode(), 201);

        // Step 4: Delete the added book from the list of books
        request = RestAssured.given();
        request.header("Authorization", "Bearer " + token);

        Response deleteBookResponse = request.delete("/BookStore/v1/Book/" + bookId);

        Assert.assertEquals(deleteBookResponse.getStatusCode(), 204);

        // Step 5: Confirm if the book removal happens successfully
        request = RestAssured.given();
        request.header("Authorization", "Bearer " + token);

        Response getUserResponse = request.get("/Account/v1/User/" + "08139");

        Assert.assertEquals(getUserResponse.getStatusCode(), 200);

        List<String> booksAssigned = getUserResponse.getBody().jsonPath().getList("books");

        Assert.assertFalse(booksAssigned.contains(bookId));
    }
}
