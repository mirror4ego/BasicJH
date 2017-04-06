package day13.exam;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarUI {
	private int thisYear;
	private int thisMonth;
	private int maxDay;
	private int firstDay;
	Scanner sc = new Scanner(System.in);

	
	public void year() {
		Calendar c = Calendar.getInstance();
		System.out.print("년도를 입력하세요 : ");
		int year = Integer.parseInt(sc.nextLine());
		c.set(Calendar.YEAR, year);
		thisYear = c.get(Calendar.YEAR);
		for (int i = 0 ; i < 12; i++) {			
			c.set(Calendar.MONTH, i);
			thisMonth = c.get(Calendar.MONTH);
			maxDay = c.getActualMaximum(Calendar.DATE);
			c.set(Calendar.DAY_OF_MONTH, 1);
			firstDay = c.get(Calendar.DAY_OF_WEEK);
			
			System.out.println("======================");
			printCalendar();
			System.out.println();
			System.out.println("======================");
		}
	}
	
	public void month() {
		Calendar c = Calendar.getInstance();
		System.out.print("년도를 입력하세요 : ");
		int year = Integer.parseInt(sc.nextLine());
		c.set(Calendar.YEAR, year);
		thisYear = c.get(Calendar.YEAR);
		
		System.out.print("월을 입력하세요 : ");
		int month = Integer.parseInt(sc.nextLine());
		c.set(Calendar.MONTH, month-1);
		thisMonth = c.get(Calendar.MONTH);	
		maxDay = c.getActualMaximum(Calendar.DATE);
		c.set(Calendar.DAY_OF_MONTH, 1);
		firstDay = c.get(Calendar.DAY_OF_WEEK);
		
			
			System.out.println("======================");
			printCalendar();
			System.out.println();
			System.out.println("======================");
		}
	

	public void printCalendar() {
		System.out.printf("%d년 %d월\n", thisYear, thisMonth + 1);
		System.out.println("----------------------");
		System.out.println(" 일    월    화     수     목     금    토");
		System.out.println("----------------------");
		int count = 0;
		int x = 1;
		outer: while (true) {
			if (count == 0) {
				x = firstDay;
				for (int i = 1; i < x; i++) {
					System.out.print("   ");
				}
			} else {
				x = 1;
			}

			for (int i = x; i < 8; i++) {
				System.out.printf("%2d ", count + 1);
				if (count++ == maxDay - 1) {
					break outer;
				}
			}
			System.out.println();
		}
	}
	
	
}