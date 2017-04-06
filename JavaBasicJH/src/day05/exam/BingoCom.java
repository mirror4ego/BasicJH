package day05.exam;

import java.util.Random;
import java.util.Scanner;

public class BingoCom {
	public static void main(String[] args) {

		final int VICTORY_LINE = 3;

		int[] numArr = new int[25];
		int[] comNumArr = new int[25];
		int[] comLineArr = new int[12];

		int count = 0;
		int cnt = 0;

		int scNum = 0;
		int comScNum = 0;

		boolean valTest = false;

		int bgCount = 0;

		int bgLineNum = 0;
		int comBgLineNum = 0;

		int bgCheck = 0;
		int comBgCheck = 0;

		int comScLineNum = 0;

		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		// 사용자 빙고 난수생성 및 중복체크

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
					numArr[i] = num;
					break;
				}
			}
		}

		// 컴퓨터 빙고 난수생성 및 중복체크

		for (int i = 0; i < 25; i++) {
			while (true) {
				cnt = 0;
				int num = (r.nextInt(25) + 1);
				for (int j = 0; j < i; j++) {
					if (num == comNumArr[j]) {
						cnt++;
						break;
					}
				}
				if (cnt == 0) {
					comNumArr[i] = num;
					break;
				}
			}
		}

		while (true) {

			// 컴퓨터와 사용자 빙고 줄 카운팅

			for (int i = 0; i < 12; i++) {
				comLineArr[i] = 0;
			}
			bgLineNum = 0;
			comBgLineNum = 0;

			// 세로 빙고
			for (int n = 0; n < 5; n++) {
				bgCheck = 0;
				comBgCheck = 0;
				for (int o = 0; o < 5; o++) {
					if (numArr[(5 * n) + o] == 0) {
						bgCheck++;
					}
					if (comNumArr[(5 * n) + o] == 0) {
						comBgCheck++;
						comLineArr[n]++;
					}
					if (bgCheck == 5) {
						bgLineNum++;
						bgCheck = 0;
					}
					if (comBgCheck == 5) {
						comBgLineNum++;
						comBgCheck = 0;
					}
				}
			}

			// 가로 빙고
			for (int n = 0; n < 5; n++) {
				bgCheck = 0;
				comBgCheck = 0;
				for (int o = 0; o < 5; o++) {
					if (numArr[n + (5 * o)] == 0) {
						bgCheck++;
					}
					if (comNumArr[n + (5 * o)] == 0) {
						comLineArr[n + 5]++;
						comBgCheck++;
					}
					if (bgCheck == 5) {
						bgLineNum++;
						bgCheck = 0;
					}
					if (comBgCheck == 5) {
						comBgLineNum++;
						comBgCheck = 0;
					}
				}
			}

			// 대각선
			bgCheck = 0;
			for (int p = 0; p < 5; p++) {
				if (numArr[4 * (p + 1)] == 0) {
					bgCheck++;
				}
				if (comNumArr[4 * (p + 1)] == 0) {
					comLineArr[10]++;
					comBgCheck++;
				}
			}
			if (bgCheck == 5) {
				bgLineNum++;
			}
			if (comBgCheck == 5) {
				comBgLineNum++;
			}

			bgCheck = 0;
			for (int q = 0; q < 5; q++) {
				if (numArr[6 * q] == 0) {
					bgCheck++;
				}
				if (comNumArr[6 * q] == 0) {
					comLineArr[11]++;
					comBgCheck++;
				}
			}
			if (bgCheck == 5) {
				bgLineNum++;
			}
			if (comBgCheck == 5) {
				comBgLineNum++;
			}
	
			// 빙고판출력
			count = 0;
			System.out.println("사용자 빙고번호");
			for (int k = 0; k < 5; k++) {
				for (int l = 0; l < 5; l++) {
					if (numArr[count] == 0) {
						System.out.print(" * 	");
					} else {
						System.out.printf("%2d	", numArr[count]);
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

			// 컴퓨터 빙고 5줄완성
			if (comBgLineNum >= VICTORY_LINE) {
				System.out.printf("빙고!~ \n 컴퓨터가 이겼습니다.빙고게임을 종료합니다.\n", comBgLineNum);

				// 컴퓨터 빙고판 출력
				count = 0;
				System.out.println("컴퓨터 빙고판");
				for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 5; l++) {
						if (comNumArr[count] == 0) {
							System.out.print(" *	 ");
						} else {
							System.out.printf("%2d 	", comNumArr[count]);
						}
						count++;
					}
					System.out.println();
				}

				break;
			}

			// 사용자 빙고 5줄완성
			if (bgLineNum >= VICTORY_LINE) {
				System.out.printf("승리! 빙고 %d줄을 완성하셨습니다.\n", bgLineNum);

				// 컴퓨터 빙고판 출력
				count = 0;
				System.out.println("컴퓨터 빙고판");
				for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 5; l++) {
						if (comNumArr[count] == 0) {
							System.out.print(" * ");
						} else {
							System.out.printf("%2d ", comNumArr[count]);
						}
						count++;
					}
					System.out.println();
				}

				break;

			}

			// 사용자 빙고 번호 입력

			valTest = false;
			while (valTest == false) {

				System.out.print("빙고 번호를 선택하세요 : ");
				scNum = Integer.parseInt(sc.nextLine());

				// 사용자 입력 빙고 번호 유효성 체크 및 빙고 번호 삭제
				for (int m = 0; m < 25; m++) {
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

			for (int e = 0; e < 25; e++) {
				if (comNumArr[e] == scNum) {
					comNumArr[e] = 0;
					break;
				}
			}

			// 컴퓨터와 사용자 빙고 줄 카운팅

			for (int i = 0; i < 12; i++) {
				comLineArr[i] = 0;
			}
			bgLineNum = 0;
			comBgLineNum = 0;

			// 세로 빙고
			for (int n = 0; n < 5; n++) {
				bgCheck = 0;
				comBgCheck = 0;
				for (int o = 0; o < 5; o++) {
					if (numArr[(5 * n) + o] == 0) {
						bgCheck++;
					}
					if (comNumArr[(5 * n) + o] == 0) {
						comBgCheck++;
						comLineArr[n]++;
					}
					if (bgCheck == 5) {
						bgLineNum++;
						bgCheck = 0;
					}
					if (comBgCheck == 5) {
						comBgLineNum++;
						comBgCheck = 0;
					}
				}
			}

			// 가로 빙고
			for (int n = 0; n < 5; n++) {
				bgCheck = 0;
				comBgCheck = 0;
				for (int o = 0; o < 5; o++) {
					if (numArr[n + (5 * o)] == 0) {
						bgCheck++;
					}
					if (comNumArr[n + (5 * o)] == 0) {
						comLineArr[n + 5]++;
						comBgCheck++;
					}
					if (bgCheck == 5) {
						bgLineNum++;
						bgCheck = 0;
					}
					if (comBgCheck == 5) {
						comBgLineNum++;
						comBgCheck = 0;
					}
				}
			}

			// 대각선
			bgCheck = 0;
			for (int p = 0; p < 5; p++) {
				if (numArr[4 * (p + 1)] == 0) {
					bgCheck++;
				}
				if (comNumArr[4 * (p + 1)] == 0) {
					comLineArr[10]++;
					comBgCheck++;
				}
			}
			if (bgCheck == 5) {
				bgLineNum++;
			}
			if (comBgCheck == 5) {
				comBgLineNum++;
			}

			bgCheck = 0;
			for (int q = 0; q < 5; q++) {
				if (numArr[6 * q] == 0) {
					bgCheck++;
				}
				if (comNumArr[6 * q] == 0) {
					comLineArr[11]++;
					comBgCheck++;
				}
			}
			if (bgCheck == 5) {
				bgLineNum++;
			}
			if (comBgCheck == 5) {
				comBgLineNum++;
			}


			// 게임 종료 조건
			// 모든 숫자 입력
			if (bgCount == 25) {
				System.out.println("모든 숫자를 입력하셨습니다.");
				break;
			}

			// 사용자 빙고 5줄완성
			if (bgLineNum >= VICTORY_LINE) {
				System.out.printf("승리! 빙고 %d줄을 완성하셨습니다.\n", bgLineNum);
				
				// 컴퓨터 빙고판 출력
				count = 0;
				System.out.println("컴퓨터 빙고판");
				for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 5; l++) {
						if (comNumArr[count] == 0) {
							System.out.print(" * 	");
						} else {
							System.out.printf("%2d	 ", comNumArr[count]);
						}
						count++;
					}
					System.out.println();
				}
				
				break;
				
			}
			
			// 컴퓨터 빙고 5줄완성
			if (comBgLineNum >= VICTORY_LINE) {
				System.out.printf("빙고!~ \n 컴퓨터가 이겼습니다.빙고게임을 종료합니다.\n", comBgLineNum);

				// 컴퓨터 빙고판 출력
				count = 0;
				System.out.println("컴퓨터 빙고판");
				for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 5; l++) {
						if (comNumArr[count] == 0) {
							System.out.print(" * ");
						} else {
							System.out.printf("%2d ", comNumArr[count]);
						}
						count++;
					}
					System.out.println();
				}

				break;
			}

			
			// 컴퓨터 빙고번호 입력
			// 컴퓨터 빙고번호 선택 규칙
			// 1. 빙고번호중 가장 유리한 가운대 번호가 비어있으면 먼저 선택
			// 2. 빙고줄 중에 가장 많은 번호가 지워진 줄에서 번호를 선택
			// 가운대 비어있으면 선택하고 아니면 빙고줄중 가장 적게 비어있는줄중에 숫자 선택

			if (comNumArr[12] != 0) {
				comScNum = comNumArr[12];
				comNumArr[12] = 0;
			} else {
				for (int i = 0; i < 12; i++) {
					for (int j = i; j < 12; j++) {
						if (comLineArr[i] > comLineArr[j]) {
							comScLineNum = j;
						}
					}
				}

				switch (comScLineNum) {
				case 0:
				case 1:
				case 2:
				case 3:
				case 4: // 가로줄중 선택
					for (int i = 0; i < 5; i++) {
						if (comNumArr[comScLineNum * 5 + i] != 0) {
							comScNum = comNumArr[comScLineNum * 5 + i];
							comNumArr[comScLineNum * 5 + i] = 0;
							break;
						}
					}
					break;

				case 5:
				case 6:
				case 7:
				case 8:
				case 9: // 세로줄중 선택
					for (int i = 0; i < 5; i++) {
						if (comNumArr[comScLineNum - 5 + (5 * i)] != 0) {
							comScNum = comNumArr[comScLineNum - 5 + (5 * i)];
							comNumArr[comScLineNum - 5 + (5 * i)] = 0;
							break;
						}
					}
					break;
				case 10: // 왼쪽 대각선 줄중 선택
					for (int i = 0; i < 5; i++) {
						if (comNumArr[4 * (i + 1)] != 0) {
							comScNum = comNumArr[4 * (i + 1)];
							comNumArr[4 * (i + 1)] = 0;
							break;
						}
					}
					break;
				case 11: // 오른쪽 대각선 줄중 선택
					for (int i = 0; i < 5; i++) {
						if (comNumArr[6 * i] != 0) {
							comScNum = comNumArr[6 * i];
							comNumArr[6 * i] = 0;
							break;
						}
					}
					break;
				}

			}

			for (int i = 0; i < 25; i++) {
				if (numArr[i] == comScNum) {
					numArr[i] = 0;
					break;
				}
			}
			System.out.printf("컴퓨터가  %d번을 선택하였습니다.\n", comScNum);
			bgCount++;

		}

	}

}