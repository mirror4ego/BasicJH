package day04.quiz;

public class Test03 {
	public static void main(String[] args) {
		int j = 0;
		outer :
		for (int i = 2; i <= 100; i++) {
			for (j= 2; j < i; j++) {
				if (i % j == 0)
					continue outer;				
			}
			System.out.print(" " + i);
		}
	}
}