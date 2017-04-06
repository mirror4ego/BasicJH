package day05;

import java.util.*;

public class ArrayDeleteTest {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };

		int pos = 5;

		Scanner sc = new Scanner(System.in);

		System.out.print("삭제할 인덱스 입력 : ");
		int index = Integer.parseInt(sc.nextLine());
		
		// 배열의 특정 요소 삭제 과정
		// 1. 삭제할 인덱스 부터 전체크기 - 1 위치보다 작을때까지 요소 이동
		// 2. 마지막 요소 값 0으로 설정
		// 3. 전체 요소 크기 감소 : pos
		/*
		 * index = 3;
		 * arr[3] = arr[4];
		 * arr[4] = 0;
		 * pos--;
		 */
		
		/* 1번
		for (int i = index; i < pos -1; i++){
			arr[i] = arr[i + 1];			
		}
		arr[pos-1] = 0;
		pos --;
		*/
		
		// 2번
		int moveCnt = pos - index - 1; // 이동시켜야 하는 개수
		if (moveCnt > 0) {
			System.arraycopy(arr, index + 1, arr, index, moveCnt);
		} 
		arr[--pos] = 0;
		
		System.out.print("삭제후의 데이터 확인");
		System.out.print(Arrays.toString(arr));
		
	}
}
