package Lesson_9;

import java.util.ArrayList;

public class Lesson_9_3 {

    private volatile static ArrayList<Integer> data;

    static class CalcSum extends Thread
    {
        CalcSum()
        {
            sum = 0;
        }
        @Override
        public void run() {
            synchronized (this)
            {
                for(Integer i : data)
                {
                    sum+=i;
                    try
                    {
                        sleep(100);
                    }catch (Exception e)
                    {

                    }
                }
                notify();
            }
            doSomething();
        }
        public void doSomething()
        {
            for (int i = 0 ;i<10;i++)
            {
                try
                {
                    System.out.println("Doing something after release " + i);
                    sleep(1000);
                } catch (Exception e){ }
            }
        }
        Integer sum;
    }

    static class ReturnPercent extends Thread
    {
        CalcSum calcsum;
        float percent;
        float actualreturn;
        ReturnPercent(CalcSum calc,float per)
        {
            calcsum = calc;
            percent = per;
            actualreturn = 0;
        }

        @Override
        public void run() {
            try {
                calcsum.start();
            }catch (Exception e){}
            synchronized (calcsum)
            {
                //Awaiting for calcsum to calculate sum
                try{
                    calcsum.wait();
                } catch (Exception e)
                {}
                actualreturn = calcsum.sum * percent;
                System.out.println("Return is " + actualreturn);
                calcsum.notify();
            }
        }
    }

    public static void main(String[] args)
    {
        CalcSum cs = new CalcSum();
        ReturnPercent[] rpa = new ReturnPercent[5];
        for (int i=0; i < 5;i++)
            rpa[i] = new ReturnPercent(cs,(float)0.1*i);
        data = new ArrayList<Integer>();
        for (int i=0;i<10;i++)
        {
            data.add(i);
        }
        for (int i=0;i<5;i++)
        {
            rpa[i].start();
        }
    }
}
