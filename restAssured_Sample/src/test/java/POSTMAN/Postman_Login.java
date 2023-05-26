package POSTMAN;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class Postman_Login {

    public static void main(String[] args) {
        String url = "https://demo.guru99.com/test/login.html";
        
        // Prepare the form data
        List<NameValuePair> formData = new ArrayList<>();
        formData.add(new BasicNameValuePair("email", "rostel@example.com"));
        formData.add(new BasicNameValuePair("passwd", "rostel"));

        try {
            // Create the HTTP client
            HttpClient httpClient = HttpClientBuilder.create().build();

            // Create the HTTP POST request
            HttpPost httpPost = new HttpPost(url);

            // Set the form data as the request entity
            httpPost.setEntity(new UrlEncodedFormEntity(formData));

            // Execute the request
            HttpResponse response = httpClient.execute(httpPost);

            // Get the response entity
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                // Convert the response entity to a string
                String responseBody = EntityUtils.toString(entity);
                
                // Print the response body
                System.out.println("Response:\n");
                System.out.println(responseBody);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
