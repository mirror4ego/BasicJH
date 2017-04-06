package day12.quiz;

import java.util.Scanner;

public class BankService {
	public static Scanner sc = new Scanner(System.in);
	public static BankAccount ba = new BankAccount();
	public void execute() {
		System.out.print("계좌주 : ");
		String name = sc.nextLine();
		System.out.print("입금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		System.out.println("계좌가 개설되었습니다.");
		System.out.println("----------------");
		System.out.printf("고객명 : %s\n", name);
		System.out.printf("계좌번호 : 1\n");
		System.out.printf("초기입금액 : %d\n", money);
		System.out.println("----------------");
		bankWork(name, money);
	}
	
	public void bankWork(String name, int money) {
		ba.setName(name);
		ba.setMoney(money);
		while (true){
			System.out.print("선택(1.인출  2.입금  3.종료) : ");
			int sNo = Integer.parseInt(sc.nextLine());	
			switch (sNo) {
				case 1 : 
					try {
						outMoney();
					} catch (BankAccountException e) {
						e.printStackTrace();
						System.exit(0);
					}
					break;
				case 2 :
					addMoney();
					break;
				case 3 : System.exit(0);
			}
			
		}
				
	}
	
	public void addMoney () {
		System.out.print("입금할 금액(원) : ");
		int addMoney = Integer.parseInt(sc.nextLine());
		ba.setMoney(ba.getMoney()+addMoney);
		System.out.println("잔액 : " + ba.getMoney());
	}
	
	public void outMoney() throws BankAccountException {
		System.out.print("출금할 금액(원) : ");
		int outMoney = Integer.parseInt(sc.nextLine());
		if (outMoney > ba.getMoney()) { 
			throw new BankAccountException(ba.getMoney());
		}
		ba.setMoney(ba.getMoney()-outMoney);
		System.out.println("잔액 : " + ba.getMoney());
	}
	
		
		
	
}
