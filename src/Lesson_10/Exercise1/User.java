package Lesson_10.Exercise1;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class User {
	public Socket sct;
	public String name;
	public Scanner in;
	public PrintWriter out;
    public User(Socket sock) {
        sct = sock;
        try {
        out = new PrintWriter(sct.getOutputStream(), true);
        in = new Scanner(sct.getInputStream());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
