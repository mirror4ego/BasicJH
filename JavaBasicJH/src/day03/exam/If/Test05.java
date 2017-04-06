package day03.exam.If;

import java.util.Scanner;

public class Test05 {
	public static void main(String[]args){
		
		System.out.print("숫자를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		int result;
		
		if (num < 0) {
			result = num - num - num;
		}
		else result = num;
		
		
		System.out.printf("%d의 절대값 : %d",num,result);
		
	}

}
