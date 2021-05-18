package Lesson_5;

import java.io.File;
import java.io.IOException;

public class FileIO_FileDirManipulation {
    public static void main(String []args)
    {
        File myDir = new File("mydir"); // create an object
        myDir.mkdir(); // create an actual directory
        File myFile = new File(myDir, "myFile.txt");
        try {
            myFile.createNewFile();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        File existingDir = new File("existingDir"); // assign a dir
        System.out.println(existingDir.isDirectory());
        File delDir = new File("deldir"); // make a directory
        delDir.mkdir();
        File delFile1 = new File(
                delDir, "delFile1.txt"); // add file to directory
        try {
            delFile1.createNewFile();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        File delFile2 = new File(
                delDir, "delFile2.txt"); // add file to directory
        try {
            delFile2.createNewFile();
        }  catch (IOException e)
        {
            e.printStackTrace();
        }
        delFile1.delete(); // delete a file
        System.out.println("delDir is "
                + delDir.delete()); // attempt to delete
// the directory
        File newName = new File(
                delDir, "newName.txt"); // a new object
        delFile2.renameTo(newName); // rename file
        File newDir = new File("newDir"); // rename directory
        delDir.renameTo(newDir);
        String[] files;
        File search = new File("newDir");
        files = search.list(); // create the list
        for(String fn : files) // iterate through it
            System.out.println("found " + fn);
    }

}
