/**
 * 	주민번호 관련 예외 처리 예제
 * 
 *  1. 작성 클래스
 *  	- JuminNumberException
 *  	- JuminService
 *  		: execute() 메서드
 *  		기능 구현
 *  		- 주민번호를 입력 받아서 입력된 주민번호가 올바른 주민번호인지 체크한다.
 *  		 1. 입력된 주민번호가 13자리인지 체크한다.
 *  		 2. 숫자만 입력되있는지 확인한다.
 *  			- 만약, 올바르지 않은 주민번호가 입력되었다면 JuminNumberException 예외를 발생시킨다.
 *  			- 발생된 예외의 처리는 호출하는 쪽으로 넘긴다.
 *  출력 형식 > 
 *  주민번호를 입력하세요 : 111111111
 *  day12.quiz.JuminNumberException : 1111111111은 13자리가 아닙니다.
 *  생략....
 *  
 *  주민번호를 입력하세요 : 111111a11
 *  day12.quiz.JuminNumberException : 1111111a11중에 문자가 있습니다.
 *	생략....
 *
 *  주민번호를 입력하세요 : 123456-1234567
 *  올바른 주민번호를 입력하였습니다.
 */
package day12.quiz;

public class Test02 {
	public static void main(String[] args) {
		JuminService js = new JuminService();
		try {
			js.execute();
		} catch(JuminNumberException e) {
			e.printStackTrace();			
		}
	}
}
