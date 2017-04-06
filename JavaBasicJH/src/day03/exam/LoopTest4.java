package day03.exam;

import java.util.Random;

public class LoopTest4 {
	public static void main(String[] args) {
		System.out.print("생성숫자 : ");
		int sum = 0;
		double avr = 0;		
		for (int i = 1; i<6; i++){
			Random r = new Random();
			int num = r.nextInt(100)+1;
			sum += num;
			System.out.print(" "+num);
		}
		System.out.println();
		avr = sum / 5;
		System.out.printf("합계 : %d\n",sum);
		System.out.printf("평균 : %.2f\n",avr);
	
	}
}
