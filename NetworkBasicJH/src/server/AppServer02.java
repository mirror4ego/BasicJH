/*
 * 서버에서 클라이언트로 데이터 전송 
 */
package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppServer02 {
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
				
				// 연결된 클라이언트에 데이터 출력
				OutputStream out = client.getOutputStream();
				// 한글 처리를 위해서 DataOutputStream 활용
				DataOutputStream dos = new DataOutputStream(out);
				dos.writeUTF("현재시각 : " + new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(new Date()));
				dos.close();
				out.close();
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
