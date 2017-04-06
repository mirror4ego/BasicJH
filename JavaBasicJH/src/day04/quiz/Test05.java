package day04.quiz;

public class Test05 {
	public static void main(String[] args) {
		for (int i = 1; i < 6; i++) {
			for (int j = 6 - i; j > 1; j--) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
//		String star = "";
//		for (int i = 1; i <=5 ; i++){
//			for(int j = 1; j <= 5 -i; j++){
//				System.out.print(" ");	
//			}
//			star += "*";
//			System.out.println(star);
//		}
	}
}
