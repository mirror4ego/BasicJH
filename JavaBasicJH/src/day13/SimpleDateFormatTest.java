package day13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFormatTest {
	public static void main(String[] args) throws ParseException {
		Calendar c = Calendar.getInstance();
		// 2016-07-13 11:06
		// pattern에 지정된 형식으로 날짜를 문자열로 변환
		String pattern = "yyyy-MM-dd hh:mm"; // 패턴 설정
		SimpleDateFormat sdf = new SimpleDateFormat(pattern); // 패턴 객체 생성 및 적용
		String result = sdf.format(new Date()); // Date객체 입력
		System.out.println(result); // 결과값 출력

		String strDate = "2016-01-01 00:00";
		try {
			Date d2 = sdf.parse(strDate); // 문자열이 가지고 있는 날짜정보를 날짜객체로 변경
			System.out.println(d2);
		} catch (ParseException e) {
			System.out.println("날짜 파싱중 오류 발생");
			e.printStackTrace();
		}
		
		
		
		
		
		// SimpleDateFormat 클래스를 사용하기 위한 기본 조건
		// 1. 날짜정보
		// 2. 패턴정보(년, 월, 일, 시...)
		//   - y : 년 
		//   - M : 월
		//   - d : 일
		//   - H : 24시
		//   - h : 12시 
		//   - m : 분 
		//   - s : 초
		//   - E : 요일 
		//  2016-07-13 11:06 -> yyyy-MM-dd hh:mm
		
	}
}
