/*
 * 	랜덤한 숫자 생성 (1 ~ 12)
 *  생성된 숫자에 따라서 아래와 같은 출력이 되도록 코드 작성
 *  
 *  12, 1, 2 라면  "겨울입니다" 출력
 *  3, 4, 5 라면 "봄입니다" 출력
 *  6, 7, 8 라면 "여름입니다" 출력
 *  9, 10, 11 라면 "가을입니다" 출력
 * 
 */
package day03.quiz;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		Random r = new Random();
		int num = r.nextInt(12) + 1;
		System.out.println(num);

		String ss = "겨울";

		switch (num) {

		case 3:
		case 4:
		case 5:
			ss = "봄";
			break;

		case 6:
		case 7:
		case 8:
			ss = "여름";
			break;

		case 9:
		case 10:
		case 11:
			ss = "가을";
			break;
		}
		System.out.printf("%s입니다.", ss);
	}

}