package Lesson_7;

import java.util.ArrayList;
import java.util.List;

interface Printable
{
    public void print();
}

class Parent
{
    Parent(int v)
    {
        value = v;
    }
    int value;
}
class ChildPrintable extends Parent implements Printable
{
    ChildPrintable(int v)
    {
        super(v);
    }
    @Override
    public void print()
    {
        System.out.println(value);
    }
}

class MyPoint implements Printable
{
    MyPoint(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    @Override
    public void print() {
        System.out.println(x + ";" + y);
    }
    int x;
    int y;
}

class Persons
{
    public void print(List<? extends Printable> l)
    {
        for (Printable i : l)
        {
            i.print();
        }
    }
}


public class WildCard_example {

    public static void main(String[] args)
    {
        List<ChildPrintable> list = new ArrayList<ChildPrintable>();
        list.add(new ChildPrintable(1));
        list.add(new ChildPrintable(2));
        list.add(new ChildPrintable(3));
        Persons p = new Persons();
        p.print(list);
        List<MyPoint> pointlist = new ArrayList<MyPoint>();
        pointlist.add(new MyPoint(1,1));
        pointlist.add(new MyPoint(-10,10));
        p.print(pointlist);

    }
}
