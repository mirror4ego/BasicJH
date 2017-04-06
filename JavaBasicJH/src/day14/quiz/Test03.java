package day14.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		
		// Test03.txt 읽어서
		// List에 담는다.
		// List에 파일의 내용을 담을 떄 데이터 클래스를 생성 한후 담는다.
		// Test03Data - name, score
		
		List<Test03Data> list = new ArrayList<>();
		
			File f = new File("src/day14/quiz/Test03.txt");
			
			Scanner sc = null;
			try {
				sc = new Scanner(f);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}		
		
		while (sc.hasNextLine()) {
			String[] temp = sc.nextLine().split(":");
			Test03Data data = new Test03Data();
			data.setName(temp[0]);
			data.setScore(Integer.parseInt(temp[1]));
			list.add(data);
		}
		
		for (Test03Data val:list) {
			System.out.println(val);
		}
		
		
	}
}
