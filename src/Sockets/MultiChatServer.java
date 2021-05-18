package Sockets;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class MultiChatServer implements Runnable {
    ArrayList<User> partner;
    User me;
    MultiChatServer(User user)
    {
        partner = new ArrayList<>();
        me = user;
       /* me.sock = sock1;
        try {
            me.in = new Scanner(sock1.getInputStream());
            me.out = new PrintWriter(sock1.getOutputStream(),true);
        } catch(Exception e)*/
        {}
    }
    synchronized void AddPartner(User p)
    {
        partner.add(p);
    }

    @Override
    public void run() {
        try
        {
            synchronized (me.in) {
                while (me.in.hasNextLine()) {
                    var msg = me.in.nextLine();
                    System.out.println("Message received: " + msg);
                    System.out.println(me.i);
                    System.out.println(partner.size());
                    for (var p : partner) {
                        //new PrintWriter(p.sock.getOutputStream()).println(msg);
                        synchronized (p.out) {
                            System.out.println("Resending message: " + p.i + " " + p.out + msg);
                            p.out.println(msg);
                        }

                    }
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                me.sock.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}