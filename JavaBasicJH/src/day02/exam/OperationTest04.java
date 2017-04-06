package day02.exam;

import java.util.Scanner;

public class OperationTest04 {
	public static void main(String [] args){
		Scanner sc1 = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int i = Integer.parseInt(sc1.nextLine());
		Scanner sc2 = new Scanner(System.in);
		System.out.print("나눌 수를 입력하세요 : ");
		int j = Integer.parseInt(sc2.nextLine());
		
		System.out.println("몫 : " + i/j);
		System.out.println("나머지 : " + i%j);
		
	}
}
