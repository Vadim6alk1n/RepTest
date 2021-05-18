package Lesson_15;
import java.util.ArrayList;
import java.util.LinkedList;

public class MyStack {

    public class MyStackExceptionResize extends Exception
    {
        MyStackExceptionResize()
        {
            super("Resize failed");
        }
    }

    public class MyStackExceptionOversize extends Exception
    {
        MyStackExceptionOversize()
        {
            super("Stack oversize");
        }
    }

    public class MyStackExceptionEmpty extends Exception
    {
        MyStackExceptionEmpty()
        {
            super("Stack is empty");
        }
    }

    private LinkedList<String> data;
    private int capacity;
    private int size;

    public MyStack(int cap)
    {
        capacity = cap;
        size = 0;
        data = new LinkedList<>();
    }

    public int GetSize()
    {
        return capacity;
    }
    public int GetCapacity()
    {
        return size;
    }

    public void Resize(int newcap) throws MyStackExceptionResize
    {
        if (newcap<size)
        {
            throw new MyStackExceptionResize();
        }
        capacity = newcap;
    }

    public void Push(String str) throws  MyStackExceptionOversize
    {
        if (size>=capacity)
        {
            throw new MyStackExceptionOversize();
        }
        size++;
        data.addLast(str);
    }

    public String Pop() throws  MyStackExceptionEmpty
    {
        if (size==0)
        {
            throw new MyStackExceptionEmpty();
        }
        size--;
        String last = data.getLast();
        data.removeLast();
        return last;
    }
    public String Sum()
    {
        String r = new String();
        for (var i : data)
        {
            r+=i;
        }
        return r;
    }
}
