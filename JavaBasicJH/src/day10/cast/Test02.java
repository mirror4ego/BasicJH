package day10.cast;

public class Test02 {
	public static void main(String[] args) {
//		Animal a = new Cat(); 불가능
		Animal a = new Dog();
//		Animal a = new Animal(); 불가능
		Dog d = (Dog)a;
// 하위 클래스에 원래 갖고 있던 기능을 쓰고 싶을때 명시적 형변환을 사용한다.
		
	}
}
