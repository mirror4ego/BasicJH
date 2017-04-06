package day02.exam;

import java.util.Scanner;

public class OperationTest03 {
	public static void main(String [] args){
		final float PI  = (float)3.141592;
		Scanner sc = new Scanner(System.in);
		System.out.print("원의 반지름을 입력하세요 : ");
		int hr = Integer.parseInt(sc.nextLine());
		float result = PI*hr*hr;
		System.out.printf("반지름이 %d인 원의 면적은 %.4f입니다.", hr, result);
		
			
		
	}
}
