package Lesson_3.Library_Task.Libs;

public class Film extends Material{
    protected int m_length;
    //Non-static initialization
    {
        m_length = 0;
    }
    @Override
    public void Print()
    {
        System.out.println("Film [" + m_title + "]");
        System.out.println("By: " + m_author);
        System.out.println("Released: " +
                m_date.toString());
        System.out.println("Released: " + m_length);
        System.out.println();
    }
    @Override
    public String toString()
    {
        return "{Film" + "Title = '" + m_title + "'; Author = " + m_author +  "; Date = " + m_date.toString() + "; Length = " + m_length;
    }
    //Getter
    public int GetLength() { return m_length;}
    //Setter
    public void SetLength(int length) { m_length =
            length;}
}
