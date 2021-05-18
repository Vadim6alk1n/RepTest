package Lesson_3.Library_Task.Libs;

import Lesson_3.Circle;
import Lesson_3.SubCircle;

import java.util.Arrays;
public class Library {
    Material[] m_archive;
    protected static final int MaxMaterialCount;
    //Non-static initialization
    {
        m_archive = new Material[0];
    }
    //Static initialization
    static
    {
        MaxMaterialCount = 100;
    }
    public void Add(Material material)
    {
        if (m_archive.length >= MaxMaterialCount) return;
        Material[] tmpArchive = new Material[m_archive.length+1];
        String title = material.GetTitle();
        boolean newMaterial = true;
        for (int it = 0; it < m_archive.length; it++)
        {
            //Material title must be unique
            if (title.equals(m_archive[it].GetTitle()))
            {
                newMaterial = false;
                break;
            }
            tmpArchive[it] = m_archive[it];
        }
        if (newMaterial) {
            tmpArchive[m_archive.length] = material;
            m_archive = tmpArchive;
        }
    }
    public Material GetByTitle(String title)
    {
        for (Material it : m_archive)
        {
            if (title.equals(it.GetTitle()))
            {
                return it;
            }
        }
        return null;
    }
    public void Sort()
    {
        Arrays.sort(m_archive);
    }
    public void Print()
    {
        for (Material it: m_archive)
        {
            it.Print();
        }
    }
    //In Java there is no const reference
    public Material[] GetArchive() { return m_archive; }
}
