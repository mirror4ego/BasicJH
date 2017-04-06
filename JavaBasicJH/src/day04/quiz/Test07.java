package day04.quiz;

import java.util.Scanner;
import java.util.Random;

public class Test07 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		System.out.println("로또 번호 추출기");
		System.out.print("금액을 입력하세요 : ");
		int price = Integer.parseInt(sc.nextLine());
		int ea = price / 1000;

		for (int i = 1; i <= ea; i++) {
			System.out.printf("Set %d :", i);
			for (int j = 1; j < 7; j++) {
				System.out.printf(" %2d", r.nextInt(45) + 1);
			}
			System.out.println();
		}

	}
}
