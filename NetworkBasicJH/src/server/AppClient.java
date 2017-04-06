package server;

import java.net.Socket;

public class AppClient {
	public static void main(String[] args) {
		System.out.println("서버 접속 시도");
		try {
			Socket client = new Socket("localhost", 10001);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("접속 성공");
	}
}
