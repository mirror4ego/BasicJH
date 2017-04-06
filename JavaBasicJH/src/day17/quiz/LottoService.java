package day17.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class LottoService {
	Scanner sc = new Scanner(System.in);
	Lotto l = new Lotto();
	ArrayList<Lotto> list;
	
	public LottoService() {
		try {
			list = LottoFile.loadFile();
		} catch (Exception e) {
			System.out.println("파일 로딩시 오류 발생");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	
	public void start() throws Exception {
		while (true) {
			System.out.println("--------------------");
			System.out.println("로또(LOTTO) 관리자 시스템");
			System.out.println("--------------------");
			System.out.println("1. 각 회별 로또 번호 보기");
			System.out.println("2. 번호별 당첨된 횟수 보기");
			System.out.println("3. 당첨 번호 등록");
			System.out.println("4. 종료");
			System.out.println("--------------------");
			System.out.print("메뉴 선택 : ");
			int sNo = Integer.parseInt(sc.nextLine());
			switch (sNo) {
			case 1:
				viewAll();
				break;
			case 2:
				viewByNo();
				break;
			case 3:
				addNo();
				break;
			case 4:
				exit();
				break;
			}
		}
	}
	
	
	public void viewAll() {
		
		Collections.sort(list, new Comparator<Lotto>(){
			  public int compare(Lotto l1, Lotto l2)
			  {
			   return (l1.getNo() > l2.getNo()) ? -1: (l1.getNo() > l2.getNo()) ? 1:0 ;
			  }
		});
		
		System.out.println("--------------------");
		System.out.println("각 회별 로또 번호");
		System.out.printf("총 %s회\n",list.size());
		System.out.println("--------------------");
		if (list.size() ==0) {
			System.out.println("입력된 로또 번호가 없습니다.");
		} else {
			
			for (Lotto l : list) { 
				System.out.printf("%d회. %s\n", l.getNo(), l.getLottoNo());
			}
		}
		System.out.println("--------------------");
	}
	
	public void viewByNo() {
		
		
			  
		int [] count = new int[45];
		for (Lotto l : list) { 
			String[] arr = l.getLottoNo().split(" ");
			for (int i = 0 ; i < arr.length; i++) {
				for (int j = 1; j<46; j++) {
					if (Integer.parseInt(arr[i]) == j) {
						count[j-1]++;
					}
				}
			}
		}
		
		for (int k = 0; k<45; k++) {
			System.out.printf("%d번:%d개\t",k+1,count[k]);
			if (k%5==4) System.out.println();
		}
	}
	
	public void addNo() {
		System.out.print("회차  : ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.print("당첨번호  : ");
		String lottoNo = sc.nextLine();
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			Lotto l = list.get(i);
			if (no == l.getNo()) {
				count++;
			}
		}
		if (count > 0) {
			System.out.println("이미 등록된 회차입니다.");
		} else {
			l = new Lotto();
			l.setNo(no);
			l.setLottoNo(lottoNo);
			list.add(l);
		}

	}
	
	public void exit() {
		while (true) {
			try {
				System.out.print("종료하시겠습니까? (취소 : N, 종료 : 엔터)");
				String select = null; 
				select = sc.nextLine();
				if (select.length()==0) {
					LottoFile.saveFile(list);
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