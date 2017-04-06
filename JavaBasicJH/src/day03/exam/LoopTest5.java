package day03.exam;

import java.util.Scanner;

public class LoopTest5 {
	public static void main(String[] args) {
		
		System.out.print("수를 입력하세요(2-10) : ");
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
	
		System.out.print(num+"의 배수 : ");
		for (int i = 1; i<11; i++){
			System.out.print(" "+i*num);
		}
		
	
	}
}
