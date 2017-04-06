package day03;

public class LoopTest01 {
	public static void main(String[] args) {

/*
		int j = 2;
		while (j <= 9){	
			int i = 1;
			while (i <= 9){
				System.out.printf("%d * %d = %d ", j, i, j*i);
				i++;
			}
			System.out.println();
			j++;
		}
*/
		
		for (int i = 2;i<10;i++){
			for (int j = 1;j<10;j++){
				System.out.printf("%d*%d=%02d ", i, j, j*i);
			}
			System.out.println();
		}
	}
}
