package day03;
/*  
 *  조건식이 참일경우 반복
 *  실행 순서 : 1 - 2(참) - 4 - 3 
 *             - 2(참) - 4 -3
 *             - 2(거짓) - 반복문 벗어남 
 * 
 *  for (1. 초기화; 2. 조건식; 3. 증감){
 *  	4. 실행할 문장..
 *  }
 *  
 *  for는 반복의 횟수가 정해져 있을때 편함
 *  while은 반복의 횟수를 잘 모를때 편함
 *  
 * 
 */
public class ForTest {
	public static void main(String[] args) {
/*		
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		
		for (int i = 1; i <= 5; i++){
			System.out.println(i);
			}
		
		System.out.println(10);
		System.out.println(11);
		System.out.println(12);
		System.out.println(13);
		System.out.println(14);
		
		for (int j = 10;j <=14 ; j++){
			System.out.println(j);
					
		}
*/

/*
		System.out.println(1);
		System.out.println(3);
		System.out.println(5);
		System.out.println(7);
		System.out.println(9);
		
		for (int i = 1; i <= 9; i += 2){
			System.out.println(i);
		}
		
		for (int i = 1; i <= 9; ){
			System.out.println(i);
			i += 2;
		}
		
		int i = 1;
		for (; i <= 9; ){
			System.out.println(i);
			i += 2;
		}
		
*/
		int i = 1;
		while (i <= 9) {
			System.out.println(i);
			i += 2;
		}
		
	}

}
