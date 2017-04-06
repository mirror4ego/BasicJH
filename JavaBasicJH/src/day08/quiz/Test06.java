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

public class Test06 {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("src/day08/quiz/quiz02.txt");
		Scanner sc = new Scanner(f);
		System.out.println("연예인 정보");
		System.out.println("-------------------------");
		while (sc.hasNextLine()) { 
			String info = sc.nextLine();
			String [] pinfo = info.split(":");
			System.out.printf("%s\t%s\t%s세\n", pinfo[0], pinfo[1], pinfo[2]);	
		}
		System.out.println("-------------------------");
	}
}
