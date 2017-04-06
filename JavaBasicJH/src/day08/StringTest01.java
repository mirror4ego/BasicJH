package day08;

public class StringTest01 {
	public static void main(String[] args) {
		String s = "Java Is Easy";
		/*
		 * // char charAt(int index) char ch = s.charAt(0);
		 * System.out.println("ch = " + ch); System.out.println("ch = " +
		 * s.charAt(1)); System.out.println("ch = " + s.charAt(2));
		 * System.out.println("ch = " + s.charAt(3));
		 * 
		 * int len = s.length(); System.out.println("길이 : " + len);
		 */

		/*
		 * // boolean equals(Object another obj) 내용비교해서 같으면 true // boolean
		 * equalsIgnoreCase(Object another obj) 대소문자 무시하고 비교 s = "java";
		 * System.out.println(s.equals("Java"));
		 * System.out.println(s.equalsIgnoreCase("Java"));
		 */

		/*
		 * // 문자열이 포함되어 있는지 여부 반환 // boolean contains(CharSequence s) 어떠한 문자열의
		 * 내용이 있는지 판단 System.out.println(s.contains("Is"));
		 */

		/*
		 * 특정 문자열이 포함되어 있다면 해당 위치를 반환함 int indexof(String s)
		 */
		// int index = s.indexOf("J");
		// System.out.println(index);
		// index = s.indexOf("Java");
		// System.out.println(index);
		// index = s.indexOf("t"); // 없을경우 -1
		// System.out.println(index);
		// index = s.indexOf("a"); // 중복될경우 첫번째거
		// System.out.println(index);
		// index = s.indexOf("a", 2); // 뒤에 숫자값 넣을경우 2번인덱스부터만 검색
		// System.out.println(index);
		// index = s.indexOf("a", s.indexOf("a")+1); // 이런식으로 반복하면 2번째것의 위치를 찾을수
		// 있다.
		// System.out.println(index);
		// index = s.lastIndexOf("a"); // 뒤에서부터 검색
		// System.out.println(index);
		// index = s.lastIndexOf("a", 8); // 뒤에서부터 8번째 인덱스부터 제일 앞까지 검색
		// System.out.println(index);

		/*
		 * boolean startsWith(String s) 지정한 문자열로 시작하나 판단 boolean endsWith(String
		 * s) 지정한 문자열로 끝나나 판단
		 * 
		 */
		// s = "my1.jpg";
		// System.out.println(s.startsWith("my"));
		// System.out.println(s.startsWith("me"));
		// System.out.println(s.endsWith("jpg"));
		// System.out.println(s.endsWith("gif"));
		//
		// s = "홍길동";
		// System.out.println(s.startsWith("홍"));
		// System.out.println(s.endsWith("길동"));

		// String replace(char oldChar, char newChar) 해당 문자열이 있으면 대상문자열로 변환함.
		// String replaceall(regex(정규표현식), replacement) 해당 문자열 내용 전부를 대상문자열로
		// 변환함.
		// System.out.println(s.replace("Is", "Off"));

		s = "0a1b2c3b4b5b6c7c8c9";
		 for (int i = 0; i<= 9; i++){
		 s = s.replace("" +i, "");
		 }
		 System.out.println(s);

//		s = s.replaceAll("[A-Za-z]", ""); // 정규표현식 : [시작-끝시작-끝]
//		System.out.println("s = " + s);
		
		// 이름:이메일:거주지
//		s = "홍길동:a@a.com:서울";
		
//		String result = "";
//		int sIndex = s.lastIndexOf(":");
//		System.out.println(sIndex);
//		for (int i = sIndex + 1; i < s.length(); i++) {
//			result += s.charAt(i);
//		}
//		System.out.println(result);
		
//		int sIndex = s.lastIndexOf(":");
//		String result = s.substring(sIndex +1); //sIndex + 1 위치에서부터 잘라냄
//		System.out.println(result);
//		
//		sIndex = s.indexOf(":");
//		result = s.substring(sIndex +1); //sIndex + 1 위치에서부터 잘라냄
//		System.out.println(result);
		
		// substring(beginIndex, endIndex+1)
		// a@a.com
//		int sIndex = s.indexOf(":");
//		int eIndex = s.lastIndexOf(":");
//		String result = s.substring(sIndex+1, eIndex);
//		System.out.println(result);
//		
//		s = "서울:111-111:a@a.com:011-111-111:ah@a.com";
//		String [] sArr = s.split(":"); //:기준으로 배열생성
//		System.out.println(sArr[2]);
		
//		System.out.println(s.toUpperCase()); //대문자로
//		System.out.println(s.toLowerCase()); //소문자로
		
//		s = "   a a a   ";
//		s= s.trim(); // 문자열의 양쪽공백 제거
//		System.out.println(s.length());
//		System.out.println(s);
		
		// 다른 타입의 데이터를 문자열로 변경
//		String str = "1";
		// 만약, 메서드에 static 키워드가 붙어있다면 이 메서드는 클래스이름.메서드명으로 호출한다.
		int a = 1;
		String str = String.valueOf(a);		
		System.out.println(str);
	}
}