package day02;

import java.util.Scanner;

public class OperationTest01 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자입력 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("숫자입력 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		int result = (num1 > num2) ? num1 : num2;
		System.out.printf("%d와 %d 중에서 큰수는 %d 입니다.", num1, num2, result);
		
	}

}
