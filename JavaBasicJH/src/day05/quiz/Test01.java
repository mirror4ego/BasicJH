package day05.quiz;

public class Test01 {
	public static void main(String[] args) {
		
		int[] arr = new int[5];
		
		String msg = "모두 홀수입니다.";
		for (int i = 0; i < arr.length; i++){
			if (arr[i] % 2 == 0) {
				msg = "모두 홀수는 아닙니다.";
				break;
			}
		}
		System.out.print(msg);
	
	}
}
