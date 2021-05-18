package Lesson_3.Library_Task;

import Lesson_3.Library_Task.Libs.Book;
import Lesson_3.Library_Task.Libs.Film;
import Lesson_3.Library_Task.Libs.Library;
import Lesson_3.Library_Task.Libs.Material;
public class LibMain {
    public static void main(String[] args) {
        Library library = new Library();
        Book t;
        t = new Book();
        t.SetPageCount(1000);
        t.SetTitle("Bible");
        t.SetAuthor("God");
        t.SetDate("01/01/1200");
        library.Add(t);
        Film f = new Film();
        f.SetTitle("Star Wars: Episode I");
        f.SetAuthor("George Lucas");
        f.SetDate("19/05/1999");
        f.SetLength(136);
        library.Add(f);
        t = new Book();
        t.Load("book.txt");
        library.Add(t);
        t = new Book();
        t.Load("book2.txt");
        library.Add(t);
        library.Print();
        t = (Book) library.GetByTitle("RandomBook1");
        t.Replace("and", "or");
        System.out.println(t.Count("and"));
        t.Print();
        library.Sort();
        Material[] archive = library.GetArchive();
        for (Material it : archive) {
            System.out.println(it.GetTitle());
        }
        archive[0].SetTitle("HOHOHO");
        library.Print();
    }
}