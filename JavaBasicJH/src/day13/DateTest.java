package day13;

import java.io.File;
import java.util.Date; 

public class DateTest {
		public static void main(String[] args) {
			// 현재 시간 정보를 반환
			Date d = new Date (); // 왠만하면 Calendar를 사용
			System.out.println(d);  //d.toString()
			System.out.print(d.getYear()+1900+"년 "); //1900년 이후부터 년수
			System.out.print(d.getMonth()+"월 "); // deprecated 사용되지 않는 
			System.out.print(d.getDate()+"일 ");
			System.out.print(d.getDay()+"요일 ");
			System.out.print(d.getHours()+"시 ");
			System.out.print(d.getMinutes()+"분 ");
			System.out.print(d.getSeconds()+"초 ");
			System.out.println();
			
			// 현재 date시간정보를 long값으로 반환 
			long dTime = d.getTime();
			System.out.println(dTime);
			
			// 날짜 정보를 지정된 long값으로 변경(1970년 기준 +)
			d.setTime(10000);
			System.out.println(d);
			
			
			// 표준시에서 10.000초 추가된 결과값
			Date d2 = new Date(10000);
			System.out.println(d2);
			
			
			long time = System.currentTimeMillis();
			System.out.println("time " + time);
			
			// 시간 정보를 long 으로 얻은경우 시간 정보를 추출할 경우 사용
			Date d3 = new Date(time);
			System.out.println(d3);
			
			File f = new File("data/a.txt");
			System.out.println("a.txt 파일의 마지막 수정 시간 : "+ new Date(f.lastModified()));
			
		}
}
