package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class AppClient03 {
	public static void main(String[] args) {
		System.out.println("Try Connection");
		Scanner sc = new Scanner(System.in);
		try {
			Socket client = new Socket("192.168.0.229", 10001);
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			System.out.println("Connected");
			while (true) {
				System.out.print("client>");
				String user = sc.nextLine();
				dos.writeUTF(user);
				if (user.equals("quit")) {
					System.out.println("Quit client");
					break;
				}
				System.out.println("server>" + dis.readUTF());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}