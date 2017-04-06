package day01;

public class ChangeMainTest {
	
	// 주석 : JVM에게 해석하지 않도록 알려준다.
	// 주석문은 .class 파일에 포함되지 않는다.
	/* 범위 주석문, 다중행 주석 */
	/*
	public static void main(String[] args) {
		System.out.println("A");
	}
	*/

	// public 와 static 의 위치는 변경이 가능함
	// [] 와 args(이름)은 위치 변경이 가능함
	// args의 이름은 변경이 가능함
	static public void main(String a []) {
		System.out.println("A");
	}
}








