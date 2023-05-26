package restAssured_Sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadJSON {

    public static void main(String[] args) {
    	System.out.println("List of Subjects: ");
        try {
            // Read JSON file into a string
            BufferedReader reader = new BufferedReader(new FileReader("utils/sample.json"));
            String jsonStr = "";
            String line = reader.readLine();
            while (line != null) {
                jsonStr += line;
                line = reader.readLine();
            }
            reader.close();
            
            // Parse JSON string into a JSON object
            JSONObject jsonObj = new JSONObject(jsonStr);
            
            // Get the Subjects array from the JSON object
            JSONArray subjectsArr = jsonObj.getJSONArray("Subjects");
            
            // Loop through the array and print each subject
            for (int i = 0; i < subjectsArr.length(); i++) {
                String subject = subjectsArr.getString(i);
                System.out.println(subject);
            }
            
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

}
