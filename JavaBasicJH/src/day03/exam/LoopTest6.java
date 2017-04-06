package day03.exam;

import java.util.Scanner;

public class LoopTest6 {
	public static void main(String[] args) {
		
		System.out.print("수를 입력하세요 : ");		
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
				
		int sum = 0;
		for (int i = 1; i<num; i++) {
			if (num%i==0){
				sum = sum + i;	
			}		
		}
		if (sum==num){
			System.out.printf("%d는 완전수 입니다.",num);
		}
		else System.out.printf("%d는 완전수가 아닙니다.",num);
	}
}
