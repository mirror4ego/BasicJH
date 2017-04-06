package day08.quiz;

public class StringUtil {
	/**
	 * 매개변수에 문자열을 입력받아 입력받은 문자열의 내용을 꺼꾸로 변환한 
	 * 문자열을 반환하는 기능의 메서드
	 */
	public String reverse (String s) {
		String re ="";
		for (int i = s.length() - 1; i > -1; i--) {
			re += s.charAt(i);
		}
		return re;
	}	
	
	/**
	 *  매개변수에 문자열을 입력 받아서
	 *  입력받은 문자열에서 특정한 문자의 개수를 반환하는 메서드
	 *  매서드명 : findCharCount
	 */
	
	public int findCharCount (String s, char c) {
		int count = 0;
		for (int i = 0 ; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				count ++;
			}
		}
		return count;
	}
}
