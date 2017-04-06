package day04.quiz;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력 하세요(2 - 9) : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("두번째 숫자를 입력 하세요(2 - 9) : ");
		int num2 = Integer.parseInt(sc.nextLine());

		System.out.println("---------------------------------------------");
		for (int i = num1; i <= num2; i++) {
			System.out.print(i + "단 ");
			for (int k = 1; k < 10; k++) {
				System.out.printf("%4d", i * k);
			}
			System.out.println();
		}
		System.out.println("---------------------------------------------");
	}
}
