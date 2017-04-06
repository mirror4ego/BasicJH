package day12;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionTest08 {
	private static void a() throws FileNotFoundException {
		try {
			FileReader fr = new FileReader("data/a1.txt");
		} catch (Exception e){
			System.out.println("예외의 직접 처리 구문 실행");
			throw new FileNotFoundException(e.getMessage()); // 새로운 클래스 객체를 만들어서 던진다.
		}
	}
	
	public static void main(String[] args) {
		try {
			a();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
