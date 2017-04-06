package day13;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
	public static void main(String[] args) {
		// 객체 얻기
		Calendar c = Calendar.getInstance(); // Calendar는 추상클래스라 객체를 바로 얻을수 없음
		System.out.println(c);
		
		int val = c.getActualMaximum(Calendar.DATE); //	현재월
		System.out.println(val);
		c.set(Calendar.MONTH, 1); // 2월
		val = c.getActualMaximum(Calendar.DATE);
		System.out.println(val);
		c.set(Calendar.MONTH, 2);
		val = c.getActualMaximum(Calendar.DATE);
		System.out.println(val);
		c.set(Calendar.MONTH, 3);
		val = c.getActualMaximum(Calendar.DATE);
		System.out.println(val);
		
		/*
		// 날짜정보 추출하기
//		System.out.println(c.get(1)); // 1 YEAR
		System.out.println(c.get(Calendar.YEAR));
//		System.out.println(c.get(2)); // 2 MONTH(현재월-1)
		System.out.println(c.get(Calendar.MONTH));
		System.out.println(c.get(Calendar.DAY_OF_MONTH)+1);
		System.out.println(c.get(Calendar.HOUR));
		dystem.out.println(c.get(Calendar.MINUTE));
		System.out.println(c.get(Calendar.SECOND));
		int day =  c.get(Calendar.DAY_OF_WEEK);
//		String days="";
//		switch (day) {
//			case 1 : days="일요일"; break;
//			case 2 : days="월요일"; break;
//			case 3 : days="화요일"; break;
//			case 4 : days="수요일"; break;
//			case 5 : days="목요일"; break;
//			case 6 : days="금요일"; break;
//			case 7 : days="토요일"; break;
//		}
//		System.out.println("요일 : " + days);
		
		String[] dArr = { "", "일", "월", "화", "수", "목", "금", "토", "일" };
		System.out.println("요일 : " + dArr[day]);
		
		// 2015/2/20 로 바꾸기
//		c.set(2015, 1, 20); // 월은 0부터 시작 // 전체다 바꾸기
		
		// 현재년도 현재월에서 1일로 
		c.set(Calendar.DAY_OF_MONTH, 1); // 특정 필드 값만 바꾸기
		day = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("요일 : " + dArr[day]);
		
		// Date 객체를 Calendar로 적용하기
		Date d = new Date(1000);
		c.setTime(d);
		System.out.println(c.get(Calendar.YEAR));
		
		// Calendar 객체를 Date 객체로 변경하기
		Date d2 = c.getTime();
		System.out.println(d2);
		
		// long 형태의 시간 정보를 바탕으로 Calendar의 시간 정보를 변경하기
		File f = new File("data/a.txt");
		long time = f.lastModified();
		c.setTimeInMillis(time);
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		*/
		
		
	}
}
