package day07;

public class Singer {
	// private : 이 클래서 안에서만 사용가능(외부에서 직접접근 불가)
	// 선언된 Singer클래스 안에서만 직접접근 가능
	private String name;
	private int age;
	//멤버변수의 값을 반환하기 위한 기능 메서드 작성
	//게터(getter)
	//메스 작성 방식
	//접근제한자  반환타입        메서드명      매개변수
	// public 멤버변수타입   get변수명     없음

	// 멤버변수의 값을 설정하는 기능의 메서드 작성
	// 세터(setter)
	// 메서드 작성 방식
	// 접근제한자  반환타입   메서드명      매개변수
	// public  void   set변수명    변수에 들얼갈 값의 타입

	public void setName(String n) {
		name = n;
	}

	public void setAge(int a) {
		if (a < 0){
			System.out.println("입력된 나이가 올바르지 않습니다.");
			System.exit(0);
		}
		age = a;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
}
