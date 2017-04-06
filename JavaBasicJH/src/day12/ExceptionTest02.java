package day12;

public class ExceptionTest02 {
	public static void main(String[] args) throws NullPointerException {
		String s = null;
		/*
		 * 	이클립스의 디버그 모드로 변환하는 경우
		 * 	- 사용자가 별도의 작업을 하지 않은 경우 
		 * 	사용자 코드에 예외가 발생하고 예외처리 코드가 없을경우 자동으로 변환된다.
		 * 
		 *	- 실행시점에 발생하는 예외
		 *	  NullPointerException
		 */
		System.out.println(s.length());

	}
}
