package day12;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionTest07 {
	private static void a() throws FileNotFoundException {
		try {
			FileReader fr = new FileReader("data/a.txt");
		} catch (FileNotFoundException e){
			System.out.println("예외의 직접 처리 구문 실행");
			throw e; // 발생한 예외를 다시 던져준다.
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
