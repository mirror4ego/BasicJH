package day09;
class StaticSub01 {
	int i = 100;
	static int k = 100;
	// 클래스 정보가 올라가는 시점 확인
	// static block : 클래스 정보가 올라가는 시점에 실행되는 블럭
	static {
		System.out.println("static block 실행됨");
	}

}
public class StaticTest01 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(StaticSub01.k);
		StaticSub01 ss = null;
		System.out.println(2);
		// 객체를 생성할 때 클래스 정보가 필요하기 때문에 클래스 정보가 로딩된다.
		// 클래스 정보 로딩시 해당 클래스의 static블럭이 실행된다.
		ss = new StaticSub01();
		System.out.println(3);
		// 클래스 정보가 이미 올라갔기 때문에 메서드 에어리어의 크래스 정보를 참조한다.
		StaticSub01 ss2 = new StaticSub01();
		System.out.println(4);
	}
}
