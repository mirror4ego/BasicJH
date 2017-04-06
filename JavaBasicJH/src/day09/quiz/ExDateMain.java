package day09.quiz;

class ExDate {
	
	private int year;
	private int month;
	private int date;
	
	ExDate () {
		this (2013, 4, 01);
	}
	
	ExDate (int year, int month, int date) {
		this.year = year;
		this.month = month;
		this.date = date;				
	}
	
	void showDate () {
		System.out.printf("%d년 %d월 %02d일\n", year, month, date);
	}
	
	/**
	 *  1자리수면 앞에 0을 붙여주는 클래스 
	 */
	String pad (int date) {
		return date < 10 ? "0" + date : String.valueOf(date);
	}
}

public class ExDateMain {
	public static void main(String[] args) {
		ExDate ex01 = new ExDate();
		ex01.showDate();
		ExDate ex02 = new ExDate(2013, 8, 11);
		ex02.showDate();
	}

}
