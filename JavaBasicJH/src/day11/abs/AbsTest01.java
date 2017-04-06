package day11.abs;

abstract class AbsSuper {
	public void print() {
		System.out.println("구현된 메서드");
	}
	public abstract void call();
}

class AbsSub extends AbsSuper {
	public void call() { // 부모에 있는 추상 클래스를 무조건 오버라이딩 해야 한다.
		System.out.println("AbsSub 의 call()");
	}
}

public class AbsTest01 {
	public static void main(String[] args) {
//		AbsSuper aSuper = new AbsSuper();   추상클래스는 객체(인스턴스) 생성이 안된다.
		// 추상클래스가 나오면 반드시 자식클래스가 나와야 한다. 그래야 활용 가능
//		AbsSuper aSuper = null; // 객체 변수 생성은 가능  묵시적 형변환
		AbsSuper aSuper = new AbsSub();
		
		aSuper.call();
		aSuper.print();
		
	}
}
