package day12.quiz;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test01 {
	// 오류X  1 2 4 5
	// 오류O  1 3 4 5
	// 예외처리 루틴 없을때 (비정상종료) : 1 4
	// return과 함께 사용시 finally 실행됨
	public static void main(String[] args) {
		System.out.println(1);
		try {
			// System.out.println(1/0);
			FileReader fr = new FileReader("data/a1.txt");
			System.out.println(2);
		} catch (FileNotFoundException e) {
			System.out.println(3);
			return; // finally 실행됨
		} finally {  // 예외처리가 안되서 런타임 오류가 나도 실행됨
			System.out.println(4);
		}
		System.out.println(5); 
	}
}
