package day07;

import java.util.Random;

public class MethodTest02 {
	public static void main(String[] args) {
		MethodSub02 sub = new MethodSub02();
		
		// 만약, 메서드가 반환값을 제공하면 반환값을 받을수 있다.
		// int i = 1(리턴값);
		// 호출값은 동일한 변수타입으로 받아줘야한다.
		
		int i = sub.method1();
		System.out.println(i);
		
		int j = sub.method2();
		System.out.println(j);

		char k = sub.method3();
		System.out.println(k);
		
		i = sub.method4(new Random());
		System.out.println(i);
		
		String a = sub.method5();
		System.out.println(a);
		
		Random r = sub.method6();
		
		int [] iArr = sub.method7();
		
		HaHaHa b = new HaHaHa();
		b = sub.method8(new HoHoHo());
		
		
	}
}
