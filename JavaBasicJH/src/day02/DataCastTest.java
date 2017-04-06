package day02;

public class DataCastTest {
	public static void main(String [] args){
		byte b = 1;
		int i = 128;
		
		// byte b2 = i;   오류발생
		byte b2 = (byte)i; //명시적 형변환, 다운 캐스팅(int 4byte 데이터중에 1byte만 남김 = 값이 손실)
		System.out.println("b2="+b2);  //데이터 손실
		
		int i2 = b;  //묵시적, 암묵적, 업캐스팅 형변환
		System.out.println("i2="+i2); //오류없이 데이터 미손실
		
		char c = 'a';
		// a 문자의 아스키 코드를 출력
		int i3 = c;  //묵시적 형변환
		System.out.println(i3);
		
		char d = 'b';
		// b 문자의 아스키 코드를 출력
		int i4 = d;  //묵시적 형변환
		System.out.println(i4);
		
		System.out.println((int)'b');
		
		// (int)"c" 불가능  문자열은 Integer.parseInt로 바꿔야함
				
						
	}

}
