package Lesson_4;

public class Exception_example2 {
    public static void main(String[] args)
    {
        Circle c = new Circle();
        try {
            c.SetSize(-5);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        c.MoveX(5);
       // c.MoveX(-5);
        c.MoveY(-5);
    }

}
