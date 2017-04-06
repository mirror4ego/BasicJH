/*
 *  연예인 정보
 *  ---------------
 *  배수지	경기도 성남시	22세
 *  ............
 *  ----------------
 *  
 */	

package day08.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test0602 {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("src/day08/quiz/quiz02.txt");
		Scanner sc = new Scanner(f);
		String age ="2";
		
		System.out.printf("%s0대연예인 정보\n", age);
		System.out.println("--------------------------------");
		while (sc.hasNextLine()) { 
			String info = sc.nextLine();
			String [] pinfo = info.split(":");
			if (pinfo[2].startsWith(age)) {
				System.out.printf("%s\t%s\t%s세\n", pinfo[0], pinfo[1], pinfo[2]);
			}
		}
		System.out.println("--------------------------------");
	}
}
