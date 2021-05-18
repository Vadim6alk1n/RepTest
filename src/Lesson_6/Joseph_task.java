package Lesson_6;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Joseph_task {
    public static void main(String[] args)
    {
        int n,k;
        n = 7;
        k = 3;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0;i<n;i++)
        {
            list.add(i+1);
        }
        int it = 1;
        while(!list.isEmpty())
        {
            //Move k-steps
            for (int i=0;i<k-1;i++)
            {
                if (it < list.size() -1 )
                    it++;
                else
                    it = 0;
            }
            //remove elements
            Integer removeint = list.get(it);
            list.remove(removeint);
            if (it==list.size()) it=0;
            System.out.println(removeint);
        }
    }
}
