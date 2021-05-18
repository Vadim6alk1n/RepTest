package Lesson_2;

import Lesson_2.Subclasses.Circle;
import Lesson_2.Subclasses.Rectangle;
import Lesson_2.Subclasses.Shape;

public class Figures {
    int y;
    public static void drawFigure(Shape s){
        s.draw();
    }
    public static void main(String args[]) {
        Rectangle rect;
        Circle circ;
        rect = new Rectangle();
        circ = new Circle();
        rect.move(-50,20);
        rect.setSize(20,30);
        circ.move(0,5);
        circ.setSize(5);
        drawFigure(rect);
        drawFigure(circ);
        Shape shapearr[] = new Shape[2];
        shapearr[0] = rect;
        shapearr[1] = circ;

        for (Shape s : shapearr)
        {
            System.out.println(s.area());
        }
        System.out.println(Shape.shapecount);

        Rectangle r = rect;
        r.move(10,0);
        System.out.println(r.getX());
        System.out.println(rect.getX());

        int i = 2;
        Integer i2 = 2;
        i2 = i2 * i;

        r = null;

    }

}
