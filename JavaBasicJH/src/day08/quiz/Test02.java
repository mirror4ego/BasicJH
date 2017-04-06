/*
 * 프로그램 실행시
 * olleH 로 출력되도록 코딩 완성
 */
package day08.quiz;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		// 1
		String s = "Hello";
		for (int i = s.length() - 1; i > -1; i--) {
			System.out.print(s.charAt(i));
		}
		System.out.println();

		// 2
		StringUtil su = new StringUtil();
		System.out.println(su.reverse("World"));

		// 3
//		Scanner sc = new Scanner(System.in);
//		String text = sc.nextLine();
//		char c = sc.nextLine().charAt(0);
//		System.out.printf("%s , %c  ->  %d\n", text, c, su.findCharCount(text, c));
		
		
		System.out.println('2'-'0');
			
				
	}
}