package Sockets;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Date;

public class Lesson_10_1_Server {
    public static void main(String[] args)
    {
        try {
            //Create server socket
            var listener = new ServerSocket(59090);
            System.out.println("Creating socket");
            while(true)
            {
                try (var socket = listener.accept())
                {
                    var out = new PrintWriter(socket.getOutputStream(),true);
                    out.println(new Date().toString());
                }
            }
        } catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }

}
