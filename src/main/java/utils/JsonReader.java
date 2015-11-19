package utils;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JsonReader {

    public String readJsonFile(String node, String tag, String filePath) {
        JSONParser parser = new JSONParser();
        JSONObject son = new JSONObject();
        String value = "";
        try {
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
            son = (JSONObject) jsonObject.get(node);
            value = (String) son.get(tag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

}

