package day02.exam;

import java.util.Scanner;

public class OperationTest02 {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("초를 입력하세요 : ");
		int sec = Integer.parseInt(sc.nextLine());
		int i = sec / 3600;
		int j = sec % 3600 / 60;
		int k = sec % 3600 % 60;
		System.out.printf("%d초는 %d시간 %d분 %d초입니다.", sec, i, j, k);
		
		
		
		
	}
}
