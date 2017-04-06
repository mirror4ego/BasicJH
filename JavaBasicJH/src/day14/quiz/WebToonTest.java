package day14.quiz;
// 웹툰번호:제목:요일:작가:장르:평점
// 장르 : 1.판타지 2.무협 3.순정 4.액션 5.SF 6.학원물
//웹툰 관리 프로그램
//-------------------------
//1. 전체조회
//2. 작가조회
//3. 장르조회
//4. 평점조회
//5. 제목조회
//6. 종료
//--------------------------
//메뉴 (1-6) : 1

import java.io.FileNotFoundException;

public class WebToonTest {
	public static void main(String[] args) throws FileNotFoundException {
		WebToonUI ui = new WebToonUI();
		ui.start();
		
	}
}
