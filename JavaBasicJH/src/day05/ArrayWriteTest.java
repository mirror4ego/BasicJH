package day05;

import java.util.*;

public class ArrayWriteTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[3];
		
		// 배열에 입력될 인덱스 위치 + 입력된 요소의 개수
		int pos = 0;
		
		outer :
		while (true) {
			System.out.print("번호 입력 : ");
			int no = Integer.parseInt(sc.nextLine());
			
			/*
			 *  1. 배열을 이력하기 전에 배열에 모든 요소가 채워져 있는지 확인
			 *  2. 만약, 모든 요소가 채워져 있으면 새로운 배열을 생성
			 *  생성규칙 : 기존 배열의 크기 * 2
			 *  3. 기존 배열의 내용을 새로운 배열로 복사시킨다.
			 *  4. 기존 배열의 주소를 새롭게 생성된 배열의 주소로 변경함
			 */

			// 현재 배열의 모든 요소가 사용되고 있는가(꽉차있나)
			if (pos == arr.length) {
				// 새로운 배열 생성
				int[] temp = new int[arr.length * 2];
				System.arraycopy(arr, 0, temp, 0, arr.length);
				arr = temp;
			}
			
			arr[pos++] = no;
			System.out.println(pos+"개 입력 성공");
			
			System.out.print("계속 입력(종료 : n) : ");
			String isContinue = sc.nextLine();
			switch (isContinue) {
			case "n": case "N":
				break outer;
			}
	
			
		}
		for (int i = 0; i<pos;i++){
			System.out.println(i + " : " + arr[i]);
		}
	}
}
