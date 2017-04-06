package day04;

import java.util.Arrays;

public class ArrayTest03 {
	public static void main(String[] args) {
		int [] iArr = {1, 2, 3};
		// 배열에 설정된 값을 확인하는 방법 : 3가지
		
		// 1번
		for (int i = 0; i < iArr.length; i++){
			System.out.println(iArr[i]);
		}
		
		// 2번
		// 1.5 에서 제공
		// 배열의 길이만큼 돌린다.
		for (int val : iArr) {
			System.out.println(val);
		}
		
		// 3번
		//String result = Arrays.toString(iArr);
		//System.out.println(result);
		System.out.println(Arrays.toString(iArr));
		
		
	}
}