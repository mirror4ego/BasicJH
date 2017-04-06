package day15.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		ArrayList<Student> list = getStudentList("src/day15/exam/Quiz03.txt");

		for (Student s : list) {
			System.out.println(
					s.getName() + " : " + s.getKor() + " " + s.getEng() + " " + s.getMath() + " " + s.getSum());
		}
	}
	
	public static ArrayList<Student> getStudentList(String fileName) {
		ArrayList<Student> list = new ArrayList<>();
		File f = new File(fileName);
		Scanner sc=null;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(sc.hasNextLine()) {
			Student s = new Student();
			String[] arr = sc.nextLine().split("/");
			s.setName(arr[0]);
			s.setKor(Integer.parseInt(arr[1]));
			s.setEng(Integer.parseInt(arr[2]));
			s.setMath(Integer.parseInt(arr[3]));
			s.setSum(Integer.parseInt(arr[1])+Integer.parseInt(arr[2])+Integer.parseInt(arr[3]));
			list.add(s);
		}
		return list;
	}

}