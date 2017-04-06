package server;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class AppClient02 {
	public static void main(String[] args) {
		System.out.println("서버 접속 시도");
		try {
			Socket client = new Socket("localhost", 10001);
			InputStream in = client.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			System.out.println(dis.readUTF());
			dis.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("접속 성공");
	}
}
