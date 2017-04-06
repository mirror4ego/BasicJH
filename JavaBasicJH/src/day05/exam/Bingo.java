package day05.exam;

import java.util.*;

public class Bingo {
	public static void main(String[] args) {
		
		final int VICTORY_LINE = 5;
		int [] numArr = new int[25];
		int count = 0;
		int cnt=0;
		int scNum=0;
		boolean valTest = false;
		int bgCount = 0;
		int bgLineNum = 0;
		int bgCheck = 0;
		
		

		Scanner sc = new Scanner(System.in);
		Random r = new Random();

 

		// 난수생성 중복체크

		for (int i = 0; i < 25; i++) {		
			while (true) {		
				cnt = 0;
				int num = (r.nextInt(25) + 1);
				for (int j = 0; j < i; j++) {
					if (num == numArr[j]) {
						cnt++;
						break;
					}			
				}
				if (cnt == 0) {
					numArr[i]=num;
					break;
				}
			}
		}


	

		while(true){
			
			
						

		// 빙고 줄 카운팅
			
			bgLineNum = 0;
			
			// 세로 빙고
			for (int n = 0; n < 5; n++) {
				bgCheck = 0;
				for (int o = 0; o < 5; o++) {
					if (numArr[(5*n)+o] == 0) {
						bgCheck++;
					}
					if (bgCheck == 5) {
						bgLineNum++;
						bgCheck = 0;
					}
				}
			}

			// 가로 빙고
			for (int n = 0; n < 5; n++) {
				bgCheck = 0;
				for (int o = 0; o < 5; o++) {
					if (numArr[n+(5*o)] == 0) {
						bgCheck++;
					}
					if (bgCheck == 5) {
						bgLineNum++;
						bgCheck = 0;
					}
				}
			}
	
			// 대각선
			bgCheck = 0;
			for (int p = 0; p < 5; p++) {
				if ( numArr[4*(p+1)] == 0 ){     
					bgCheck++;
				}
			}
			if (bgCheck == 5) {
				bgLineNum++;
			}
			
			bgCheck = 0;
			for (int q = 0; q < 5; q++) {
				if ( numArr[6*q] == 0 ){
					bgCheck++;
				}
			}
			if (bgCheck == 5) {
				bgLineNum++;
			}

			
			
			// 빙고판출력
			count = 0;
			for (int k = 0; k < 5; k++) {
				for (int l = 0; l < 5; l++) {
					if (numArr[count] == 0) {
						System.out.print(" *	 ");					
					} else { 
					System.out.printf("%2d	 ", numArr[count]);
					}
					count++;
				}
			System.out.println();
			}
			
			// 게임 종료 조건
			// 모든 숫자 입력
			if (bgCount == 25) {
				System.out.println("모든 숫자를 입력하셨습니다.");
				break;
			}
			
			// 빙고 5줄완성
			if (bgLineNum == VICTORY_LINE) {
				System.out.printf("빙고 카운트 : %d\n빙고!~~\n빙고게임을 종료합니다.", bgLineNum);
				break;
			}
			
			// 빙고 번호 입력
			System.out.println("---------------");
			System.out.print("번호를 입력하세요 : ");
			scNum = Integer.parseInt(sc.nextLine());
						
			// 빙고 번호 유효성 체크 및 빙고 번호 삭제
			valTest = false;
			for (int m = 0; m<25 ;m++){
				if (numArr[m] == scNum) { 
					numArr[m] = 0;
					bgCount++;
					valTest = true;
					break;
				}
				
			}
			
			if (valTest == false) {
				System.out.println("올바른 숫자를 입력해주세요.");
			}
		}
		
	}
}

