package day03.exam;

import java.util.Scanner;

public class LoopTest2 {
	public static void main(String[] args) {
		
		int sum1=0, sum2=0, sum3=0;
		for (int i = 1;i<101;i++){
			if (i%2==1){
				sum1 += i;
				}
			else
				sum2 += i;
			sum3 += i;
		}
		System.out.printf("홀수합계 : %d\n", sum1);
		System.out.printf("짝수합계 : %d\n", sum2);
		System.out.printf("전체합계 : %d\n", sum3);
	}
}
