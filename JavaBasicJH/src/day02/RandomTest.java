package day02;

// Random을 사용하기 위해서 위치 알려주기
// 패키지명.클래스명
import java.util.Random;  //다른 패키지 위치에 있는 클래스에 접근할때 쓰는 키워드


public class RandomTest {
	public static void main(String[]args){
		// 랜덤한 값을 사용하기 위해서 Random 클래스를 활용
		Random r = new Random();
		int num = r.nextInt(10); //0~9까지 10개숫자 나옴
		System.out.println("생성된 수 : "+num);
		
		for (int x=1; x<7; x++) {
		int lotto = r.nextInt(45)+1;
		System.out.println("로또번호 : "+lotto);
		}
		
	}
}
