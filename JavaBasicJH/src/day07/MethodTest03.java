package day07;

import java.util.Arrays;
import java.util.Scanner;

public class MethodTest03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MethodSub03 sub = new MethodSub03();
//		System.out.print("수행할 연산 (1. + 2.- 3.* 4./) : ");
//		int operation = Integer.parseInt(sc.nextLine());
//		System.out.print("수1 : ");
//		int num1 = Integer.parseInt(sc.nextLine());
//		System.out.print("수2 : ");
//		int num2 = Integer.parseInt(sc.nextLine());
//		int result = sub.cal(operation, num1, num2);
//		System.out.println("결과값 : " + result);
		
		int [] arr = sub.getRandomNum(Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
		System.out.println(Arrays.toString(arr));
	}
}
