package day05.exam;

import java.util.*;

public class Test01 {
	private static final int String = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("학생수 : ");
		int studentNum = Integer.parseInt(sc.nextLine());
		
		int[] sArr = new int[studentNum];	
		int[] pNumArr = new int[studentNum];
	
		int temp = 0;
		String pickNo;

		System.out.print("뽑은번호 : ");
		pickNo = sc.nextLine();
		
		for (int a = 0; a < studentNum; a++) {
			pNumArr[a] = Integer.parseInt(pickNo.substring(a*2,a*2+1));			
		}

		for (int i = 0; i < studentNum; i++) {
			sArr[i] = i + 1;
		}

		for (int j = 0; j < studentNum; j++) {
			temp = sArr[j];
			System.arraycopy(sArr, j - pNumArr[j], sArr, j - pNumArr[j] + 1, pNumArr[j]);
			sArr[j - pNumArr[j]] = temp;
		}

		for (int k = 0; k < studentNum; k++) {
			System.out.print(sArr[k] + " ");
		}

	}
}

