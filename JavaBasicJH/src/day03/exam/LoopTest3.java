package day03.exam;

import java.util.Scanner;

public class LoopTest3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수를 입력하세요 : ");
		int i = Integer.parseInt(sc.nextLine());
		
		System.out.print("수를 입력하세요 : ");		
		int j = Integer.parseInt(sc.nextLine());
		
		int l = (i<j)?i:j;
		int m = (i>j)?i:j;
		int sum = 0;
		
		for (int k = l ; k<m+1 ; k++){
			sum += k;
		}
		System.out.printf("%d 부터 %d까지의 합은 %d입니다.",l,m,sum);
	}
}

