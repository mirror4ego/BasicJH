package day10.quiz;

class Car {
	String name;
}

public class Test01 {
	public static void main(String[] args) {
		ArrayList list2 = new ArrayList();
		list2.add(new Car());
		
		ArrayList list = new ArrayList();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		
		String data = (String)list.get(1);
		// two 가 출력되도록 기능 구현
		System.out.println("data : "+data);
		
		int size = list.size();
		System.out.println("입력된 데이터 크기 : " + size);
		
		// two 데이터를 삭제처리함
		list.remove(1);
		
		// 3이 출력
		size = list.size();
		System.out.println("삭제후 데이터 크기 : " + size);
		
		// [one, three, four]
		System.out.println(list);
		
	}

}
