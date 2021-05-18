package Sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Lesson_10_2_Client {
    public static void main(String[] args) throws IOException {
        var socket = new Socket("localhost", 59090);
        var in = new Scanner(socket.getInputStream());
        var out = new PrintWriter(socket.getOutputStream(),true);
        var input = new Scanner(System.in);
        while(true) {
            String msg = input.nextLine();
            if (msg.equals("end")) break;
            out.println(msg);
            System.out.println("Server response: " + in.nextLine());
        }
    }
}
