package POSTMAN;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Postman_NewTours {

    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://demo.guru99.com/test/newtours/");

        try {
            // Execute the request
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            String line;
            StringBuilder responseString = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                responseString.append(line);
            }
            reader.close();

            // Display the response
            System.out.println("Response:");
            System.out.println(responseString.toString());

            // Close the HttpClient
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
