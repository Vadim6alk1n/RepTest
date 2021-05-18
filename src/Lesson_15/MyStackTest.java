package Lesson_15;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    static MyStack stack;
    static MyStack stacktest;
    @BeforeAll
    public static void init()
    {
        stacktest = new MyStack(3);
        try {
            stacktest.Push("1");
            stacktest.Push("2");
            stacktest.Push("3");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @BeforeEach
    public void initeach()
    {
        stack = new MyStack(5);
        try {
            stack.Push("1");
            stack.Push("2");
            stack.Push("3");
            stack.Push("4");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void stackTest()
    {
        stack = new MyStack(5);
        try {
            stack.Push("1");
            stack.Push("2");
            stack.Push("3");
            stack.Push("4");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            stack.Push("5");
            stack.Pop();
            stack.Pop();
            assertEquals(stacktest.Sum(),stack.Sum());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void stackResizeTest()
    {
        try {
            stack.Pop();
            stack.Resize(3);
            assertEquals(stacktest.Sum(),stack.Sum());
            assertEquals(stacktest.GetCapacity(),stack.GetCapacity());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}