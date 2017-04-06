package day03.exam.If;

import java.util.Scanner;

public class Test02 {
	public static void main(String [] args){
		System.out.print("물건값을 입력하세요(만원) : ");
		Scanner sc = new Scanner(System.in);
		int price = Integer.parseInt(sc.nextLine()) * 10000;
		int result;
						
		
	if (price <= 100000) {
		result = price * 97 / 100;		
	}
	else if (price <=300000) {
		result = price * 95 / 100;
	}
	else if (price <=1000000) {
		result = price * 92 / 100;
	}
	else {
		result = price * 90 / 100;		
	}
	
	System.out.printf("할인된 금액은 %d원 입니다.", result);
		
	}
	
	}
