package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			// 서버 구동
			server = new ServerSocket(10001);
			System.out.println("서버 구동됨... 클라이언트 요청 대기중...");

			while (true) {
				// 클라이언트가의 요청이 왔을때 실행됨.
				Socket client = server.accept();
				System.out.println("클라이언트 접속됨 : " + client);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
