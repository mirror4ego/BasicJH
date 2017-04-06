/*
 * quiz02.txt 파일의 내용을 읽어서 아래와 같이 출력되도록 코딩 작성
 * 
 * 출력형식>
 * 
 * 총 인원 : 5명
 * 김씨 인 사람 2명
 * ---------
 * 김래원~
 * 김명민~
 * ---------
 */
package day08.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("src/day08/quiz/quiz02.txt");
		
		int count = 0;
		int fNameCount = 0;
		String fName = "김";
		
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine() == true) {
			++count;
			String actor = sc.nextLine();
			if (actor.startsWith(fName)) {
				fNameCount++;
			}
		}
		
		System.out.println("총 인원 :"+ count+"명");
		System.out.printf("%s씨 인 사람 %d명\n", fName, fNameCount);
		System.out.println("-------------------");
		
		sc = new Scanner(f);
		while (sc.hasNextLine() == true) {
			String actor = sc.nextLine();
			if (actor.startsWith(fName)) {
				System.out.println(actor);
			}
			
		}
		System.out.println("-------------------");
	}
}