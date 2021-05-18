package Lesson_9;
public class Lesson_9_2 {
    static class MyPrinter
    {
        MyPrinter()
        {
            totalprints = 0;
        }

        public synchronized void PrintNumbers(int a, int b)
        {
            for (int i = a; i <= b ; i++)
            {
                System.out.println(i);
                totalprints++;
                try {
                    Thread.sleep(100);
                } catch(Exception e){}
            }
        }
        public Integer totalprints;
    }
    static class Thread1 extends Thread
    {
        Thread1(MyPrinter p)
        {
            print = p;
        }

        MyPrinter print;
        @Override
        public void run() {
            print.PrintNumbers(1,10);
        }
    }
    static class Thread2 extends Thread
    {
        Thread2(MyPrinter p)
        {
            print = p;
        }
        MyPrinter print;
        @Override
        public void run() {
            print.PrintNumbers(11,20);
        }
    }
    static class Thread3 extends Thread
    {
        Thread3(MyPrinter p)
        {
            print = p;
        }

        @Override
        public void run() {
                int local = print.totalprints;
                while (local < 20) {
                    synchronized (print.totalprints) {
                        if (local != print.totalprints) {
                            local = print.totalprints;
                            System.out.println("Total prints: " + local);
                        }
                    }
                }
        }

        MyPrinter print;
    }
    public static void main(String[] args)
    {

        MyPrinter printer = new MyPrinter();
        Thread1 thr1 = new Thread1(printer);
        Thread2 thr2 = new Thread2(printer);
        Thread3 thr3 = new Thread3(printer);
        thr1.start();
        thr2.start();
        thr3.start();
    }

}
