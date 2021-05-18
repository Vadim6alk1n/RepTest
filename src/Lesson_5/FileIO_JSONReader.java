package Lesson_5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileIO_JSONReader {
    public static void main(String[] args)
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("data.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject root = (JSONObject) obj;
            System.out.println(root);
            JSONArray personList = (JSONArray) root.get("Persons");
            //personList.forEach( emp -> parsePersonObject( (JSONObject) emp ) );
            Object[] arr = personList.toArray();
            for (Object emp: arr)
            {
                parsePersonObject((JSONObject)emp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private static void parsePersonObject(JSONObject pers)
    {
        System.out.println("New Person");
        try {
            double balance = (double) pers.get("balance");
            System.out.println(balance);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        boolean is_vip = (boolean) pers.get("is_vip");
        System.out.println(is_vip);
        Long num = (Long) pers.get("num");
        System.out.println(num);
        String name = (String) pers.get("name");
        System.out.println(name);
    }

}
