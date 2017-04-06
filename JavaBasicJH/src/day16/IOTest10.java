package day16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class IOTest10 {
	public static void main(String[] args) {
		try ( // 여기 안에 선언된 객체는 자동 close된다. autoclosable 인터페이스가 상속되어있으면  1.7 부터 가능
				FileReader fr = new FileReader("data/a.txt");
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter("data/a3.txt");
				BufferedWriter bw = new BufferedWriter(fw);) {
			while (true) {
				int ch = br.read();
				if (ch == -1)
					break;
				bw.write(ch);
			}
			System.out.println("테스트 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
