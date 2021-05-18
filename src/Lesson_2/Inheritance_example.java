package Lesson_2;

import Lesson_2.Subclasses.Pixel;
import Lesson_2.Subclasses.Point;
import Lesson_2.Subclasses.Rectangle;

public class Inheritance_example {
    public static void main(String args[])
    {
        Point a = new Point(20,30);
        int z;
        //a.x = 25; //forbidden
        //z = a.y; //forbidden
        z = a.getY();
        a.move(25,a.getY());
        a.move(a.getX()-5,a.getY()+5);

        Pixel b = new Pixel(20,50); b.setColor(2);
        int bx, by, bc;
        bx = b.getX();
        by = b.getY();
        bc = b.getColor();
        Figures.drawFigure(new Rectangle());
    }
}
