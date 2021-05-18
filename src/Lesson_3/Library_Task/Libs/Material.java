package Lesson_3.Library_Task.Libs;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
public abstract class Material implements Comparable<Material>{
    public final String EmptyAuthor = "Public";
    public final String EmptyTitle = "No-Title";
    public final String DefaultDate = "01/01/1900";
    protected static int LibraryCount;
    protected String m_author;
    protected String m_title;
    protected Date m_date;
    //Non-static initialization
    {
        m_author = EmptyAuthor;
        m_title = EmptyTitle;
        try { //otherwise compile-time error (unhandled exception)
            m_date = new
                    SimpleDateFormat("dd/MM/yyyy").parse(DefaultDate);
        } catch (Exception e){}
    }
    static
    {
        LibraryCount = 0;
    }
    public Material()
    {
        LibraryCount++;
    }
    public abstract void Print();
    @Override
    public int compareTo(Material o)
    {
        if (!m_title.equals(o.GetTitle()))
        {
            return m_title.compareTo(o.GetTitle());
        }
        if (!m_date.equals(o.GetDate())) {
            return m_date.compareTo(o.GetDate());
        }
        return m_author.compareTo(o.GetAuthor());
    }
    //Getters
    public String GetAuthor() { return m_author; }
    public String GetTitle() { return m_title; }
    public Date GetDate() { return m_date; }
    //Setters
    public void SetAuthor(String author) { m_author = author; }
    public void SetTitle(String title) { m_title = title; }
    public int SetDate(String date)
    {
        try {
            m_date = new
                    SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (Exception e)
        {
            return -1;
        }
        return 0;
    }
}