package day07;

import java.util.Random;

/**
 * 
 * @author Bitcamp
 *
 */
public class MethodSub03 {
	/**
	 * 정수를 매개변수로 입력받아 1부터~입력받은 정수까지의 숫자를 화면에 출력
	 * 
	 */
	void printNumber01(int i) {
		for (int j = 1; j <= i; j++) {
			System.out.println(j);
		}

	}
	
	/**
	 * 정수와 불린형을 매개변수로 입력받아 true 1부터~입력받은 정수까지의 숫자중 짝수만 화면에 출력 false 1~정수까지 홀수만
	 */
	void printNumber02(int num, boolean bl) {
		if (bl == true) {
			for (int i = 1; i <= num; i++) {
				if (i % 2 == 0) {
					System.out.println(i);
				}
			}
		}

		if (bl == false) {
			for (int i = 1; i <= num; i++) {
				if (i % 2 == 1) {
					System.out.println(i);
				}
			}

		}
	}

	/**
	 * 매개변수로 2개의 정수를 입력받는다. 두 정수사이의 합 리턴
	 */
	int printNumber03(int num1, int num2) {
		int sum = 0;
		for (int i = num1; i <= num2; i++) {
			sum += i;
		}
		return sum;
	}

	/**
	 * add : 두 수의 합을 구한 뒤 합을 반환 sub : 두 수의 차 mul : 두 수의 곱 div : 두 수의
	 * 
	 */

	int add(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}

	int sub(int num1, int num2) {
		int result = num1 - num2;
		return result;
	}

	int mul(int num1, int num2) {
		int result = num1 * num2;
		return result;
	}

	int div(int num1, int num2) {
		int result = num1 / num2;
		return result;
	}

	/**
	 * 매서드명 : cal
	 * 
	 */

	int cal(int operation, int num1, int num2) {
		int result = 0;
		switch (operation) {
		case 1:
			result = num1 + num2;
			break;
		case 2:
			result = num1 - num2;
			break;
		case 3:
			result = num1 * num2;
			break;
		case 4:
			result = num1 / num2;
			break;
		}
		return result;
	}
	
	/** <-문서화 주석문 javadoc(클래스, 메소드, 멤버변수 위쪽에 쓰는 주석문)
	 *  
	 *  랜덤한 숫자 5개를 생성해서 배열에 담은 다음에
	 *  배열을 반환하는 기능 구현
	 *  랜덤숫자는 1~10
	 */
	int [] getRandomNum() {
		/*
		Random r = new Random();
		int [] arr = new int[5];
		for (int i = 0; i<arr.length; i++){
			arr[i] = r.nextInt(10)+1;
		}
		return arr;
		*/
		return getRandomNum(5, 10);
	}
	
	/** <-문서화 주석문 javadoc(클래스, 메소드, 멤버변수 위쪽에 쓰는 주석문)
	 *  
	 *  랜덤한 입력한숫자개를 생성해서 배열에 담은 다음에
	 *  배열을 반환하는 기능 구현
	 *  랜덤숫자는 1~10
	 */
	int [] getRandomNum(int num1) {
		/*		
 		Random r = new Random();
		int [] arr = new int[num];
		for (int i = 0; i<arr.length; i++){
			arr[i] = r.nextInt(10)+1;
		}
		return arr;
		 */
		return getRandomNum(num1, 10);
	}
	
	
	/** <-문서화 주석문 javadoc(클래스, 메소드, 멤버변수 위쪽에 쓰는 주석문)
	 *  
	 *  랜덤한 숫자 입력한숫자개를 생성해서 배열에 담은 다음에
	 *  배열을 반환하는 기능 구현
	 *  랜덤숫자범위지정
	 */
	int [] getRandomNum(int num1, int num2) {
		Random r = new Random();
		int [] arr = new int[num1];
		for (int i = 0; i<arr.length; i++){
			arr[i] = r.nextInt(num2)+1;
		}
		return arr;
	}
}
