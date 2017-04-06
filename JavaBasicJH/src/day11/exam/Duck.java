package day11.exam;

public class Duck extends Animal implements Flyable {
	Duck () {}
	Duck (String name) {
		this.name = name;
	}
		
	
	@Override
	public void cry() {
		System.out.printf("%s : 꽥꽥웁니다.\n", name);
	}

	@Override
	public void eat() {
		System.out.printf("%s : 먹습니다.\n", name);
	}
	@Override
	public void fly() {
		System.out.printf("%s : 날개를 퍼덕거리지만 날지 못합니다.\n", name);			
	}
	
}
