/* 
 *  빵의 이름 : _단팥빵
 *  가격 : 1200
 *  칼로리 : 330
 *  계속 입력하시겠습니까?(Y/N) : N
 *  
 *  빵 정보 입력이 완료되었습니다.
 *  
 *  입력된 빵의 이름
 *  ----------
 *  소보르  1200 312
 *  단팥빵  2000 350
 *  -----------
 *  
 *  배열을 활용 : Bread
 *  
 */
package day06.quiz;

import java.util.*;

class Bread {
	String name;
	int price;
	int kcal;
}

public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bread[] list = new Bread[2];
		int pos = 0;
		
		outer :
		while (true) {
			if (list.length == pos) {
				Bread[] tlist = new Bread[pos * 2];
				System.arraycopy(list, 0, tlist, 0, pos);
				list = tlist;				
			} 
			
			list [pos] = new Bread();					
			System.out.print("빵의 이름 : ");
			list[pos].name = sc.nextLine();
			System.out.print("가격 : ");
			list[pos].price = Integer.parseInt(sc.nextLine());
			System.out.print("칼로리 : ");
			list[pos].kcal = Integer.parseInt(sc.nextLine());
			pos++;

			System.out.print("계속 입력하시겠습니까?(Y/N) : ");
			String s = sc.nextLine();
			switch (s) {
			case "N":
			case "n":				
				break outer;
			}
		}		
		System.out.println("빵 정보 입력이 완료되었습니다.");
		System.out.println("입력된 빵의 이름");
		System.out.println("---------------------");
		for (int i = 0; i < pos; i++) {
			System.out.printf("%s	%d	%d\n", list[i].name, list[i].price, list[i].kcal);
		}
		System.out.println("---------------------");
	}
}
