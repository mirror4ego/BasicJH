package day12.quiz;

public class BankAccountException extends Exception {
	public BankAccountException (int money) {
		super("잔액부족(현재 : "+money+"원)");
	}
}
