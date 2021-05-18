package Lesson_2.Subclasses;

public abstract class Shape implements MoveableInterface{
    protected int x,y;
    public static int shapecount;
    Shape()
    {
        shapecount++;
    }
    public void move(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    abstract public void draw();

    abstract public float area();
}
