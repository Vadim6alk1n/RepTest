package Lesson_12;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

class MyData
{
    MyData(int a,int b,String s)
    {
        this.a = a;
        this.b = b;
        this.s = s;
    }
    int a;
    int b;
    String s;
}

public class Lesson_12_2 {
    static public void main(String[] args)
    {
        //Sum of all even integers from 0 to 50
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=0;i<50;i++)
            arr.add(i);

        Integer sum = arr.stream().filter(value -> value%2 == 0).reduce(0,(acc,val) -> acc + val);
        System.out.println(sum);

        //Custom data MyData. Select all elements if a < b, only unique
        LinkedList<MyData> list = new LinkedList<MyData>();
        list.add(new MyData(1,2,"a"));
        list.add(new MyData(2,1,"b"));
        list.add(new MyData(3,3,"c"));
        list.add(new MyData(10,20,"b"));
        list.add(new MyData(5,15,"a"));

        LinkedList<String> res = list.stream().filter(data -> data.a < data.b).map(data -> data.s).collect(Collectors.toSet()).stream().collect(Collectors.toCollection(LinkedList::new));
        LinkedList<String> res2 = list.stream().filter(data -> data.a < data.b).map(data -> data.s).distinct().collect(Collectors.toCollection(LinkedList::new));
        for (var i : res)
        {
            System.out.println(i);
        }
        for (var i : res2)
        {
            System.out.println(i);
        }

    }
}
