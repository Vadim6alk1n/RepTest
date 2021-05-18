package Lesson_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exception_example {
    public static void ArithmeticException1()
    {
        int a = 1;
        int b = 0;
        int r = a/b;
    }

    public static void ArithmeticException2()
    {
        int a = 1;
        int b = 0;
        try {
            int r = a/b;
            System.out.println(r);
        } catch(ArithmeticException e) {
            System.out.println("Something happened!");
            System.out.println(e.getMessage());
        }
    }

    public static void OutOfBoundsException()
    {
        int [] arr;
        arr = new int[10];
        try {
            int i = arr[10];
        } catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void FinallyExample()
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.dat"));
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return;
        } finally {
            System.out.println("Try-block ended");
        }

    }

    public static void StackTraceExample()
    {
        try
        {
            int r = 1/0;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void ThrowExceptionExample() throws ArithmeticException
    {
        try
        {
            int r = 1/0;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new ArithmeticException("Division by 0");
        }
    }

    public static void ThrowExceptionExample(int a,int b) throws ArithmeticException
    {
        if (b==0)
            throw new ArithmeticException("Division by 0");
    }

    public static void main(String[] args)
    {
        //ArithmeticException1();
        ArithmeticException2();
        OutOfBoundsException();
        FinallyExample();
        StackTraceExample();
        // Date date;
        //date = new SimpleDateFormat("dd/mm/yyyy").parse("23/02/2020");
        try
        {
            ThrowExceptionExample();
        } catch (ArithmeticException e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
