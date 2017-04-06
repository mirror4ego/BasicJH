package day13.quiz;

import java.util.Calendar;

public class Test01 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		int thisYear = c.get(Calendar.YEAR); // 올해
		int thisMonth = c.get(Calendar.MONTH); // 이번달
		int maxDay = c.getActualMaximum(Calendar.DATE); // 이번달 총 날짜
		c.set(Calendar.DAY_OF_MONTH, 1);
		int firstDay = c.get(Calendar.DAY_OF_WEEK); // 첫째날 요일
		c.set(Calendar.DAY_OF_MONTH, maxDay);
		int lastDay = c.get(Calendar.DAY_OF_WEEK); // 마지막 요일
		c.set(Calendar.MONTH, thisMonth - 1);
		int lastMaxDay = c.getActualMaximum(Calendar.DATE); // 전달 최대 일

		
		System.out.printf("%d년 %d월\n", thisYear, thisMonth + 1);
		System.out.println(" 일    월    화     수     목     금    토");
		int count = 0;
		int x = 1;
		outer: while (true) {
			if (count == 0) {
				x = firstDay;
				for (int i = 1; i < x; i++) {
//					System.out.printf("%2d ", lastMaxDay - firstDay + i);
					System.out.print("   ");
				}
			} else {
				x = 1;
			}

			for (int i = x; i < 8; i++) {
				System.out.printf("%2d ", count + 1);
				if (count++ == maxDay - 1) {
//					for (int j = 1; j < 8 - lastDay; j++) {
//						System.out.printf("%2d ", j);
//					}
					break outer;
				}
			}
			System.out.println();
		}
	}
}
