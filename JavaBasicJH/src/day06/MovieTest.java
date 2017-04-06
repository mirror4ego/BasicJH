/* 
 * 	영화 정보 등록
 * 
 * 	제목 : 비 오는 날
 *  배우 : 주윤발
 *  제목 : 곡성
 *  배우 : 황정민
 *  제목 : 사냥
 *  배우 : 안성기, 조진웅
 *  
 *  입력된 영화 정보
 *  ----------------------------
 *  제목          배우
 *  ----------------------------
 *  비 오는 날   주윤발
 *  곡성         황정민
 *  배우         안성기, 조진웅
 *  ----------------------------
 */
package day06;

import java.util.*;

class Movie {
	String title;
	String actors;
}

public class MovieTest {
	public static void main(String[] args) {
		Movie[] list = new Movie[3];

		// 배열의 내용 확인
		// System.out.println(Arrays.toString(list));

		System.out.println("영화 정보 등록");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < list.length; i++) {
			list[i] = new Movie();
			System.out.print("제목 : ");
			list[i].title = sc.nextLine();
			System.out.print("배우 : ");
			list[i].actors = sc.nextLine();
		}
		
		// 등록된 정보 출력
		System.out.println("입력된 영화 정보");
		System.out.println("---------------------------");
		System.out.println("제목		배우");
		System.out.println("---------------------------");
		for (int i = 0; i < list.length; i++) {
			Movie m = list[i];
			System.out.println(m.title +"	"+ m.actors);
		}
		System.out.println("---------------------------");
		
	}
}
