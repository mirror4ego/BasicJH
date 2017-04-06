package day10.pack.b;

import day10.pack.a.Data;

public class Test01 {
	public static void main(String[] args) {
		Data d = new Data();
		System.out.println(d.name);
/*
 * 관계없는 외부 패키지의 클래스는 public 접근 제한자만 사용가능하다.
 */	
//		System.out.println(d.pass);
//		System.out.println(d.email);
//		System.out.println(d.money);
	}	
}

