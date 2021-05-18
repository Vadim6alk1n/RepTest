package Lesson_3;

public class Static_test {
    int x=0;
    static int y=0;
    public static void main(String [] args)
    {
        Circle c;
        //c = new Circle();
        c = new Circle(5);
        c = new Circle(10);
        c.Print();
        Circle e;
        e = new Circle(5);
        System.out.println(c.PI);
        System.out.println(Circle.PI);
        System.out.println(Circle.circleCount);
        System.out.println(Circle.GetArea(5));
        //x=5;   in static context we have no access to non-static members out of this scope
        y=5;
    }
}
