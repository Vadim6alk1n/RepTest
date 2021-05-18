package Lesson_5;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.util.StringTokenizer;
public class FileIO_JSONWriter {

        public static String NiceJSONPrint(String obj)
        {
            String spaces = "";

            String res = "";
            obj = obj.replace("[",new String(Character.toString(1) + "["));
            obj = obj.replace("]",new String(Character.toString(2) + "]"));
            obj = obj.replace("{",new String(Character.toString(3) + "{"));
            obj = obj.replace("}",new String(Character.toString(4) + "}"));
            obj = obj.replace(",",new String(Character.toString(5) + ","));

            String del = new String();
            del += Character.toString(1);
            del += Character.toString(2);
            del += Character.toString(3);
            del += Character.toString(4);
            del += Character.toString(5);
            StringTokenizer multiTokenizer = new StringTokenizer(obj, del);

            while (multiTokenizer.hasMoreTokens())
            {
                String token = multiTokenizer.nextToken();
                if (token.charAt(0)==',')
                {
                    res = res + token.charAt(0) + "\n" + spaces + token.substring(1);
                    continue;

                }
                if (token.charAt(0)==']') spaces = spaces.substring(0,spaces.length()-1);
                if (token.charAt(0)=='}') spaces = spaces.substring(0,spaces.length()-1);
                if (token.charAt(0)=='[') spaces += "\t";
                if (token.charAt(0)=='{') spaces += "\t";
                res = res + spaces + token.charAt(0) + "\n" + spaces + token.substring(1);
            }
            return res;
        }
        public static void main(String[] args)
        {
            JSONArray ja = new JSONArray();
            JSONObject obj = new JSONObject();
            JSONObject obj2 = new JSONObject();
            obj.put("name", "foo");
            obj.put("num", new Integer(100));
            obj.put("balance", new Double(1000.21));
            obj.put("is_vip", new Boolean(true));
            obj2.put("name", "foo2");
            obj2.put("num", new Integer(300));
            obj2.put("is_vip", new Boolean(false));
            ja.add(obj);
            ja.add(obj2);
            JSONObject mainObj = new JSONObject();
            mainObj.put("Persons", ja);
            System.out.println(mainObj.toJSONString());
            System.out.print(NiceJSONPrint(mainObj.toString()));
            try {
                FileWriter fw = new FileWriter("data.json");
                fw.write(NiceJSONPrint(mainObj.toString()));
                fw.flush();
                fw.close();
            } catch (Exception e)
            {
                System.out.println("Exception caught!");
            }
        }
}

