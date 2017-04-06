package day02;

import java.util.Date;
import java.util.Random;

public class VariableTest {
public static void main(String[] args) {
	int i; 						//정수 i 선언
	i = 100;					//i에 값 100 대입
	System.out.println(i); 		//i의값 출력
	
	Date r = new Date();
	System.out.println(r);
	
	Random t = new Random();
	System.out.println(t.nextFloat());
	
	}
}
