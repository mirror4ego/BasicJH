/*
 * 	명령형 매개변수로 100 200을 입력하고
 *	프로그램을 실행했을때 아래와 같은 결과가 출력되도록 프로그램 작성하시오
 *
 *	100 + 200 = 300
 */

package day02.quiz;

public class Test02 {
	public static void main(String [] args) {
		int i = Integer.parseInt(args[0]);
		int j = Integer.parseInt(args[1]);
		int k = i + j;
		System.out.print(i);
		System.out.print(" + ");
		System.out.print(j);
		System.out.print(" = ");
		System.out.println(i+j);
		
		System.out.println(i + " + ");
		System.out.println(i + " + " + j);
		System.out.println(i + " + " + j + " = ");
		System.out.println(i + " + " + j + " = " + k);
		

	}
}
