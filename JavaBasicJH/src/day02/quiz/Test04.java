/*
 * 아래의 코드를 오류가 발생하지 않도록 코드를 변경한다.
 * 단, i 에 100을 입력하는 코드는 try문에서 실행해야 한다.
 * 
 */ 
package day02.quiz;

public class Test04 {
public static void main(String[] args){
	
	//local variable : 지역변수
	//메서드 안에서 선언된 변수 : 값을 초기화 해야지 사용할수 있다.
	
	int i = 0;
		try 
		{
			i = 100;
		} 
			catch (Exception e)
		{
		
		} 
			finally 
		{
			System.out.println(i);
		}
	}
}
