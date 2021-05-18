package Homework3;

import Lesson_3.Library_Task.Libs.Material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Library {
        ArrayList<Materials> archive;
        Library() {
            archive = new ArrayList<>();
        }
        public void check(String name, String year,String author) throws DuplicatedMaterialException, NullMaterialException {


            for(Materials x : archive){
                if(x.getName().equals(name)){
                    throw new DuplicatedMaterialException("Duplicate found");
                }
            }
            if(name==null || name.equals("")) throw new NullMaterialException("Empty field name found");
            if(year==null || year.equals("")) throw new NullMaterialException("Empty field year found");
            if(author==null || author.equals("")) throw new NullMaterialException("Empty field author found");
        }

        public void add(Materials x)
        {
            try {
                check(x.getName(),x.getYear(),x.getAuthor());
                archive.add(x);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        public void print()
        {
            for (Materials x : archive)
            {
                x.print();
            }
        }

        public static void main(String[] args) {
            Library library = new Library();

/////////
            Book Vinipuh = new Book("Vinipuh","1955","Night Lovell", 157);
            library.add(Vinipuh);
/////////
            Book Vinipuhhh = new Book("Vinipuh","1955","Night Lovell", 157);
            library.add(Vinipuhhh);
/////////
            Film Ugnatza60sek = new Film("", "2010","Bob Marley",150);
            library.add(Ugnatza60sek);
/////////
            Document SpaceX = new Document("SpaceX", "2005","Patric Star","Elon Musk");
            library.add(SpaceX);

            library.print();
        }
    }

