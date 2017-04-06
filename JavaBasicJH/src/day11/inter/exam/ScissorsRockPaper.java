package day11.inter.exam;

public class ScissorsRockPaper implements Game {
	final static int SCISSOR = 1;
	final static int ROCK = 2;
	final static int PAPER = 3;
	
	@Override
	public int startGame(int you) {
		int me = r.nextInt(3) + 1;
		
		if (me == 1) {
			if (you == 3) {
				System.out.println("You lose");
				return 0;
			}
			if (you == 2){
				System.out.println("You win");
				return 1;
			}
		}
		
		if (me == 2) {
			if (you == 1) {
				System.out.println("You lose");
				return 0;
			}
			if (you == 3){
				System.out.println("You win");
				return 1;
			}
		}
		
		if (me == 3) {
			if (you == 2) {
				System.out.println("You lose");
				return 0;
			}
			if (you == 1){
				System.out.println("You win");
				return 1;
			}
		}
		System.out.println("비겼습니다.");
		return 0;
	}
}
