package Lesson_5;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO_example {
    public static void main(String[] args) {
        try {
            File file = new File( // just an object
                    "fileWrite2.txt");
            FileWriter fw = new FileWriter(file); // create an actual file a FileWriter obj
            fw.write("howdy\nfolks\n"); // write characters to the file
            fw.write(65);
            FileWriter fw2 = new FileWriter(file, true); //append the same file
            fw2.write("test123");
            fw.write("aaa");
            fw.write(50);
            fw.flush();
            fw2.flush();
            fw.close(); // close file when done
            fw2.close();
            FileReader fr =
                    new FileReader(file); // create a FileReader // object
            char in[] = new char[100];
            int size = fr.read(in); // read the whole file!
            System.out.println("size: " + size + " bytes"); // how many bytes read
            for (char c : in) // print the array
                System.out.print(c);
            fr.close(); // again, always close
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
