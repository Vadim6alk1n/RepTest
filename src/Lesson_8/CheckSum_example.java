package Lesson_8;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class CheckSum implements Runnable
{
    public void run()
    {
        System.out.println("Running " + Thread.currentThread().getName());
        result = 0;
        for(int it = offset; it < offset+length ;it++)
        {
            result += data.get(it);
        }
    }
    static ArrayList<Byte> data;
    int offset,length;
    int result;
}

public class CheckSum_example {
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
        int nThreads = 8;

        Thread[] t = new Thread[nThreads];
        LinkedList<CheckSum> list = new LinkedList<>();
        int blockSize = data.size() / nThreads;
        for(int i = 0;i<nThreads;i++)
        {
            CheckSum cs = new CheckSum();
            cs.offset = blockSize*i;
            cs.length = blockSize;
            cs.data = data;
            if (i == nThreads-1)
            {
                cs.length+=data.size() % nThreads;
            }
            list.addLast(cs);
            t[i] = new Thread(cs);
            t[i].setPriority(i+1);
            t[i].setName(new Integer(i).toString());
        }
        for (int i=0;i<nThreads;i++)
        {
            t[i].start();
        }

        try {
         //   Thread.sleep(5000);
        } catch(Exception e){}


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
