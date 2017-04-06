package quiz.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TestServer01 {
	public static void main(String[] args) {
		
		try {
			// 서버 구동
			int count = 0;
			String[] sArr = new String[3];
			sArr[0] = "1000";
			sArr[1] = "2000";
			sArr[2] = "3000";
			Random r = new Random();
			
			ServerSocket server = new ServerSocket(10001);
			System.out.println("서버 구동됨... 클라이언트 요청 대기중...");

			while (true) {
				count++;
				int random;
				while (true) {
					random = r.nextInt(sArr.length);
					if (!sArr[random].equals("0")) {
						break;
					}
				}
				
				// 클라이언트가의 요청이 왔을때 실행됨.
				Socket client = server.accept();
				System.out.println("클라이언트 접속됨 : " + client);
				// 연결된 클라이언트에 데이터 출력
				OutputStream out = client.getOutputStream();
				// 한글 처리를 위해서 DataOutputStream 활용
				DataOutputStream dos = new DataOutputStream(out);
				if (count > sArr.length) {
					dos.writeUTF("데이터 소진");
				} else {
					dos.writeUTF(sArr[random]);					
					sArr[random] = "0";
				}
				dos.close();
				out.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
