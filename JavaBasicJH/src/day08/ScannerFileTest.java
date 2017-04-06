package day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFileTest {
	public static void main(String[] args) throws FileNotFoundException {
		// 스캐너 클래스를 활용한 파일 읽기
		// 실제 이클립스 참조 경로
		// 프로젝트명/src/day08
		File f = new File("src/day08/test01.txt");

		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine() == true) {
			System.out.println(sc.nextLine());
		}
	}
}

