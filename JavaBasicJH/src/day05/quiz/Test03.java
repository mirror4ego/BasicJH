/* 1. 랜덤한 수 생성(1-9)
 * 2. 랜덤하게 생성된 수가 배열에 몇개 있는지 카운트 한다.
 * 
 * 출력 형식>
 * 생성된 수 6은 배열에 1개가 포함되어 있습니다.
 */
package day05.quiz;

import java.util.*;

public class Test03 {
	public static void main(String[] args) {
		int[] arr = { 7, 2, 5, 1, 3, 8, 8, 2, 9, 6 };
		int count = 0;
		Random r = new Random();
		int num = r.nextInt(9) + 1;

		for (int i = 0; i < arr.length; i++) {
//			count = (num == arr[i]) ? count + 1 : count;
			if (num != arr[i]) {
				continue;
			}
			count++;
		}

		System.out.printf("생성된 수 %d은 배열에 %d개가 포함되어 있습니다.", num, count);

	}
}
