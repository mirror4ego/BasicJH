package day17.quiz;

import java.io.File;
import java.util.Scanner;

public class Exam03 {
	public static void main(String[] args) {
		try {
			searchEmployeeInfo("data/employee.txt", "김");
			searchEmployeeInfo("data/employee.txt", "다");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void searchEmployeeInfo(String readFileName, String lastName) throws Exception {
		File f = new File(readFileName);
		Scanner sc = new Scanner(f);
		System.out.println("================================================");
		int count = 0;
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if (line.startsWith(lastName)) {
				count++;
				String[] arr = line.split(":");
				System.out.printf("이름 : %s	나이 : %s	부서 : %s	월급 : %s\n", arr[0], arr[1], arr[2], arr[3]);
			}
			
		}
		System.out.println("================================================");
		System.out.printf("%s씨 성을 가진 회원은 총 %d명 입니다.\n", lastName, count);
		System.out.println("================================================");
	}
}
