package Exam01;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Exam01 {
	public static void main(String[] args) {
		
		while (true) {
			try {
				String input;
				Scanner sc = new Scanner(System.in);
				while (true) {
					System.out.print("도메인 주소를 입력하세요 : ");
					input = sc.nextLine();
					if (input.equals("quit")) {
						System.out.println("프로그램을 종료합니다.");
						System.exit(0);
					} else if (input.startsWith("www")) {
						break;
					} else {
						System.out.println("주소값은 www로 시작해야 합니다.");
					}
				}
				InetAddress[] addr = InetAddress.getAllByName(input);

				System.out.println("--------------------------");
				for (InetAddress inet : addr) {
					System.out.println(inet.getHostAddress());
				}
				System.out.println("--------------------------");
			} catch (UnknownHostException e) {				
				System.out.println("해당 주소는 존재하지 않습니다.");
			}
		}
	}
}
