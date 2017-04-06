package day17.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileService {
Scanner sc = new Scanner(System.in);
	
	public void start() throws FileNotFoundException {
		while(true){
			System.out.println("--------------------------------");
			System.out.println("1. 검색결과를 화면에 출력");
			System.out.println("2. 검색결과를 파일에 저장");
			System.out.println("3. 저장된 결과 보기");
			System.out.println("4. 종료");
			System.out.println("--------------------------------");
			System.out.print("메뉴 선택(1 - 4) : ");
			int sNo = Integer.parseInt(sc.nextLine());
			switch (sNo) {
			case 1:searchView(); break;
			case 2:saveFile(); break;
			case 3:loadView(); break;
			case 4:exit();
			}
		}
	}
	
	@SuppressWarnings("resource")
	public void searchView () throws FileNotFoundException {
		System.out.println("--------------------------------");
		System.out.print("검색할 디렉토리 : ");
		String sDirectory = sc.nextLine();
		System.out.print("검색할 파일 확장자 : ");
		String sfe = sc.nextLine();
		System.out.print("검색할 단어 : ");
		String sWord = sc.nextLine();
		System.out.print("검색된 단어 양옆에 표시할 문자 : ");
		String addWord = sc.nextLine();
		System.out.println("--------------------------------");
		File f = new File(sDirectory);			
		File[] fList = f.listFiles(); 
		String[] result = new String[2];
		for (File fSub : fList) {
			if (fSub.getName().contains("."+sfe)) {
				result[0] = sDirectory+"/" + fSub.getName();
				System.out.println("파일명 : " + result[0]);
				
				try (FileReader fr = new FileReader(result[0]);
					 FileWriter fw = new FileWriter("c:/java/temp.txt")
						){
					while (true) {
						int ch = fr.read(); //
						if (ch == -1) { // 값이 없으면 -1을 반환하므로 그때 빠져나와야함
							break;
						}
						fw.write(ch);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
				result[1] = "";
				File fs = new File("c:/java/temp.txt");		
				Scanner scf = new Scanner(fs);
				int count = 0;
				int scount = 0;
				while (scf.hasNextLine()) {
					count++;
					String fileContent = scf.nextLine();
					if (fileContent.contains(sWord)) {
						result[1] = result[1] + fileContent+ "\n";
						System.out.println((count + "." + result[1].trim()));
						scount++;
					} 
				}
				if (scount==0) {
					System.out.println("검색된 문자열이 없습니다.");
				}
				fs.delete();
			} 
			
				
		
		}
	
	}
	
	public void saveFile() {
		
	}
	
	public void loadView() {
		
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
