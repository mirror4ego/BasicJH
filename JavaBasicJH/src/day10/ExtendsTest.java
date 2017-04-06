package day10;

class Parent { /* extends java.lang.Object */
	Parent() {
		super(); //부모 클래스가 없으면 Object클래스 상속
	}
}

class Child extends Parent {
	Child () {
		super(); // 그런데 Parent클래스에 기본 생성자가 없어서 오류가 남
	}
}

public class ExtendsTest {
	public static void main(String[] args) {
		
	}
}
