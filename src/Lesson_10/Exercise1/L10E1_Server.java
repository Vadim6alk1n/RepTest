package Lesson_10.Exercise1;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

public class L10E1_Server {
	public static void main(String[] args) {
		try {
			ServerSocket listener = new ServerSocket(59090);
			System.out.println("Creating socket");
			var pool = Executors.newCachedThreadPool();
			ArrayList<User> Users = new ArrayList<User>();
			int i = 0;
			boolean Run = true;
			while (Run) {
				System.out.println("WAITING");
				Socket newUSocket = listener.accept();
				User newUser = new User(newUSocket);
				System.out.printf("%d connected\n", i++);
				newUser.out.printf("You are number %d\n", i);
				Users.add(newUser);
				pool.execute(new MultiChatServer(newUser, Users));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
