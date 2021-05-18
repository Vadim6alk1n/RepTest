package Lesson_5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class FileIO_stream {
    public static void WriteToStream(char[] str, int bytes, OutputStream stream)
    {
        try {
            stream.write( new String(str).getBytes(),0,bytes);
        } catch (IOException e)
        {
            System.out.println("Failed to write:\"" +str + "\" to stream " + stream);
        }
    }
    public static void main(String[] args)
    {
        try (
                InputStreamReader inputStream = new InputStreamReader(System.in);
                OutputStream outputStream1 = new FileOutputStream("mysuperfile.txt");
                OutputStream outputStream2 = System.out;
        ) {
            char[] data = new char[1024];
            int byteRead = 0;
            do {
                byteRead = inputStream.read(data);
                if (byteRead!=-1) {
                    WriteToStream(data, byteRead, outputStream1);
                    WriteToStream(data, byteRead, outputStream2);
                }
            } while (byteRead!=-1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
