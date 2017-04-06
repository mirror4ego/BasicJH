/*
 *  1! is 1
 *  2! is 2
 *  3! is 6
 *  
 */

package day03.quiz;

public class Test03 {
	public static void main(String[] args) {

		for (int i = 1; i < 11; i++) {
			int num = 1;
			for (int j = 1; j <= i; j++) {
				num *= j;
			}
			System.out.printf("%d! is %d\n", i, num);
		}
	}
}
