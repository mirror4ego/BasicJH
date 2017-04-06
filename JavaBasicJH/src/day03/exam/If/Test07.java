package day03.exam.If;

import java.util.Random;

public class Test07 {
	public static void main(String[]args){
		Random r = new Random();
		int i = r.nextInt(101)-1;
		
		System.out.println("생성된 점수 : "+i);
		if (i <= 60) {
			System.out.println("과락입니다.");
		}
	}
}
