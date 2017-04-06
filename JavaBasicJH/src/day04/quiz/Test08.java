/*
 * 출력형식
 * 
 * 최대값 : 9
 * 최소값 : 3
 */
package day04.quiz;

public class Test08 {
	public static void main(String[] args) {
		int[] arr = { 6, 8, 3, 9, 7, 4 };
		int max = arr[0], min = arr[0];

		for (int i = 0; i < arr.length; i++) {
			max = (max > arr[i]) ? arr[i] : max;
			min = (min < arr[i]) ? arr[i] : min;
		}

		System.out.printf("최대값 : %d\n", max);
		System.out.printf("최소값 : %d", min);

	}
}
