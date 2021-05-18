package Lesson_10.Exercise1;

import java.util.ArrayList;

public class MultiChatServer implements Runnable {
    User me;
    ArrayList<User> partners;

    MultiChatServer(User u, ArrayList<User> users) {
        me = u;
        partners = users;
    }

    @Override
    public void run() {
        try {
            while (me.in.hasNextLine()) {
                var msg = me.in.nextLine();
                System.out.println("Message received: " + msg);
                if (msg.startsWith("NAME: ")) {
                    me.name = msg.substring(("NAME: ").length());
                } else {
                    for (User p : partners) {
                        if (!p.equals(me)) {
                            System.out.println("Sending message");
                            p.out.printf("%s: %s\n", me.name, msg);
                        }
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            try {
                me.sct.close();
            } catch (Exception e) {
            }
        }
    }
}