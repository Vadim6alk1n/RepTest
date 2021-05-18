package Lesson_16;

public class MyApp {
    public static void main(String[] args)
    {
        System.out.println("MyApp adds int arguments and prints sum");
        int sum = 0;
        for (var str : args)
        {
            try
            {
                int i = Integer.parseInt(str);
                sum+=i;
            } catch (Exception e)
            {

            }
        }
        System.out.println(sum);
    }
}
