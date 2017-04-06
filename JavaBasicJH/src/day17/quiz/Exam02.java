package day17.quiz;

import java.io.File;
import java.util.Scanner;

public class Exam02 {
	public static void main(String[] args) {
		try {
			searchFileContent("data/find.txt", "System");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param readFileName	: data/find.txt 
	 * @param findStr		: System
	 * @throws Exception
	 */
	public static void searchFileContent(String readFileName, String findStr) throws Exception {
		File f = new File(readFileName);
		Scanner sc = new Scanner(f);
		int count = 0;
		while (sc.hasNextLine()) {
			count++;
			String line = sc.nextLine();
			if (line.contains(findStr)) {
				System.out.println(count + line);
			}
		}
		
	}
}
