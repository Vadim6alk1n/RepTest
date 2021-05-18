package Lesson_8;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


class CheckSum2 implements Runnable
{
    final long joinTime = 1000;
    final long maxSubThreads = 4;
    CheckSum2()
    {
        canCreateThreads = true;
    }
    public void run()
    {
        System.out.println("Running " + Thread.currentThread().getName());
        if (canCreateThreads)
        {
            int nThreads = (int)(Math.random()*(maxSubThreads-1 ))+1;
            System.out.println(Thread.currentThread().getName() + "creates " + nThreads + "threads");
            Thread[] t = new Thread[nThreads];
            LinkedList<CheckSum2> list = new LinkedList<>();
            int blockSize = length / nThreads;

            for (int i =0;i<nThreads;i++)
            {
                CheckSum2 cs = new CheckSum2();
                cs.canCreateThreads=false;
                cs.offset = offset + blockSize*i;
                cs.length = blockSize;
                if (i == nThreads-1)
                {
                    cs.length+=length % nThreads;
                }
                list.addLast(cs);
                t[i] = new Thread(cs);
                t[i].setName(Thread.currentThread().getName() + "_" + new Integer(i).toString());
            }
            for (int i =0;i<nThreads;i++)
            {
                t[i].start();
            }
            try {
                for (int i = 0; i < nThreads; i++) {
                    t[i].join(joinTime);
                }
            }
            catch (Exception e)
            {

            }
            result = 0;
            for (int i =0; i< nThreads;i++)
            {
                int s = list.get(i).result;
                result+=s;
            }
        }
        else {
            result = 0;
            for (int it = offset; it < offset + length; it++) {
                result += data.get(it);
            }
        }
    }
    static ArrayList<Byte> data;
    int offset,length;
    int result;
    private boolean canCreateThreads;
}

public class CheckSum_example2 {
    public static void main(String[] args)
    {
        ArrayList<Byte> data = new ArrayList<Byte>();
        try(     FileInputStream fin = new FileInputStream("supervideo.MP4");
                 BufferedInputStream inputStream = new BufferedInputStream( fin);)
        {
            Integer byteRead;

            while ((byteRead = inputStream.read()) != -1) {
                data.add(byteRead.byteValue());
            }
        } catch (IOException ex)
        {

        }

        long startTime = System.nanoTime();
        int nThreads = 4;

        Thread[] t = new Thread[nThreads];
        LinkedList<CheckSum2> list = new LinkedList<>();
        int blockSize = data.size() / nThreads;
        for(int i = 0;i<nThreads;i++)
        {
            CheckSum2 cs = new CheckSum2();
            cs.offset = blockSize*i;
            cs.length = blockSize;
            cs.data = data;
            if (i == nThreads-1)
            {
                cs.length+=data.size() % nThreads;
            }
            list.addLast(cs);
            t[i] = new Thread(cs);
            t[i].setName(new Integer(i).toString());
        }
        for (int i=0;i<nThreads;i++)
        {
            t[i].start();
        }
        //
        //WORK
        //
        try {
            for (int i = 0; i < nThreads; i++) {
                t[i].join();
            }
        }
        catch (Exception e)
        {

        }
        int result = 0;
        for (int i =0; i< nThreads;i++)
        {
            int s = list.get(i).result;
            result+=s;
        }
        System.out.println(result);
        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("Total execution time in millis: "
                + elapsedTime/1000000);

    }
}
