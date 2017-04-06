package day02;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);  //사용자가 입력할때까지 block 상태
		System.out.print("이름 : ");
		String name= sc.nextLine();
		System.out.println("name : " + name);
		
		System.out.print("나이 : ");
		String age=sc.nextLine();
		System.out.println("age : " + age);
		
	}
}
