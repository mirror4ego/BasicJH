package day10.pack.b;

import day10.pack.a.Data;

public class Test02 extends Data {
	public Test02() {
		System.out.println(name);
		System.out.println(pass);
		/* 상속 관계의 클래스가 다른 패키지의 데이타를 접근 할 경우 public과 protected까지 접근이 가능하다
		System.out.println(email);
		System.out.println(money);
		*/
	}
}	
