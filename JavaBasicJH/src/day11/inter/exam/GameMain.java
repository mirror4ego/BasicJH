package day11.inter.exam;

import java.util.Scanner;

public class GameMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		int score = 0;

		while (true) {
			System.out.println("게임을 선택하세요");
			System.out.println("A. 가위바위보");
			System.out.println("B. 주사위 값 맞추기");
			System.out.println("C. 종료");

			input = sc.nextLine();
			if (input != "A" && input != "B" && input != "C" ) {
				System.out.println("다시 입력하세요.");
			}
			switch (input) {
			case "A":
				ScissorsRockPaper srp = new ScissorsRockPaper();
				System.out.println("가위바위보 게임입니다.");
				System.out.println("가위바위보중 하나를 선택하세요.");
				System.out.println("(1:가위, 2:바위, 3보)");
				int srpNo;
				while (true) {
					srpNo = Integer.parseInt(sc.nextLine());
					if (srpNo == 1 || srpNo == 2 || srpNo == 3) {
						break;
					} else {
						System.out.println("다시 입력하세요");
					}
				}
				score += srp.startGame(srpNo);
				break;

			case "B":
				Dice d = new Dice();
				System.out.println("주사위를 선택하세요(1~6값 중 하나)");
				int diceNo;
				while (true) {
					diceNo = Integer.parseInt(sc.nextLine());
					if (diceNo > 0 && diceNo < 7) {
						break;
					} else {
						System.out.println("다시 입력하세요");
					}
				}
				score += d.startGame(diceNo);
				break;

			case "C":
				System.out.println("게임을 종료합니다.");
				System.out.printf("당신의 total score는 %d입니다.", score);
				System.exit(0);
				
			
			}
		}

	}
}
