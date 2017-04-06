package day10.cast;

public class Test {
	/*
	public static void process (Dog d) {
		d.eat();
	}

	public static void process (Cat c) {
		c.eat();
	}
   */
	
	public static void process(Animal a){
		a.eat();
	}
	
	
	
	public static void main(String[] args) {
		Dog d = new Dog();
			
		// 메서드 호출시 Dog 객체의 eat 메서드 호출		
		process(d);
		
		Cat c = new Cat();
		process(c);
		
		
		Animal an;		
		// 묵시적 형변환
		Animal ani = new Dog();
		System.out.println(ani.name);
		System.out.println(ani.age);
		ani.eat();
//		ani.bark();
		// 앞에있는 타입에 있는것만 쓸수있다.
		// ani는 자신의 타입인 name, age, eat()만 써야함
		// 예외적으로 만약, 자식클래스가 메소드를 오버라이딩 했다면 부모의 메서드가 아닌 자식의 메소드가 호출된다.
		// 변수는 관계없이 보무타입을 사용
		
		
		
	}
}
