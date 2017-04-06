// 오버라이딩 이유 : 부모클래스의 형태가 맞지 않아 재정의 하기 위해

package day10;

import java.util.Random;

class Dog {
	private String name;
	
	public Dog(){}
	public Dog(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	 public String toString() {
	        return getName();
	   }
}

class Cat {
	
}

public class ObjectTest {
	public static void main(String[] args) {
		String s = new String("a");
		System.out.println(s); // s.toString() --> a
		
		Cat c = new Cat();
		System.out.println(c); // c.toString();
		
		Dog d = new Dog("대중소");
		
		// 객체변수를 출력 또는 객체변수를 문자열 형태로 변환뵈어야 할 때 자동으로 toString() 메서드가 자동 호출된다.
		System.out.println(d); // toString()이 자동 호출됨
		System.out.println(d.toString());
		
		int[] iArr = {1,2,3};
		int[][] jArr = {{1},{2},{2},{3}};
		System.out.println(iArr);
		System.out.println(jArr);
		
		java.util.Date d2 = new java.util.Date();
		System.out.println(d2);
		
		Random r = new Random();
		System.out.println(r);
		
	}
}
