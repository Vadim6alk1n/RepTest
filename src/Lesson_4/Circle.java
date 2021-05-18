package Lesson_4;

public class Circle
{
    private int x,y;
    private int r;
    void SetSize(int r) throws InvalidCircleSizeException
    {
        if (r<0) throw new InvalidCircleSizeException("Invalid circle size");
        this.r = r;
    }
    void MoveX(int x)
    {
        assert (x>0);
        this.x=x;
    }
    void MoveY(int y)
    {
        assert (y>0): "y = " + y + " : less than 0";
        this.y=y;
    }
}
