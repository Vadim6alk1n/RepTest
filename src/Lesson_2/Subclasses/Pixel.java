package Lesson_2.Subclasses;

public class Pixel extends Point {
    private int color;
    public Pixel() {
        super();
        color = 0;
    }
    public Pixel(int x, int y){
        super(x,y);
        color = 0;
    }
    public void setColor(int c) {
        color = c;
    }
    public int getColor() {
        return color;
    }
}