/*
 * 1. 배열 크기3
 * 2. 랜덤수 (1-10)입력
 * 3. 생성된수를 *로 표시
 * 
 * 출력형식
 * 0번째 입력된 수 3 ***
 * 1번째 입력된 수 2 **
 * 2번째 입력된 수 7 *******
 */
package day05.quiz;

import java.util.Random;

public class Test04 {
	public static void main(String[] args) {
		
		Random r = new Random();
		int[] arr = new int[3];
		String[] result = new String[3];
		
		for (int i = 0; i<arr.length; i++){
			arr[i] = r.nextInt(10)+1;
			result[i] = "";
			for (int j = 1; j <= arr[i]; j++){
				result[i] += "*";
			}
			System.out.printf("%d번째 입력된 수 %3d  %s\n",i, arr[i], result[i]);
		}
		
	}
}
