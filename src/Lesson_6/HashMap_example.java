package Lesson_6;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

class MyClass
{
    MyClass(int x, String str)
    {
        this.x = x;
        this.str = str;
    }
    public int x;
    String str;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return x == myClass.x &&
                Objects.equals(str, myClass.str);
    }

    @Override
    public int hashCode() {
        if (str.length()>0)
            return x + str.charAt(0);
        else return x;
    }
    public String toString()
    {
        return new Integer(x).toString() + str;
    }
}

public class HashMap_example {
    public static void main(String[] args)
    {
        HashMap<MyClass, Integer> map
                = new HashMap<>();

        print(map);
        map.put(new MyClass(1,"a"), 10);
        map.put(new MyClass(2, "b"), 30);
        map.put(new MyClass(1,"ab"), 20);

        System.out.println("Size of map is:- "
                + map.size());

        print(map);
        MyClass key = new MyClass(1,"a");
        if (map.containsKey(key)) {
            Integer a = map.get(key);
            System.out.println("value for key "
                    + key + " is:- "
                    + a);
        }
    }

    public static void print(Map<MyClass, Integer> map)
    {
        if (map.isEmpty()) {
            System.out.println("map is empty");
        }
        else {
            Iterator<Map.Entry<MyClass, Integer>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<MyClass, Integer> pair = (Map.Entry<MyClass, Integer>) it.next();
                System.out.println(pair.getKey() + " hashcode: " + new Integer(pair.getKey().hashCode()).toString() + " = " + pair.getValue());
            }
        }
    }
}
