/*
 *  출력형식
 *  
 *  바꿀 인덱스 : 3
 *  바꿀 인덱스 : 5
 * 
 */
package day04.quiz;

import java.util.Arrays;
import java.util.Scanner;

public class Test09 {
	public static void main(String[] args) {
		int[] arr = { 6, 8, 3, 9, 7, 4 };
		Scanner sc = new Scanner(System.in);

		System.out.print("바꿀 인덱스 : ");
		int src = Integer.parseInt(sc.nextLine());
		System.out.print("바꿀 인덱스 : ");
		int dest = Integer.parseInt(sc.nextLine());

		int temp = arr[src];
		arr[src] = arr[dest];
		arr[dest] = temp;

		System.out.print("변경된 내용 : ");
		String result = Arrays.toString(arr);
		System.out.println(result);
		
		System.out.print("변경된 내용 : ");
		for (int i = 0; i < arr.length -1; i++) {
			System.out.printf("%d, ", arr[i]);
		}
		System.out.println(arr[arr.length - 1]);
	}
}
