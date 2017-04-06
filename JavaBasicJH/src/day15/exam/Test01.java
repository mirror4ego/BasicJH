package day15.exam;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test01 {
	public static void main(String[] args) {
		InputStream in = System.in;
		InputStreamReader isr = new InputStreamReader(in);
		try {
			 while (true) {
				System.out.print("한문자를 입력하세요 : ");
				outer: for (int i = 1; i<4; i++) {
					int ch = isr.read();
					if (ch == '\n' || ch == '\r' ){
						continue outer;
					}
					if ((char)ch == 'Q' || (char)ch == 'q') {
						System.out.println("종료합니다.");
						System.exit(0);
					}
					System.out.println("입력된 문자는 " + (char) ch + " 입니다");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
