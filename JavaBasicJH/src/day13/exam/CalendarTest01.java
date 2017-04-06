package day13.exam;

import java.util.Scanner;

public class CalendarTest01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CalendarUI cui = new CalendarUI();
		outer: while (true) {
			System.out.print("항목을 선택하세요(1. 특정년도 날짜 보기  2. 특정월 날짜 보기  3. 종료 ) : ");
			try {
				int sNo = Integer.parseInt(sc.nextLine());
				if (sNo != 1 && sNo != 2 && sNo != 3 ) {
					throw new Exception("1~3사이");
				}
				switch (sNo) {
				case 1:
					cui.year();
					break;
				case 2:
					cui.month();
					break;
				case 3:
					System.out.println("종료");
					System.exit(0);
				}
			} catch (Throwable e) {
				System.out.println("다시 입력하세요.");
				continue outer;
			}
		}
	}
	
	
}
