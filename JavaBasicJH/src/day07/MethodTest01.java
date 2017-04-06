package day07;
// 교육생
import java.util.*;

public class MethodTest01 {
	public static void main(String[] args) {
				MethodSub01 sub = new MethodSub01();
		
		System.out.println("--------");
		sub.method1();
		sub.method2(0);
		sub.method3(0,2);
		sub.method4("hello");
		sub.method5('c');
		sub.method6(new Random());
		sub.method7(new Scanner(System.in));
		System.out.println("--------");
		
		
		
	}
}
