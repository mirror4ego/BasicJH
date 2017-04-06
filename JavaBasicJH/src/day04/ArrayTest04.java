package day04;

import java.util.Arrays;

public class ArrayTest04 {
	public static void main(String[] args) {
		String[] src = {"콜라", "사이다", "햄버거", "피자"};
		String[] dest = new String[src.length];
		
		// 배열의 복사
		// 전체복사
//		for (int i = 0; i < src.length; i++){
//			dest[i] = src[i];
//		}
		
		// 일부분복사
		// src 배열의 인덱스가 2부터 3까지의 요소를 dest 배열의 0번째부터 1번째로 복사
//		int x = 2;
//		int y = 2;
//		for (int i = y; i <= src.length-x; i++){
//			dest[i - x] = src[i];			
//		}
		
		// 배열 복사 API
		// 원본배열 : 원본배열, 시작, 크기
		// 옮길배열 : 옮길배열, 시작
		
		System.arraycopy(src, 2, dest, 0, 2);
		System.out.println(Arrays.toString(dest));
		System.arraycopy(src, 0, dest, 0, 4);
		System.out.println(Arrays.toString(dest));
		
	}
}
