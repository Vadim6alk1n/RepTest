package Sockets;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Executors;


public class Chat_Server{
    public static void main(String[] args)
    {
        try {
            var listener = new ServerSocket(59090);
            System.out.println("Creating socket");
            var pool = Executors.newFixedThreadPool(5);
            ArrayList<MultiChatServer> chats = new ArrayList<>();
            Socket sock1;
            int i=0;
            while (true)
            {
                sock1 = listener.accept();
                User user = new User();
                user.i = i++;
                user.sock = sock1;
                user.in = new Scanner(sock1.getInputStream());
                user.out = new PrintWriter(sock1.getOutputStream(),true);
                MultiChatServer newchat = new MultiChatServer(user);
                for (var c : chats)
                {
                    c.AddPartner(user);
                    newchat.AddPartner(c.me);
                }
                chats.add(newchat);
                pool.execute(newchat);

               /* //Wait for users
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
                pool.execute(new MultiChatServer(sock1));
                pool.execute(new MultiChatServer(sock2));*/
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
