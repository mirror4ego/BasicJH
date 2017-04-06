package day15;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOTest01 {
	public static void main(String[] args) {
//		System.out.println("\\r : "+(int)'\r');
//		System.out.println("\\n : "+(int)'\n');
		InputStream in = System.in;
		InputStreamReader isr = new InputStreamReader(in);
		
		try {
			while(true) {
				int ch = isr.read(); //한  byte 단위로 읽음
				System.out.print((char)ch);
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
