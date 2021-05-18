package Lesson_6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedList_example {

    static class Point
    {
        Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        int x;
        int y;
        @Override
        public String toString()
        {
            return x + " " + y;
        }
    }

    public static void main(String [] args)
    {
        LinkedList<Point> list = new LinkedList<Point>();
        list.add(new Point(0,0));
        list.add(new Point (-5,5));
        list.add(new Point (200,200));
        list.add(new Point (500,250));
        list.addFirst(new Point (10,20));
        //for each
        for (Point i: list)
        {
            System.out.println(i);
        }
        //Print first element
        Point f = list.get(0);
        System.out.println();
        System.out.println(f.x + " " + f.y);

        list.remove(f);
        list.set(1,f);
        System.out.println();
        System.out.println(list);
        //Print list backwards using descendingIterator
        Iterator<Point> itr =  list.descendingIterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

        //Print forward and backward using the same ListIterator (start from third element)
        ListIterator<Point> litr =  list.listIterator(2);
        while(litr.hasNext())
        {
            System.out.println("index: " + litr.nextIndex() + " value: " + litr.next());
        }
        while(litr.hasPrevious())
        {
            System.out.println("index: " + litr.previousIndex() + " value: " + litr.previous());
        }
    }
}
