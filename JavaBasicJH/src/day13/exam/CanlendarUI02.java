package day13.exam;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CanlendarUI02 {
	Scanner sc = new Scanner(System.in);
	Calendar c = Calendar.getInstance();
	private int thisYear = c.get(Calendar.YEAR);
	private int thisMonth = c.get(Calendar.MONTH);
	private int maxDay;
	private int firstDay;

	
	public void thisMonth() {
		c.setTime(new Date());
		thisYear = c.get(Calendar.YEAR);
		thisMonth = c.get(Calendar.MONTH);
		maxDay = c.getActualMaximum(Calendar.DATE);
		c.set(Calendar.DAY_OF_MONTH, 1);
		firstDay = c.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("======================");
		printCalendar();
		System.out.println();
		System.out.println("======================");
	}

	
	public void previous() {
		if (thisMonth == 0) {
			thisMonth = 12;
			thisYear--;
		}
		c.set(Calendar.YEAR, thisYear);
		thisYear = c.get(Calendar.YEAR);
		c.set(Calendar.MONTH, thisMonth-1);
		thisMonth = c.get(Calendar.MONTH);
		maxDay = c.getActualMaximum(Calendar.DATE);
		c.set(Calendar.DAY_OF_MONTH, 1);
		firstDay = c.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("======================");
		printCalendar();
		System.out.println();
		System.out.println("======================");

		}
	
	public void next() {
		if (thisMonth == 11) {
			thisMonth = -1;
			thisYear++;
		}
		
		c.set(Calendar.YEAR, thisYear);
		thisYear = c.get(Calendar.YEAR);
		c.set(Calendar.MONTH, thisMonth+1);
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
