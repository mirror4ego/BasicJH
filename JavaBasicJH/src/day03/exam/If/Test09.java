package day03.exam.If;

import java.util.Random;

public class Test09 {
	public static void main(String[]args){
		Random r = new Random();
		int i = r.nextInt(101)-1;
		String result = "잘했어요.";
		
		System.out.println("생성된 점수 : "+i);
		if (i < 60) {
			result = "재수강";
		}
		else if (i > 90) {
			result = "장학생";
		}
	
	    System.out.println(result);
	}
		
}
