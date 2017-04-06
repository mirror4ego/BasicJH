package day15.quiz;

import java.io.File;

public class Test02 {
	public static void main(String[] args) {
		// data 디렉토리 하위의 파일들의 정보를 아래와 같이 출력
		/*
		 * 출력 형식 > 디렉토리 : a 파일 : a.txt 파일 : file.txt
		 */
		File f = new File("data");
		String type = "";

		// case1
		String[] list = f.list();
		for (String sub : list) {
			if (new File(f, sub).isFile()) {
				type = "파일  : ";
			} else if (new File(f, sub).isDirectory()) {
				type = "디렉토리 : ";
			}
			System.out.println(type + sub);
		}

		// case2
		File[] fList = f.listFiles();
		for (File fSub : fList) {
			if (fSub.isFile()) {
				type = "파일  : ";
			} else if (fSub.isDirectory()) {
				type = "디렉토리 : ";
			}
			System.out.println(type + fSub.getName());
		}
	}
}
