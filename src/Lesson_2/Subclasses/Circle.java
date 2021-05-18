package Lesson_2.Subclasses;

public class Circle extends Shape{
    private int r;
    public void setSize(int r)
    {
        this.r =r;
    }
    public int getSize() {
        return r;
    }
    public void draw() {
        System.out.println("Circle position: (" + x + ":" + y + ")" +
                "; size: " + r);
    }

    public float area() {
        return r*r*3.14f;
    }
}
