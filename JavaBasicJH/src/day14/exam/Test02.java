package day14.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("src/day14/exam/CollectionExam02.txt");
		Scanner s = new Scanner(f);
		ArrayList<Test02VO> list = new ArrayList<>();
		while (s.hasNextLine()) {
			Test02VO vo = new Test02VO();
			String[] tArr = s.nextLine().split("/");
			vo.setName(tArr[0]);
			vo.setLanguage(tArr[1]);
			int score = Integer.parseInt(tArr[2]);
			vo.setScore(score);
			if (tArr[1].toUpperCase().equals("JAVA") && score >= 70) {
				vo.setPass("(수료)");
			}
			if (tArr[1].toLowerCase().equals("sql") && score >= 85) {
				vo.setPass("(수료)");
			}
			list.add(vo);
		}
		
		for (int i = 0 ; i < list.size(); i++) {
			Test02VO vo =  list.get(i);
			System.out.printf("이름 : %s, %s:%d%s\n",vo.getName(), vo.getLanguage(), vo.getScore(), vo.getPass() );			
		}
	}
}