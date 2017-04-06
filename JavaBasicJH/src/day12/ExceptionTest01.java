package day12;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionTest01 {
	public static void main(String[] args) throws FileNotFoundException  {
		/*
		 * 컴파일 시점에 발생하는 예외
		 * 이클립스가 오토컴파일시 에러메시지에 exception가 포함되어 있는 경우 
		 */
		FileReader fr = new FileReader("a.txt"); 
		
		
	}
}
