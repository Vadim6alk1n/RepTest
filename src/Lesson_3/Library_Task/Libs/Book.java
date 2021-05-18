package Lesson_3.Library_Task.Libs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Book extends Material implements FileWorker
{
    protected int m_pageCount;
    protected String[] m_data;
    //Non-static initialization
    {
        m_pageCount = 0;
        m_data = new String[0];
    }
    @Override
    public void Print()
    {
        System.out.println("Book [" + m_title + "]");
        System.out.println("By: " + m_author);
        System.out.println("Released: " + m_date.toString());
        System.out.println("Page count: " + m_pageCount);
        System.out.println("Text:");
        for (String it : m_data)
        {
            System.out.println(it);
        }
        System.out.println();
    }
    @Override
    public String toString()
    {
        return "{Book" + "Title = '" + m_title + "'; Author = " +
                m_author +
                "; Date = " + m_date.toString() + "; Page Count = "
                + m_pageCount;
    }
    public int Replace(String oldStr, String newStr)
    {
        int count = 0;
        for (int it = 0;it<m_data.length;it++)
        {
            StringBuilder sb = new
                    StringBuilder(m_data[it]);
            int k = sb.indexOf(oldStr);
            while (k!=-1) {
                count++;
                sb.delete(k, k + oldStr.length());
                sb.insert(k,newStr);
                k = sb.indexOf(oldStr,k+1);
            }
            m_data[it] = sb.toString();
        }
        return 0;
    }
    public int Count(String str)
    {
        int count = 0;
        for (String it : m_data)
        {
            StringBuilder sb = new StringBuilder(it);
            int k = sb.indexOf(str);
            while (k!=-1) {
                count++;
                k = sb.indexOf(str,k+1);
            }
        }
        return count;
    }
    //Getter
    public int GetPageCount() { return m_pageCount;}
    //Setter
    public void SetPageCount(int pageCount) {
        m_pageCount = pageCount;
    }
    @Override
    public int Save(String filepath)
    {
        try {
            BufferedWriter writer = new
                    BufferedWriter(new FileWriter(filepath));
            //Write Header
            writer.write(m_title);
            writer.newLine();
            writer.write(m_author);
            writer.newLine();
            DateFormat dateFormat = new
                    SimpleDateFormat("dd/MM/yyyy");
            writer.write(
                    dateFormat.format(m_date));
            writer.newLine();

            writer.write(Integer.toString(m_pageCount));
            writer.newLine();
            for (String it : m_data)
            {
                writer.write(it);
                writer.newLine();
            }
            writer.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
        return 0;
    }
    @Override
    public int Load(String filepath)
    {
        int lines = 0;
        BufferedReader br;
        //Calculate line count
        try {
            br = new BufferedReader(new FileReader(filepath));
            while (br.readLine() != null) lines++;
            br.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
        //Remove Header
        lines -=4;
        //If no text
        if (lines < 0)
        {
            return 0;
        }
        //Create array
        m_data = new String[lines];
        try{
            br = new BufferedReader(new FileReader(filepath));
            String line;
            int it = 0;
            m_title = br.readLine();
            m_author = br.readLine();
            SetDate(br.readLine());
            m_pageCount = Integer.parseInt(br.readLine());
            while ((line = br.readLine()) != null) {
                m_data[it++] = line;
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return 0;
    }
}

