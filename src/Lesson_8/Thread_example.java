package Lesson_8;

import java.util.ArrayList;

public class Thread_example {
    static class MyThread extends Thread
    {
        MyThread(int in)
        {
            data = in;
        }
        public void run()
        {
            System.out.println(data);
        }
        private int data;
    }
    public static void main(String[] args)
    {
        MyThread[] threads = new MyThread[10];
        for (int i = 0;i < 10;i++) {
            threads[i] = new MyThread(i);
        }
        for (int i=0; i<10;i++)
        {
            threads[i].start();
        }
        ArrayList<Integer> e = new ArrayList<>();
        e.add(1);
        e.add(2);
        for (var i : e)
        {
            i++;
        }
        System.out.println(e);
    }
}
