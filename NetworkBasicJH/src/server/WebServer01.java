package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebServer01 {
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
				String acceptTime = "<html>"
						+ "<head>"
						+ "<style>"
						+ "div { font-size: 50px; background: tomato; color:white;"
						+ "      text-align: center; margin: 100px; padding: 50px; border: 10px solid black; }"
						+ "div:hover { background: black; }"
						+ "</style>"
						+ "</head>"
						+ "<body>"
						+ "<div>"
						+ "현재시간 : " + new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(new Date())
						+ "</div>"
						+ "</body>"
						+ "</html>";

				// HTTP 프로토콜 방식으로 메세지 작성
				String startLine = "HTTP/1.1 200 OK\r\n";
				String header = "Cache-Control: no-cache\r\n"
					 	      + "Content-Type: text/html; charset=UTF-8\r\n"
					 	      + "Content-Length: " + acceptTime.getBytes().length + "\r\n\r\n";
				String body = acceptTime;
				String sendData = startLine + header + body;

				// 연결된 클라이언트에 데이터 출력
				OutputStream out = client.getOutputStream();
				out.write(sendData.getBytes());
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
