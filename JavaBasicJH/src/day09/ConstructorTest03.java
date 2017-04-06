/**
 *  생성자의 주된 역할
 *   - 객체가 생성시에 필요한 기본값들을 초기화 시켜준다.
 *   
 *   히든변수(Hidden Variable) this
 *   - static이 붙지 않은 메소드에 첫번째 매개변수로 자동 제공되는 변수
 *   - this는 생성되는 인스턴스를 가리킨다.
 */
package day09;

class Member {
	private String id;
	private String pass;

	Member(/* Member this*/ ) {
		this("no");
	}
	
	Member(String id) {
		this(id, "0000");
	}

	Member(String id, String pass) {
		this.id = id;
		this.pass = pass;
		System.out.println(getId());
		System.out.println(getPass());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}

public class ConstructorTest03 {
	public static void main(String[] args) {
		Member m = new Member();
		m.setId("tester");
		m.setPass("1234");


		Member m2 = new Member("tester", "1234");
		
		Member m3 = new Member("tester");
	}
}