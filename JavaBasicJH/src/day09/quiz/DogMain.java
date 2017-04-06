package day09.quiz;
class Dog {
	private String name;
	private int age;
	
	Dog () {
		this ("이름모름", 0);
	}
	
	Dog (String name) {
		this (name, 0);
	}
	
	Dog (int age) {
		this ("이름모름", age);
	}
	
	Dog (String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void info () {
		System.out.printf("강아지의 이름은 %s이고 나이는 %d입니다.", name, age);
	}
}
public class DogMain {
	public static void main(String[] args) {
		Dog d = new Dog();
		Dog d2 = new Dog("쫑");
		Dog d3 = new Dog(3);
		Dog d4 = new Dog("메리", 2);
		d.info();
		d2.info();
		d3.info();
		d4.info();
	}
}