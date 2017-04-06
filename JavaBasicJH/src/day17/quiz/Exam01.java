package day17.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exam01 {
	public static void main(String[] args) throws Exception {
		try {
			dataCheck("data/data1.txt", "data/data2.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dataCheck(String file1, String file2) throws Exception {
		File f1 = new File(file1);
		Scanner sc1 = new Scanner(f1);
		File f2 = new File(file2);
		Scanner sc2 = new Scanner(f2);
		int count = 1;
		while (sc1.hasNextLine()) {
			String fString1 = sc1.nextLine();
			String fString2 = sc2.nextLine();
			if (fString1.toUpperCase().equals(fString2.toUpperCase())) {
				System.out.printf("LINE %d : Equal\n", count++);
			} else {
				System.out.printf("LINE %d : Not Equal\n", count++);
			}
		}
	}
}
