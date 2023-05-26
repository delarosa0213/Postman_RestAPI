package restAssured_Sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Link {

    public static void main(String[] args) {
        try {
            // Create URL object for API endpoint
            URL url = new URL("https://jsonplaceholder.typicode.com/users");

            // Create HttpURLConnection object
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method to GET
            conn.setRequestMethod("GET");

            // Get response code
            int responseCode = conn.getResponseCode();
            System.out.println("Response code: " + responseCode);

            // Read response body
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder responseBody = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBody.append(line);
            }
            reader.close();
            System.out.println("Response body: " + responseBody.toString());

            // Get status line
            String statusLine = conn.getHeaderField(0);
            System.out.println("Status line: " + statusLine);

            // Close resources
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

