package day11.inter;

import java.util.Random;

interface InterA {
	public void a();
}

// interface extends interface,.... ( 다중상속 )
interface InterB extends InterA {
	public void b();
}


interface InterSuper { // 인터페이스에 있는 메소드는 모두 추상 메소드
	int PORT = 8000; // public static final 인터페이스에서 선언되는 모든 변수에 붙은다.
	public abstract void print();
	void call(); //public abstract 뺴도 괜찮음(자동으로 넣어줌)
}

// class implements interface,... 가 인터페이스를 상송 받을때는 다중 상속이 가능하다.
class InterSub implements InterSuper, InterA { // 인터페이스에 정의 되있는 모든 (추상)메소드를 오버라이딩 해야한다.
	public void print() {
		System.out.println("InterSub - print()");
	}
	public void call() {
		System.out.println("InterSub - call()");
	}
	
	public void a() {
		System.out.println("InterSub - a()");
	}
}

class Hello {}

//class extends class 하나의 클래스만 가능함(단일상속)
class My extends Random/*, Hello */ {

}



public class InterTest01 {
	public static void main(String[] args) {
//		InterSuper iSuper = new InterSuper(); // 추상개념이 들어가 객체 생성이 안된다.
//		InterSuper i = null; // 추상 클래스와 비슷하게 객체변수 설정은 됨.
		InterSuper iSuper = new InterSub();
		iSuper.print();
		iSuper.call();
		
		System.out.println(InterSuper.PORT); // static 으로 붙어있는것만 클래스 이름으로 접근 가능
//		InterSuper.PORT = 10000; // final은 값을 변경 할수 없다.  
	}
}
