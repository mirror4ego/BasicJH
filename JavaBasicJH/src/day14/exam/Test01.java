package day14.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("src/day14/exam/CollectionExam01.txt");
		Scanner s = new Scanner(f);
		ArrayList<Test01VO> list = new ArrayList<>();
		
		while (s.hasNextLine()) {
			Test01VO data = new Test01VO();
			String[] t = (s.nextLine().split(":"));
			data.setGroup(t[0]);
			String[] tScore = t[1].split("-");
			data.setJava(Integer.parseInt(tScore[1]));
			tScore = t[2].split("-");
			data.setSql(Integer.parseInt(tScore[1]));
			tScore = t[3].split("-");
			data.setJsp(Integer.parseInt(tScore[1]));	
			list.add(data);
		}
		
		// 자바 전체 평균 점수
		int sum = 0;
		int [] avrArr = new int[list.size()];
		for (int i = 0; i<list.size(); i++) {
			sum = sum + list.get(i).getJava();
			avrArr[i] = (list.get(i).getJava()+list.get(i).getSql()+	
					list.get(i).getJsp())/(list.size()-1);
		}
		int JavaAvr = sum / list.size();
		
		int maxAvr=0;
		String no1="";
		// 각조 평균점수 1등
		for (int i = 0; i<list.size(); i++) {
			if (maxAvr < avrArr[i]) {
				maxAvr = avrArr[i];		
				no1 = list.get(i).getGroup();
			}
		}
		
		System.out.printf("자바 전체 평균 점수 : %03d점\n", JavaAvr);
		System.out.printf("1등 %s 평균 점수 : %03d점\n",no1, maxAvr);
		
		
		
//		for (Test01VO val:list) {
//			System.out.println(val);
//		}
//		
		Collections.sort(list);
		
		Iterator<Test01VO> ite1 = list.iterator();
		while (ite1.hasNext()) {
			System.out.println(ite1.next());
		}
		
	}
}