package day14;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ListTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		// 데이터 추가
		list.add("one");
		list.add("two");
		list.add("three");

		// 리스트 데이터 추출
		// 1. for
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// 2. for each
		for (String val : list) { // list의 크기만큼 돌면서 임시변수 val에 하나씩 넣어줌
			System.out.println(val);
		}
		
		// 3. Iterator(순환자)
		Iterator<String> ite = list.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}

		// 크기확인 
		System.out.println(list.size()); // 데이터 삭제 인덱스
		System.out.println(list.remove(0)); // 삭제후 크기확인
		System.out.println(list.size()); // 데이터 삭제 요소
		System.out.println(list.remove("two")); // 삭제후 크기확인
		System.out.println(list.size());

		// 전체삭제
		list.clear();
		System.out.println(list.size());

		// 리스트가 비어있는지 판단
		if (list.isEmpty()) {
			System.out.println("리스트 비어있음");
		} else {
			System.out.println("리스트 비어있지 않음");
		}

		list.add("one");
		list.add("two");
		list.add("three");

		// 있는지 검색
		if (list.contains("two")) {
			System.out.println("two포함됨");
		} else {
			System.out.println("two불포함");
		}

		// 인덱스값 추출
		int index = list.indexOf("two");
		System.out.println(index);

		List<String> sub = new ArrayList<>();
		sub.add("four");
		sub.add("five");

		// 콜렉션 데이터 입력
		list.addAll(sub);
		System.out.println(list.size());

	}
}