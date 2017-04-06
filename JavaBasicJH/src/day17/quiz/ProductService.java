package day17.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {
	Scanner sc = new Scanner(System.in);
	ArrayList<Product> list = new ArrayList<>();
	

	public void base() throws FileNotFoundException {
		readFile();
		while (true) {
			System.out.println("--------------------");
			System.out.println("상품관리 시스템");
			System.out.println("--------------------");
			System.out.println("1. 전체 검색");
			System.out.println("2. 금액 검색");
			System.out.println("3. 상품명 검색");
			System.out.println("4. 종료");
			System.out.println("--------------------");
			System.out.print("메뉴 선택 : ");
			int sNo = Integer.parseInt(sc.nextLine());
			switch (sNo) {
			case 1:
				searchAll();
				break;
			case 2:
				searchPrice();
				break;
			case 3:
				searchName();
				break;
			case 4:
				exit();
				break;
			}
		}

	}

	public void readFile() throws FileNotFoundException {
		File f = new File("data/product.txt");
		Scanner scf = new Scanner(f);
		
		while(scf.hasNextLine()) {
			Product p = new Product();
			String line = scf.nextLine();
			String [] arr = line.split(":");
			p.setCo(arr[0]);
			p.setpName(arr[1]);
			p.setpNo(arr[2]);
			p.setpPrice(Integer.parseInt(arr[3]));
			list.add(p);
		}
	}
	
	public void searchAll() {
		System.out.println("-------------------------------");
		System.out.println("상품정보");
		System.out.printf("총 %d개\n", list.size());
		System.out.println("-------------------------------");
		System.out.println("제조회사\t상품명\t상품번호\t가격");
		System.out.println("-------------------------------");
		for (int i = 0; i < list.size(); i++) {
			Product p = list.get(i);
			System.out.printf("%s\t%s       %s\t%d원\n",p.getCo(), p.getpName(), p.getpNo(), p.getpPrice());
		}
		System.out.println("-------------------------------");
	}

	public void searchPrice() {
		System.out.println("-------------------------------");
		System.out.println("금액으로 검색");
		System.out.println("-------------------------------");
		System.out.print("낮은금액 : ");
		int low = Integer.parseInt(sc.nextLine());
		System.out.print("높은금액 : ");
		int high = Integer.parseInt(sc.nextLine());
		System.out.println("-------------------------------");
		
		System.out.println("-------------------------------");
		System.out.printf("%d원 ~ %d원 사이의 상품\n", high, low);
		System.out.println("-------------------------------");
		System.out.println("제조회사\t상품명\t상품번호\t가격");
		System.out.println("-------------------------------");
		int count=0;
		for (int i = 0; i < list.size(); i++) {
			Product p = list.get(i);
			if (p.getpPrice() <=high) {
				if (p.getpPrice() >=low) {
					count++;
					System.out.printf("%s\t%s       %s\t%d원\n",p.getCo(), p.getpName(), p.getpNo(), p.getpPrice());
				}
			}
		}
		if (count == 0) {
			System.out.println("검색된 상품 정보가 없습니다.");
		}
		System.out.println("-------------------------------");
	}

	public void searchName() {
		System.out.println("-------------------------------");
		System.out.println("상품명 검색");
		System.out.println("-------------------------------");
		System.out.print("검색어 입력 : ");
		String search = sc.nextLine();
		System.out.println("-------------------------------");
		
		System.out.println("-------------------------------");
		System.out.printf("[%s]자를 포함하는 상품\n", search);
		System.out.println("-------------------------------");
		System.out.println("제조회사\t상품명\t상품번호\t가격");
		System.out.println("-------------------------------");
		int count=0;
		for (int i = 0; i < list.size(); i++) {
			Product p = list.get(i);
			if (p.getpName().contains(search)) {
					count++;
					System.out.printf("%s\t%s       %s\t%d원\n",p.getCo(), p.getpName(), p.getpNo(), p.getpPrice());
				}
		}
		if (count == 0) {
			System.out.println("검색된 상품 정보가 없습니다.");
		}
		System.out.println("-------------------------------");
	}


	public void exit() {
		while (true) {
			try {
				System.out.print("종료하시겠습니까? (취소 : N, 종료 : 엔터)");
				String select = null; 
				select = sc.nextLine();
				if (select.length()==0) {
					System.out.println("종료되었습니다.");
					System.exit(0);
				} else if (select.equals("N")) {
					System.out.println("취소되었습니다.");
					break;
				} throw new Exception();
			} catch (Exception e) {
				System.out.println("다시 입력하세요.");
			}
		}
	}

}
