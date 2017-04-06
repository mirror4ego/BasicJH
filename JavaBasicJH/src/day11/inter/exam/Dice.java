package day11.inter.exam;

public class Dice implements Game {

	@Override
	public int startGame(int you) {
		System.out.println(">주사위 값 맞추기 게임입니다.");
		int me = r.nextInt(6) + 1;
		if (me==you) {
			System.out.println("You win");
			return 1;
		}
		System.out.println("You lose");
		return 0;
	}
	

}
