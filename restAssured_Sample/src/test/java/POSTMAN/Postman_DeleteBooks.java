package POSTMAN;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Postman_DeleteBooks {

    public static void main(String[] args) {
        try {
            // API endpoint URL with the specified ISBN
            String url = "https://demoqa.com/BookStore/v1/Books/9781449325862";

            // Create a URL object with the endpoint
            URL apiUrl = new URL(url);

            // Open a connection to the API endpoint
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

            // Set the request method to DELETE
            connection.setRequestMethod("DELETE");

            // Get the response code from the server
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Print the response
            System.out.println("Response Body:");
            System.out.println(response.toString());

            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
