package day13;

public class WrapperTest {
	public static void main(String[] args) {
		asdfasdfasd/
		/*
		 *   char		-> Character
		 *   boolean	-> Boolean
		 *   byte		-> Byte
		 *   short		-> Short
		 *   int		-> Integer
		 *   long		-> Long
		 *   float		-> Float
		 *   double   	-> Double
		 *  
		 */
		
		/* 1.4 이전...
		int i = 100;
		// 1.4 까지 활용 방식
		// 기본형 -> 참조형
		Integer iObj = new Integer(i);
		test(iObj);
		
		// 참조형 -> 기본형
		int i2 = iObj.intValue();
		System.out.println(i2);
		*/
		
		// 1.5 부터...
		// AutoBoxing	: 기본형 -> 참조형
		int i = 100;
		Integer iObj = 100; // new Integer(100);
		
		// AutoUnBoxing	: 참조형 -> 기본형
		int i2 = iObj;
		System.out.println(i2);
		
		test(100);	// new Integer(100);
		test('a');  // new Character('a');
		
//		String str = 'a'; // 상속관계가 없어서 못들어감
		
	}
	
	private static void test(Object obj) {
		fsdf
	}
}
