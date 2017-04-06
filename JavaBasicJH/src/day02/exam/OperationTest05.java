package day02.exam;

import java.util.Scanner;

public class OperationTest05 {
	public static void main(String [] args){
		final float WON = (float)1092.50;
		Scanner sc = new Scanner(System.in);
		System.out.print("달러를 입력하세요 ? ");
		int i = Integer.parseInt(sc.nextLine());
		float result = i*WON;		
		System.out.printf("원화 : %.2f원", result);
				
		
		
		
	}
}
