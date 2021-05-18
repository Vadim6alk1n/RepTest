package Lesson_6;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList_example {
    public static void main(String[] args)
    {
        ArrayList<String> arr = new ArrayList<String>();
        String s = "String1";
        arr.add(s);
        arr.add("String2");
        arr.add("String3");
        System.out.println(arr.size());
        Iterator<String> it = arr.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

        ArrayList<String> arr2 = new ArrayList<String>();
        arr.add("String4");
        arr.add("String5");
        arr.add("String6");
//        String s2 = null;
        arr.add(null);
        arr.addAll(arr2);

        System.out.println(arr.contains("String5"));
        arr.remove("String3");
        arr.remove(s);
        arr.remove("String7");

        System.out.println(arr.get(3));
        System.out.println(arr);
    }
}
