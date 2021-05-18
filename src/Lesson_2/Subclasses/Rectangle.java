package Lesson_2.Subclasses;

public class Rectangle extends Shape{
    private int w,h;
    public void setSize(int w,int h)
    {
        this.w = w;
        this.h = h;
    }
    public int getWidth() {
        return w;
    }
    public int getHeight() {
        return h;
    }
    public void draw() {
        System.out.println("Rectangle position: (" + x + ":" + y + ")" +
                "; size: (" + w + ":" + h + ")");
    }

    public float area() {
        return w*h;
    }
}
