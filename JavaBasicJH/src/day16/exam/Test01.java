import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Data{
	private String name;
	private String city;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}

public class Test01 {
	public static void main(String[] args) throws IOException {
		ArrayList<Data> list = new ArrayList<>();
		File f = new File("JavaBasicJH/src/day16/exam/person.txt");
		Scanner sc1 = new Scanner(f);
		while (sc1.hasNextLine()) {
			String[] arr = sc1.nextLine().split(":");
			Data d = new Data();
			d.setName(arr[0]);
			d.setCity(arr[1]);
			list.add(d);		
		}
		
		Scanner sc2 = new Scanner(System.in);
		int no;
		PrintWriter pr = new PrintWriter("JavaBasicJH/src/day16/exam/searchResult.txt");
		outer : while(true) {
			System.out.print("항목을 선택하세요.(1.지역명 2.이름 3.종료):");
			try {
				
				no = Integer.parseInt(sc2.nextLine());
				
				if (no == 1) {
					int count=0;
					System.out.print("지역명을 입력하세요 : ");
					String sCity = sc2.nextLine();
					for (int i=0; i < list.size(); i++) {
						Data d = list.get(i);
						if (d.getCity().equals(sCity)) {
							count++;
						}
					}
					pr.println("-------------------");
					pr.printf("%s 검색된 결과 : %d명\n", sCity, count);
					System.out.println("-------------------");
					System.out.printf("%s 검색된 결과 : %d명\n", sCity, count);
					
					for (int i=0; i < list.size(); i++) {
						Data d = list.get(i);
						if (d.getCity().equals(sCity)) {
							System.out.printf("이름 : %s, 거주지 : %s\n",d.getName(), d.getCity());
							pr.printf("이름 : %s, 거주지 : %s\n",d.getName(), d.getCity());
						}
					}
					pr.println("-------------------");
					System.out.println("-------------------");
				}				
				
				if (no == 2) {
					System.out.print("이름을 입력하세요 : ");
					String sName = sc2.nextLine();
					int count=0;
					pr.println("-------------------");
					System.out.println("-------------------");
					for (int i=0; i < list.size(); i++) {
						Data d = list.get(i);
						if (d.getName().startsWith(sName)) {
							count++;
						}
					}
					pr.printf("\"%s\"로 시작하는 사람 검색된 결과 : %d명\n", sName, count);
					System.out.printf("\"%s\"로 시작하는 사람 검색된 결과 : %d명\n", sName, count);
					
					for (int i=0; i < list.size(); i++) {
						Data d = list.get(i);
						if (d.getName().startsWith(sName)) {
							System.out.printf("이름 : %s, 거주지 : %s\n",d.getName(), d.getCity());
							pr.printf("이름 : %s, 거주지 : %s\n",d.getName(), d.getCity());
						}
					}
					pr.println("-------------------");
					System.out.println("-------------------");
				}
				
				
				if (no == 3) {
					System.out.print("검색된 결과를 저장 후 종료하겠습니까?(Y/N)");
					if (sc2.nextLine().equals("Y")) {
						System.out.println("검색결과가 저장되었습니다.");
						System.out.println("프로그램을 종료합니다.");
						break outer;
					} else if (sc2.nextLine().equals("N")) {
						System.out.println("프로그램을 종료합니다.");
						f.delete();
						break outer;
					}
				}
				
			} catch (Exception e) {
				System.out.println("항목을 다시 선택하세요");
			} 
		}
		pr.close();
		
		
		
		
	}
}
