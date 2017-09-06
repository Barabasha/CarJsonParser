import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CarJsonParser {
    public static void main(String[] args) throws IOException, ParseException {
        String path = "C:\\test_hillel\\cars.json";
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(path));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray arCar = (JSONArray) jsonObject.get("cars");
        JSONObject newObject = new JSONObject();
        newObject.put("model", "Dodge");
        newObject.put("age", 3);
        newObject.put("Colour", "Green");
        arCar.add(newObject);
        System.out.println(obj);

        try {
            FileWriter writer = new FileWriter(path);
            writer.write(jsonObject.toJSONString());
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
