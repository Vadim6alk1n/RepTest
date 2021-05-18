package Sockets;

import java.io.PrintWriter;
import java.util.Scanner;
import java.net.Socket;
import java.io.IOException;

public class Lesson_10_1_Client {
    public static void main(String[] args) throws IOException {
        var socket = new Socket("localhost", 59090);
        var in = new Scanner(socket.getInputStream());
        System.out.println("Server response: " + in.nextLine());
    }
}
