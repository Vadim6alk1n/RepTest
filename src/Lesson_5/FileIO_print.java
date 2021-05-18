package Lesson_5;

import java.io.*;

public class FileIO_print {
    public static void main(String [] args)
    {
        File file = new File("fileWrite2.txt");
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            pw.println("howdy");
            pw.println("folks");
            pw.println("lala");
            pw.format("%8d%n",1234);
            String str = new String("2.5");
            pw.format("2 + %s = %4.2f",str,2+Float.parseFloat(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                String data = br.readLine();
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
