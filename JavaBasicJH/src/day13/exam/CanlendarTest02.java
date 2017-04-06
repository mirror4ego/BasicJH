package day13.exam;

import java.util.Scanner;

public class CanlendarTest02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CanlendarUI02 cui = new CanlendarUI02();
		outer: while (true) {
			System.out.print("항목을 선택하세요(1.현재달  2.전달  3.다음달 0.종료 ) : ");
			try {
				int sNo = Integer.parseInt(sc.nextLine());
				if (sNo != 1 && sNo != 2 && sNo != 3 && sNo != 0) {
					throw new Exception("1~3사이");
				}
				switch (sNo) {
				case 1:
					cui.thisMonth();
					break;
				case 2:
					cui.previous();
					break;
				case 3:
					cui.next();
					break;
				case 0:
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
