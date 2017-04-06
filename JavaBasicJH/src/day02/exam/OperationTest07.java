package day02.exam;

import java.util.Scanner;

public class OperationTest07 {
	public static void main(String [] args){
		char a = 'a'; //소문자
		char b = 'A'; //대문자
		int a1 = (short)a; //소문자 아스키코드
		int b1 = (short)b; //대문자 아스키코드
		int i = (a>b)?a-b:b-a; //대문자와 소문자 아스키코드차이
		int d = (a1>b1)?a1:b1; //대문자와 소문자중 아스키코드가 큰것 구하기
		
		//알파벳 입력
		System.out.print("입력(알파벳) : ");
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine( );
		char c = inputStr.charAt(0);
		
		
		int c1 = (short)c;  //입력알파벳 아스키코드
		int k = (c1 >= d)?c1-i:c1+i; //소문자대문자변환
		char result = (char)k; //아스키코드 문자전환
		
		System.out.printf("변경된 값 : %c", result); //결과출력
		
		
		
		
		
				
	}
}
