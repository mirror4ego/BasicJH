package day03;

import java.util.Random;

public class IfTest {
	public static void main(String[] args){
		Random r = new Random();
		int num = r.nextInt(10) + 1;  // 1 ~ 10
		System.out.println("num : " + num);
		
		/*
		// num 이 5보다 크다면 화면에 크다는 메세지를 출력한다.
		// num 의 값이 짝수인지 홀수인지 화면에 출력한다.
		// 5와 같은경우 같다 출력
		// 5보다 작은경우 작다 출력
		if (num > 5){
			System.out.println("크다");
			if (num % 2 == 0)
				System.out.println(num + " : 짝수");
			if (num % 2 != 0) 
				System.out.println(num + " : 홀수");				
		}
		else
			System.out.println("작다");
		 */
		/*
		if (num > 5){
			System.out.println("크다");
			if (num % 2 == 0){
				System.out.println(num + " : 짝수");
			}
			else {//if문의 조건이 false일경우
				System.out.println(num + " : 홀수");
			}
		}
		else {
		if (num < 5) {
			System.out.println("작다");
		}
		else {
			System.out.println("같다");
			}
			}
			
				
		 */
		
		if (num > 5){
			System.out.println("크다");

			/*			
			String msg = "홀수";
			if (num % 2 == 0){
				msg = "짝수";
			}
			System.out.printf("%d : %s\n", num, msg);
			*/
			
			System.out.printf("%d : %s", num, (num % 2 ==0)? "짝수" : "홀수");
		}
		else if (num < 5) {
			System.out.println("작다");
		}
		else {
			System.out.println("같다");
		}
	}
}
