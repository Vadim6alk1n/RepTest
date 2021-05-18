package Sockets;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Date;
import java.util.Scanner;

public class Lesson_10_2_Server {
    public static void main(String[] args)
    {
        try {
            var listener = new ServerSocket(59090);
            System.out.println("Creating socket");
            killme:
            try (var socket = listener.accept()) {
                var in = new Scanner(socket.getInputStream());
                var out = new PrintWriter(socket.getOutputStream(), true);
                while(true)
                {
                    while (in.hasNext()) {
                        String msg = in.nextLine();
                        if (msg.equals("killme"))
                        {
                            break killme;
                        }
                        System.out.println("Received message " + msg);
                        out.println(new Date().toString() + msg);
                    }
                }
            }
        } catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
}
