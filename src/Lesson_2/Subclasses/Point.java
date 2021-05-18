package Lesson_2.Subclasses;

public class Point implements MoveableInterface{
    protected int x,y;

    Point()
    {
        x=0;
        y=0;
    }

    public Point(int x0, int y0) {
        x = x0;
        y = y0;
    }
    public void move(int x1,int y1) {
        x = x1;
        y = y1;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean equals(Point p)
    {
        return x<p.x || y<p.y;
    }
}
