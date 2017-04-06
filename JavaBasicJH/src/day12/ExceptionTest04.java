package day12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest04 {
	public static void main(String[] args) {
		/*
		try {
			FileReader fr = new FileReader("data/b.txt");
			try {
				fr.read();			
			} catch (IOException e1){
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} 
		*/
		/*
		FileReader fr = null;
		try {
			fr = new FileReader("data/a.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//	예외가 발생하면 fr은 null이다.
		try {
			fr.read();
		} catch (IOException e) {
			
		}
		*/
		
		// 다중 캐치 블락은 상위 클래스를 위에 놓아야 한다.
		try {
			FileReader fr = new FileReader("data/b.txt");
			fr.read();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
		try {
			FileReader fr = new FileReader("data/b.txt");
			fr.read();
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
}
