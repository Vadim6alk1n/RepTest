package Lesson_3;

public class Circle {
    double r;
    public static final double PI=3.14;
    public static int circleCount;
    //Initialization of class members
    {
       r=0;
       //PI = 3.14;    PI is constant(final)
       //circleCount=0;
    }
    protected Circle()
    {
        circleCount++;
    }
    public Circle(double r)
    {
        this();
        this.r = r;
    }
    public double GetArea()
    {
        return GetArea(r);
    }
    public static double GetArea(double r)
    {
        return r*r*PI;
    }
    public final void Print()
    {
        System.out.println("R = " + r + " S = " + GetArea());
    }
}
