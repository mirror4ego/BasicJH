/*
 * 	아래의 요구사항을 만족하는 프로그램 작성
 * 
 *  1. 랜덤한 수 (1-10) 사이의 숫자를 10개 생성해서 배열에 입력함
 *  2. 배열에 생성된 수 중에서 5보다 큰 수들의 합계를 계산함
 *  3. 배열에 생성된 수와 합계를 화면에 풀력
 *  
 */
package day05.quiz;

import java.util.*;

public class Test02 {
	public static void main(String[] args) {

		int[] arr = new int[10];
		Random r = new Random();
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(10) + 1;
			sum = (arr[i] > 5) ? sum + arr[i] : sum;
		}

		System.out.printf("생성된 수 : %s\n", Arrays.toString(arr));
		System.out.printf("5이상 수 합계 : %d", sum);
	}
}
