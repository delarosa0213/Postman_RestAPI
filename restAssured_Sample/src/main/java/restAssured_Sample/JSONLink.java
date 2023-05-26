package restAssured_Sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONLink {

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
            System.out.println("ResponseCode: " + responseCode);

            // Read response body
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder responseBody = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBody.append(line);
            }
            reader.close();
            System.out.println("EntireBody: " + responseBody.toString());

            // Get status line
            String statusLine = conn.getHeaderField(0);
            System.out.println("StatusLine: " + statusLine);

            // Close resources
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
