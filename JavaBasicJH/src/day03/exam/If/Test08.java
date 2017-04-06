package day03.exam.If;

import java.util.Random;

public class Test08 {
	public static void main(String[]args){
		Random r = new Random();
		int i = r.nextInt(101)-1;
		
		System.out.println("생성된 수 : "+i);
		if (i % 2 == 0) {
			System.out.println("짝수입니다.");
		}
		else
			System.out.println("홀수입니다.");
		
	}	
}
