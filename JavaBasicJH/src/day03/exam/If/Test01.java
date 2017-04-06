package day03.exam.If;

import java.util.Scanner;

public class Test01 {
	public static void main(String [] args){
		
		System.out.print("나이를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine()); 
		
		String price = "2500원";
		
		if (num < 5) {
			price = "무료";			
		}
		else if (num >= 12) {
			price = "5000원";
		}
		
		System.out.printf("입장료는 %s 입니다.", price);
	}
}
