package Lesson_12;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

interface ArithmeticOperations<T>
{
    T Add(T x, T y);
    T Subtract(T x, T y);
}
class MyCollection<T>
{
    MyCollection(ArithmeticOperations<T> op)
    {
        this.op = op;
        data = new ArrayList<>();
    }

    public ArrayList<T> data;
    ArithmeticOperations<T> op;
    T Sum()
    {
        if (data.size()==0) return null;
        if (data.size()==1) return data.get(0);
        T res = data.get(0);
        var it = data.iterator();
        it.next();
        while(it.hasNext())
        {
            res = op.Add(res,it.next());
        }
        return res;
    };
}

public class Lesson_12_1 {

    public static void main(String[] args)
    {
        //Lambda for int operation
        BinaryOperator<Integer> lambdasum = (Integer x, Integer y) -> x+y;
        System.out.println(lambdasum.apply(2,2));

        //Lambda for int operation
        BinaryOperator<Integer> lambdasumwrong = (Integer x, Integer y) -> x+y + 2;
        System.out.println(lambdasumwrong.apply(2,2));
        int test=54;
        //test = 34; //all variables, that are used in pure functions must be final(constant)
        ArithmeticOperations<Integer> a = new ArithmeticOperations<Integer>() {
            @Override
            public Integer Add(Integer x, Integer y) {
                return x+y;
            }

            @Override
            public Integer Subtract(Integer x, Integer y) {
                return x-y + test;
            }
        };
        System.out.println(a.Add(3,6));
        System.out.println(a.Subtract(5,6));
        MyCollection<Integer> collection = new MyCollection<>(a);
        collection.data.add(1);
        collection.data.add(2);
        collection.data.add(3);
        collection.data.add(4);
        collection.data.add(5);
        System.out.println(collection.Sum());

    }
}
