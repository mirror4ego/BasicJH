/*
 * 배열은 생성과 동시에 값의 자동 초기화가 발생한다.
 * 정수 : 0, 실수 : 0.0, 논리형 : false, 문자 : 공백
 * 참조형 : null
 */

package day04;

import java.util.Random;

public class ArrayTest01 {
	public static void main(String[] args) {
		Random r = new Random();
		int num1 = r.nextInt(100);

		int[] iArr; // 배열의 선언
		iArr = new int[5]; // int를 담을 수 있는 5개의 공간을 생성, 공간이 만들어지면 자동 초기화 발생(정수 0
							// / 실수 0.0 / 논리 false / 문자 공백 / 참조형(String도 참조형) null) 

		// Random r2 = null;
		// int num2 = r2.nextInt(100); //null로인한 오류발생

		// 배열의 요소 값 확인
		// 배열이름 []

		// for (int i = 0; i < iArr.length; i++) {
		// iArr[i] = i;
		// System.out.println(iArr[i]);

		// 배열의 크기 : 배열의 이름.length
		//
		String[][] sArr = new String[3][3];
		sArr[0][0] = "a";

		for (int i = 0; i < sArr.length; i++) {
			for (int j = 0; j < sArr.length; j++) {
				System.out.print(" " + sArr[i][j]);
			}
			System.out.println();
		}
	}
}
