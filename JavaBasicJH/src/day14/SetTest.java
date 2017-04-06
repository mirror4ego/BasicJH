package day14;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("a");
		set.add("b");
		set.add("c");
		System.out.println(set.size());
		
		set.add("a"); // 중복 허용 안됨
		System.out.println(set.size());
		
		// set 데이터 추출
		// 1. for each
		for (String val : set) {
			System.out.println(val);
		}

		// 2. Iterator
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		
	}
}
