package Lesson_10.Exercise1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Lesson_10_3_Client implements Runnable {
	static Scanner in;// = new Scanner(socket.getInputStream());

	public static void main(String[] args) throws IOException {
		var socket = new Socket("localhost", 59090);
		in = new Scanner(socket.getInputStream());
		var out = new PrintWriter(socket.getOutputStream(), true);
		var input = new Scanner(System.in);
		System.out.print("Enter name: ");
		String name = input.nextLine();
		out.printf("NAME: %s\n", name);
		Lesson_10_3_Client instance = new Lesson_10_3_Client();
		Thread thr = new Thread(instance);
		thr.start();
		while (true) {
			String msg = input.nextLine();
			if (msg.equals("end"))
				break;
			out.println(msg);
		}
	}

	@Override
	public void run() {
		while (in.hasNext()) {
			System.out.println(in.nextLine());
		}
	}
}
