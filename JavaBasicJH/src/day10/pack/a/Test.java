package day10.pack.a;

public class Test {
	public static void main(String[] args) {
		Data d = new Data();
		System.out.println(d.name);
		System.out.println(d.pass);
		System.out.println(d.email);
		// private 는 무조건 선언된 클래스에서만 직접 접근이 가능하다.
//		System.out.println(d.money);
	}
}
