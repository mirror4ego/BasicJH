package day02;

public class ConstantTest {
	public static void main(String[]args){
		
		final int PORT = 8080;
		// PORT = 9999;  상수로 선언된 변수는 값을 바꿀수 없다.
		System.out.println(PORT);
		
//		String path = "c:\java81"; \ 오류
		String path = "c:\\java81"; //  "\"를 사용하려면 앞에 \를 하나더 넣어야함
		System.out.println(path);
		
//		String qtmark = ""java81""; " 오류  quotation mark
		String qtmark = "\"java81\"";
		System.out.println(qtmark);
		
		
// 나의 이름은 "아무개"입니다.
// 출력 작성

		String name = "나의 이름은 \"송재홍\"입니다.";
		System.out.println(name);
		
		
		
	}

}
