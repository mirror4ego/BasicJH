/*
 * 1부터 1000사이의 숫자를 맞추는 게임입니다.(총 10회)
 * 1회. 숫자를 입력하세요(1-1000) : 3
 * 3보다 큰 값 입니다.
 * 2회. 숫자를 입력하세요(1-1000) : 500
 * 500보다 작은 값 입니다.
 * 3회. 숫자를 입력하세요(1-1000) : 250
 * 정답입니다.
 * 
 * 10회안에 맞추기 게임에 실패하였습니다.
 * 정답은 85입니다. 
 */

package day03.quiz;

import java.util.Random;
import java.util.Scanner;


public class Test02 {
	public static void main(String[] args) {
		System.out.println("1부터 1000사이의 숫자를 맞추는 게임입니다.(총 10회)");
		Random r = new Random();
		int num = r.nextInt(1000)+1;
		
		for (int i = 1;i < 11;i++){
			System.out.printf("%d회. 숫자를 입력하세요(1-1000) : ", i);
			Scanner sc = new Scanner(System.in);
			int answer = Integer.parseInt(sc.nextLine());
			
			if (answer == num) {
				System.out.println("정답입니다.");
				break;
			}
			else if (answer > num){
				System.out.printf("%d보다 작은값을 입력하세요.\n", answer);
			}
			else {
				System.out.printf("%d보다 큰값을 입력하세요.\n", answer);
			}
			if (i == 10) {
				System.out.println("10회안에 정답을 맞추는데 실패하셨습니다");
				System.out.printf("정답은 %d입니다", num);
		}			
	}
	}
}
