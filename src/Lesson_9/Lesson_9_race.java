package Lesson_9;
public class Lesson_9_race {

    public static void main(String[] args) {

        stop = false;
        x = 0;
        new A().start();
        new B().start();
    }

    private static Integer x;
    private static boolean stop;

    static class A extends Thread
    {
        @Override
        public void run() {
            while(!stop)
            {
                synchronized (x)
                {
                    x++;
                }
            }
        }
    }
    static class B extends Thread
    {
        @Override
        public void run() {
            while(!stop)
            {
                synchronized (x)
                {
                    if (x % 2 == 0) {
                        System.out.println("x=" + x);
                    }
                }
            }
        }
    }

}
