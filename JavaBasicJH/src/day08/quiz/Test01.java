/*
 * 	글자 인덱스 : 3
 * 	3번째 글자는 l 입니다.
 */
package day08.quiz;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		String s = "hello java";

		Scanner sc = new Scanner(System.in);
		System.out.print("글자 인덱스 : ");
		int index = Integer.parseInt(sc.nextLine())-1;
		char ch = s.charAt(index);
		System.out.printf("%d번째 글자는 %c 입니다.", index+1, ch);

	}
}
