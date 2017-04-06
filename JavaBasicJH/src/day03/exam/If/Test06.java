package day03.exam.If;

import java.util.Scanner;

public class Test06 {
	public static void main(String[]args){
	
		System.out.print("구분할 문자를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine( );
		char c = inputStr.charAt(0);

		
		String result="문자";
		
		if(c>='0'){
			if(c<='9') {
				result="숫자";
			}
		}
		if(c>='a'){
			if(c<='z') {
				result="영문자";
			}
		}
			
		if(c>='A'){
			if(c<='Z') {
				result="영문자";
			}
		}
		
		
		System.out.printf("%c는 %s입니다.",c,result);
	}
}
