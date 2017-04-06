package day13.generic;

public class BoxTest02 {
	public static void main(String[] args) {
		
		// String 입력
		Box2<String> b = new Box2<String>();
		b.setData("dsfds");
//		b.setData(3242342); //컴파일오류
		String value = b.getData();
		System.out.println(value);
		
		// Integer 입력
		Box2<Integer> c = new Box2<Integer>();
		c.setData(3242342);
		int value1 = c.getData();
		System.out.println(value1);
		
	}
}
