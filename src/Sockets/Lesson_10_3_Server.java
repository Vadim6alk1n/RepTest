package Sockets;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Executors;

class User
{
    Socket sock;
    public Scanner in;
    public PrintWriter out;
    int i=0;
}

public class Lesson_10_3_Server{

    public static void main(String[] args)
    {
        try {
            var listener = new ServerSocket(59090);
            System.out.println("Creating socket");
            var pool = Executors.newFixedThreadPool(2);
            while (true)
            {
                //Wait for users
                System.out.println("WAITING");
                var sock1 = listener.accept();
                System.out.println("1");
                //First user connected, wait for second
                var out1 = new PrintWriter(sock1.getOutputStream(), true);
                out1.println("Waiting for other user");

                System.out.println("1+");
                var sock2 = listener.accept();
                var out2 = new PrintWriter(sock2.getOutputStream(), true);
                //Both users connected
                out1.println("Other user connected!");
                out1.println("User IP: " + sock2.getInetAddress().toString());

                out2.println("Other user connected!");
                out2.println("User IP: " + sock1.getInetAddress().toString());
                //Start thread
                pool.execute(new ChatServer(sock1,sock2));
                pool.execute(new ChatServer(sock2,sock1));
            }
        } catch(Exception e){}
    }

    private static class ChatServer implements Runnable {
        User partner;
        User me;
        ChatServer(Socket sock1,Socket sock2)
        {
            partner = new User();
            me = new User();
            partner.sock = sock2;
            me.sock = sock1;
            try {
                partner.in = new Scanner(sock2.getInputStream());
                me.in = new Scanner(sock1.getInputStream());
                partner.out = new PrintWriter(sock2.getOutputStream(),true);
                me.out = new PrintWriter(sock1.getOutputStream(),true);
            } catch(Exception e)
            {}
        }
        @Override
        public void run() {
            try
            {
                while (me.in.hasNextLine()) {
                    var msg = me.in.nextLine();
                    System.out.println("Message received: " + msg);
                    partner.out.println(msg);
                }
            }catch (Exception e)
            {}
            finally
            {
                try
                {
                    me.sock.close();
                } catch (Exception e){}
            }
        }
    }
}
