package Lesson_3;

public class SubCircle extends Circle {
    double x;
    double y;
    public SubCircle()
    {
         super();
    }
    public SubCircle(double r)
    {
        super(r);
    }
    //public void Print(){}    // Print is final method, so its can't be rewritten any more (no Polymorphism further)
}
