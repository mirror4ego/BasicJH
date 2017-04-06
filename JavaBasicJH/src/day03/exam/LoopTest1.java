package day03.exam;

public class LoopTest1 {
	public static void main(String[] args) {
		for (int i = 0;i<10;i++){
			for (int j = 1;j<11;j++){
				int k = i*10+j;
				System.out.print(" "+k);	
			}
			System.out.println();
		}
	
	}
}
