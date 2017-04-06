package day15;

import java.io.File;
import java.util.Arrays;

public class FileTest03 {
	public static void main(String[] args) {
		File f = new File("data");
		String[] list = f.list(); // data폴더내의 정보를 스트링배열로 받아옴
		System.out.println(Arrays.toString(list));
		for (String name : list) {
			System.out.print(name);
		}
		
		File[] fList = f.listFiles();  //data폴더내의 정보를 파일객체로 받아옴
		for (File fSub : fList) {
			System.out.println(fSub.isDirectory());
			System.out.println(fSub.isFile());
			System.out.println(fSub.getName());
		}

	}
}
