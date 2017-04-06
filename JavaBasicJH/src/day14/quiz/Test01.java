package day14.quiz;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Test01 {
	public static void main(String[] args) {
		// 로또 번호 (1-45) 사이의 숫자 6개를 생성해서 화면에 출력한다
		// Set을 이용
		
		Random r = new Random();
		Set<Integer> set = new HashSet<>();
		while(set.size() != 6) {
			set.add(r.nextInt(45)+1);
		}
		System.out.println(set);
		for (int val : set) {
			System.out.print(val+ " ");
		}
		
	}
}
