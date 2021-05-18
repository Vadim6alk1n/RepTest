package Lesson_12;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

class BigNumber
{
    String number;
}

interface NumberOperations<T>
{
    //math operations
    T Add (T a ,T b);
    T Sub (T a ,T b);
    T Mul (T a ,T b);
    T Div (T a ,T b); //???
    //for comparasing and sorting
    boolean Compare(T a,T b);
    boolean IsPositive(T a);
}

class MyNumberCollection<T>
{
    //Members
    ArrayList<T> data;
    NumberOperations<T> operations;
    //Methods
    T Sum()
    {
        T res = data.get(0);
        for (var i: data)
        {
            res = operations.Add(res,i);
        }
        return res;
    }
    ArrayList<T> GetPositiveNumbers()
    {
        return null;
    }
    ArrayList<T> GetAllNumbersBiggerThan(T n)
    {
        return null;
    }
    void Sort()
    {

    }
    T Average() //???
    {
        return null;
    }
}

public class Lesson_12_task {
    public static void main(String[] args)
    {
        MyNumberCollection<BigNumber> mycollection = new MyNumberCollection<>();
        mycollection.data = new ArrayList<>();
        mycollection.operations = new NumberOperations<BigNumber>() {
            @Override
            public BigNumber Add(BigNumber a, BigNumber b) {
                return null;
            }

            @Override
            public BigNumber Sub(BigNumber a, BigNumber b) {
                return null;
            }

            @Override
            public BigNumber Mul(BigNumber a, BigNumber b) {
                return null;
            }

            @Override
            public BigNumber Div(BigNumber a, BigNumber b) {
                return null;
            }

            @Override
            public boolean Compare(BigNumber a, BigNumber b) {
                return false;
            }

            @Override
            public boolean IsPositive(BigNumber a) {
                return false;
            }
        };
        mycollection.data.add(new BigNumber());
        mycollection.Average();
        mycollection.Sort();
    }
}
