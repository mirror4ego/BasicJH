package day15.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		String movieStar = getMovieStar("왕의 남자");
		System.out.println(movieStar);

		movieStar = getMovieStar("태극기 휘날리며");
		System.out.println(movieStar);
	}

	// 구현하기
	private static String getMovieStar(String movieName)  {
		File f = new File("src/day15/exam/Quiz02.txt");

		Scanner sc=null;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while (sc.hasNextLine()) {
			String [] arr = sc.nextLine().split(",");
			if (arr[0].equals(movieName)) {
				return arr[2];
			} 
		}
		return "영화정보가 없습니다.";
	}
}