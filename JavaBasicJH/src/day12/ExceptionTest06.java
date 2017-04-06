package day12;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionTest06 {
	// throws 키워드의 의미
	// 메서드를 호출하는 쪽으로 예외를 던져서 대신 처리하게 한다. (메소드 반환이랑 비슷)
	
	private static void a() throws FileNotFoundException {
		FileReader fr = new FileReader("data/a1.txt");
	}
	
	// RuntimeEcveption 관련 예외들은 예외처리를 선택적으로 할 수 있다.
	private static void b() throws ArithmeticException {
		// ArithmeticException
		System.out.println(1/0);
	}
	
	public static void main(String[] args) {
		try {
			a();
			b();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			
		}
		
		try {
			b();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		
	}
}