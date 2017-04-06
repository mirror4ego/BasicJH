/**
 *  상속을 받는다고 무조건 부모의 속성 도는 메서드를 사용할 수 있는것은 아니다.
 *  접근제한자가 허용되어야 사용이 가능하다.
 *  (private : 선언된 클래스에서만 직접 접근이 가능한다.)
 */
package day09;

class Person{
//	private String name; // private가 있는변수는 상속되지 않는다.
	String name;
	int age;
	
	Person() {}
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return "name=" + name + ", age=" + age;
	}
}

class Student extends Person {
	// 부모와 자식이 동일한 이름을 가지고 있을 경우 자신의 것을 먼저 접근한다.
	// 이때 부모의 변수가 가려지게 되는데 이것을 쉐도우변수 라고 한다.
//	String name; //가까운쪽 먼저 찾음
	String no; //학번
	
	Student() {}

	Student(String name, int age, String no) {
		super(name, age);
		this.no = no;
	}
	
	public String toString() {
		// 부모가 가지고 있는 변수 및 메서드에 접근하기 위해서 super 키워드 사용함
		// 먼저 자신 클래스에 있는 메서드를 호출하기 때문에
		// stackOverflow
		return super.toString() + ", no=" + no;
//		return "name=" + name + ", age=" + age + ", no=" + no;
	}
	
}

public class ExtendsTest {
	public static void main(String[] args) {
		Student s1 = new Student("홍길동", 22, "12345");	
		System.out.println(s1.toString());
	}
}
