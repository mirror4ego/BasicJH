package Exam02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.MyAppSqlConfig;


public class Login {
	public static boolean loginData(String id, String pass) {
		SqlSession sqlMapper;
		sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
		List <Member> list =  sqlMapper.selectList("Exam02.Member.selectAll");
		for (int i = 0 ; i < list.size(); i++) {
			if (list.get(i).getId().equals(id) & list.get(i).getPass().equals(pass)) {
				return true;
			}
		}
		return false;	
	}
	
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
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				String requestStartLine = br.readLine();
				String[] firstArr = requestStartLine.split(" ");
				System.out.println("요청방식 : " + firstArr[0]);
				String[] secondArr = firstArr[1].split("\\?");
				System.out.println("요청URL : " + secondArr[0]);
				String[] thirdArr = secondArr[1].split("&");
				System.out.println("파라미터 : ");
				String parameters="";
				for (String parameter : thirdArr){
					System.out.println(parameter);
					parameters += parameter + "<br>";
				}
				
				while (true) {
					String line = br.readLine();
					if (line.equals("")) break;
				}
				
				String[] idArr = thirdArr[0].split("=");
				String[] passArr = thirdArr[1].split("=");
				String idValue = idArr[1];
				String passValue = passArr[1];
				System.out.println(idValue);
				System.out.println(passValue);
				String msg = "로그인실패";
				if (loginData(idValue, passValue)) msg = "로그인성공";

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
		} 
	}
}
