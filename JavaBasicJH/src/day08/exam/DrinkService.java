package day08.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DrinkService {
	private final int INIT_SIZE = 3;	
	private Drink [] d = new Drink[INIT_SIZE];
	private int i = 0;
	int pos =0;

	public void start() throws FileNotFoundException {
		Load();
		while (true) {
			System.out.println("-----------------------");
			System.out.println("1. 전체조회");
			System.out.println("2. 가격조회");
			System.out.println("3. 칼로리조회");
			System.out.println("4. 종료");
			System.out.println("-----------------------");
			System.out.print("메뉴선택 : ");
			Scanner sc = new Scanner(System.in);
			switch (sc.nextLine()) {
			case "1":
				all();
				break;
			case "2":
				price();
				break;
			case "3":
				kcal();
				break;
			case "4":
				exit();
			}
		}
	}

	public void Load() throws FileNotFoundException {
		File f = new File("src/day08/exam/test01.txt");
		Scanner sc = new Scanner(f);
		
		while (sc.hasNextLine()) {
			d[i] = new Drink();
			String [] arr = sc.nextLine().split(":");
			d[i].setDrinkName(arr[0]);
			d[i].setPrice(Integer.parseInt(arr[1]));
			d[i].setKcal(Integer.parseInt(arr[2]));
			i++;
		}
	}
	
	public void all() {
		System.out.println("-----------------------");
		System.out.printf("음료\t가격\t칼로리\n");
		System.out.println("-----------------------");
		for (int i = 0; i < INIT_SIZE; i++) {
			System.out.printf("%s\t%d\t%d\n", d[i].getDrinkName(),d[i].getPrice(),d[i].getKcal());

		}
		System.out.println("-----------------------");
	}

	public void price() {
		Scanner sc = new Scanner(System.in);
		System.out.print("가격 : ");
		int p = Integer.parseInt(sc.nextLine()); 
		
		System.out.println("-----------------------");
		System.out.printf("음료\t가격\t칼로리\n");
		System.out.println("-----------------------");
		for (int i = 0 ; i < d.length; i++){
			if (d[i].getPrice() <= p) {
				System.out.printf("%s\t%d\t%d\n", d[i].getDrinkName(),d[i].getPrice(),d[i].getKcal());
			}
		}
		System.out.println("-----------------------");
	}
		

	public void kcal() {
		Scanner sc = new Scanner(System.in);
		System.out.print("칼로리 : ");
		int p = Integer.parseInt(sc.nextLine()); 
		
		System.out.println("-----------------------");
		System.out.printf("음료\t가격\t칼로리\n");
		System.out.println("-----------------------");
		for (int i = 0 ; i < d.length; i++){
			if (d[i].getKcal() <= p) {
				System.out.printf("%s\t%d\t%d\n", d[i].getDrinkName(),d[i].getPrice(),d[i].getKcal());
			}
		}
		System.out.println("-----------------------");
	}
	
	public void exit() {
		System.out.println("종료합니다.");
		System.exit(0);
	}
	
	
}
