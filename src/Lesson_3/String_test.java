package Lesson_3;

public class String_test {

    public static void main(String[] args)
    {
        String str1 = "string";
        String str2 = "string";
        String str3 = new String("string");
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));

        System.out.println(str1==str3);
        System.out.println(str1.equals(str3));

        StringBuffer sbuf = new StringBuffer("abc");
        sbuf.append("def");
        System.out.println("sb = " + sbuf);
        StringBuilder sb = new StringBuilder("abc");
        sb.append("def").reverse().insert(3, "---");
        System.out.println( sb );

        String x = "abc";
        String y = x.concat("def").toUpperCase().replace('C','x');//chained methods
        System.out.println("y = " + y); // result is "y = ABxDEF
        System.out.println(x);
    }
}
