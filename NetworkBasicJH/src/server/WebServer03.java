package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class WebServer03 {
	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			// 서버 구동
			server = new ServerSocket(10001);
			System.out.println("서버 구동됨... 클라이언트 요청 대기중...");

			while (true) {
				// 클라이언트가의 요청이 왔을때 실행됨.
				Socket client = server.accept();

				// 사용자의 요청에 대한 프로토콜 정보 확인하기
				InputStream in = client.getInputStream();
				HttpServletRequest request = new HttpServletRequest(in);
				String method = request.getMethod();
				String uri = request.getRequestUri();
				Map<String, String> paramMap = request.getParamMap();
				
				String pageNo = request.getParameter("pageNo");
				String sType = request.getParameter("sType");
				String sWord = request.getParameter("sWord");
				System.out.println("method : " + method);
				System.out.println("uri : " + uri);
				System.out.println("pageNo : " + pageNo);
				System.out.println("sType : " + sType);
				System.out.println("sWord : " + sWord);
				System.out.println("paramMap : " + paramMap);
				
				String msg = "OK";

				// HTTP 프로토콜 방식으로 메세지 작성
				String startLine = "HTTP/1.1 200 OK\r\n";
				String header = "Cache-Control: no-cache\r\n" + "Content-Type: text/html; charset=UTF-8\r\n"
						+ "Content-Length: " + msg.getBytes().length + "\r\n\r\n";
				String body = msg;
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
