package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServer03 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10001);
			System.out.println("서버 구동됨... 클라이언트 요청 대기중...");
			
			while (true) {
				Socket client =  server.accept();
				System.out.println(client);
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());
				DataInputStream dis = new DataInputStream(client.getInputStream());
				while (true) {
					String rcvMsg = dis.readUTF();
					
					if (rcvMsg.equals("quit")) break;
					dos.writeUTF(rcvMsg);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
