package day03.exam.If;
import java.util.Scanner;

public class Test04 {
	public static void main(String [] args){
		
		System.out.print("상품 수량을 입력하시오 : ");
		Scanner sc1 = new Scanner(System.in);
		int num = Integer.parseInt(sc1.nextLine());
		
		System.out.print("상품 가격을 입력하시오 : ");
		Scanner sc2 = new Scanner(System.in);
		int price = Integer.parseInt(sc2.nextLine());
		
		int result = price * num;
		
		if (num >= 10 ) {
			if (price >= 50000) {
				result = result * 9 / 10; 
			}
		}
			
		System.out.printf("상품 총 가격은 %d 원 입니다.", result);
		
	}
}
