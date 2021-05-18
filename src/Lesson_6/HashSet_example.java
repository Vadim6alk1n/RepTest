package Lesson_6;
import java.util.HashSet;
import java.util.Iterator;

public class HashSet_example {
    public static void main(String[] args)
    {
        HashSet<Double> set = new HashSet<Double>();
        HashSet<Double> set2 = new HashSet<Double>();
        for (int i = 0;i < 10;i++)
            set.add((double)i);
        for (int i = 5;i<15;i++)
            set2.add((double)i);
        HashSet<Double> set3 = new HashSet<Double>(set);
        set3.addAll(set2);
        System.out.println(set3);
        set3.clear();
        Iterator<Double> it1 = set.iterator();
        while(it1.hasNext())
        {
            Double it1v;
            boolean wasFound = false;
            it1v = it1.next();
            Iterator<Double> it2 = set2.iterator();
            while (it2.hasNext())
            {
                Double it2v;
                it2v = it2.next();
                if (it1v.equals(it2v)) wasFound = true;
            }
            if (!wasFound) set3.add(it1v);
        }
        System.out.println(set3);
    }
}
