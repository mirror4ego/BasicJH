package day11.exam;

public class Dog extends Animal {
	Dog () {}
	Dog (String name) {
		this.name = name;
	}

	@Override
	public void cry() {
		System.out.printf("%s : 멍멍 짖습니다.\n", name);
	}
	
	@Override
	public void eat() {
		System.out.printf("%s : 먹습니다.\n", name);
	}
	
}
