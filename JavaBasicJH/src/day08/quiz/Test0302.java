/*
 * quiz01.txt 파일의 내용을 읽어서 아래와 같이 출력되도록 코딩 작성
 * 
 * 출력형식>
 * 
 * 1. c.txt
 * 
 */
package day08.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test0302 {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("src/day08/quiz/quiz01.txt");
		Scanner sc = new Scanner(f);
		int count = 0;
		while (sc.hasNextLine()) {
			String fileName = sc.nextLine();
			if (fileName.endsWith("txt")) {
				System.out.println(++count + ". " + fileName);	
			}
		}
	}
}