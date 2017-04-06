/**
 * 객체 지향 다형성
 *  - 자바에서 지원하는 형태 3가지 존재
 *  1. 오버로딩
 *  2. 오버라이딩
 *  3. 변수의 다형성
 * 
 * 
 * 오버로딩 :
 * 메서드 이름이 같고 매개변수의 타입 또는 개수가 다르다.
 * 다형성 : 하나의 메서드로 여러가지 변수타입을 줄수 있을 경우(여러가지 기능 수행 가능)
 */

package day09;

class Bread {
	static private String name;
	static private int price;
	public Bread(String s, int i) {
		System.out.println("생성자 호출됨..");
		setName(s);
		setPrice(i);
	}
	
	public Bread() { 
		System.out.println("생성자 호출됨..");
	}
	
	// 생성자 - 필수 지켜야 하는 사항
	// 1. 클래스 이름 동일
	// 2. 반환 타입이 없어야 한다.
	// 3. 생성자는 오버로딩이 지원된다.
	
	public String getName(){
		return name;
	}

	public void setName(String s) {
		name = s;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int i) {
		price = i;		
	}
	
}

public class ConstructorTest {
	public static void main(String[] args) {
		Bread b = new Bread("소보루", 1000);
		System.out.println(b.getName());
		System.out.println(b.getPrice());
		Bread b2 = new Bread();
		b2.setName("단팥빵");
		b2.setPrice(1500);
		System.out.println(b2.getName());
		System.out.println(b2.getPrice());
	}
}
