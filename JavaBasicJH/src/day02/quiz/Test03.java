/* 클래스 : 4 (String, Integer, Test03, System) 변수와 매소드 있어야하고 클래스안에 클래스 가능 / 첫글자무조건대문자
 * 메소드 : 3 (parseInt, println, main) ()가 있어야하고 매소드안에 매소드는 불가능함 / 단어마다 대문자
 * 변수 : 4 (i, j, args, out) 
 * 상수 : 1 (MAX_VALUE) 전부대문자 / 단어마다 _ 표시
 * 
 */

package day02.quiz;

public class Test03 {
	public static void main(String[] args){
		int i = Integer.parseInt("100");
		int j = Integer.parseInt("200");
		System.out.println(i+j);
		System.out.println(Integer.MAX_VALUE);
		
	}
}




