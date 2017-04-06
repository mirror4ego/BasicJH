/* 
 * 전체를 건너뛰려변 break
 * 현재를 건너뛰려면 continue
 */

package day03;

import java.util.Random;

public class ContinueTest {
public static void main(String[] args) {
	
	Random r = new Random();
	int skipNum = r.nextInt(10) + 1;
	System.out.println("skipNum : " + skipNum);
//	
//    for (int i = 1; i < 6 ; i++) {
//		if (i == skipNum) {
//		continue;  //만나면 아래로 가지않고 다음 반복으로 간다.
//		}
//		System.out.println(i);
//	}
	
	skipNum = 2;
	outer: for (int count = 1; count < 3; count++){
		for (int i = 1; i < 6 ; i++) {
			
			if (i == skipNum) {
				continue outer;
				
			}
			System.out.println(i);
		}
	}
}
}
