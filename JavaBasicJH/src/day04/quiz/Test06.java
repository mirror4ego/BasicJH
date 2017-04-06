package day04.quiz;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("출력할 행의 수를 입력하세요(1-10) : ");
		int a = Integer.parseInt(sc.nextLine());

		System.out.print("출력할 열의 수를 입력하세요(1-10) : ");
		int b = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++) {
				if ((a + i) % 2 == 0)
					System.out.print(">");
				else
					System.out.print("<");
			}
			System.out.println();
		}
	}
}

/*
Scanner s = new Scanner(System.in);

System.out.print("출력할 행의 수를 입력하세요(1-10) : ");
int row = Integer.parseInt(s.nextLine());

System.out.print("출력할 열의 수를 입력하세요(1-10) : ");
int column = Integer.parseInt(s.nextLine());

int count = 1;
char ch = '\u0000';
while (row >= 1) {
ch = (row % 2 == 1) ? '<' : '>';
while (count <= column) {
System.out.print(ch);
count++;
}
row--;
count = 1;
System.out.println();
}
*/
