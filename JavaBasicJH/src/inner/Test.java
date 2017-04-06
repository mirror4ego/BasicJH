package inner;

/*
 * 	내부 클래스
 * 	4가지 종류
 * 	class {
 * 		1. 멤버 내부 클래스
 * 		class InnerMember {}
 * 		2. static 내부 클래스
 * 		static class InnerMember {}
 * 
 * 		method() {
 *			3. Name local class
 *			class LocalInner {}
 *			4. 익명 내부 클래스(가장 많이 사용 - 이벤트)
 *			객체 생성 + 클래스 바디
 *			클래스명 : 상속하려는 클래스명 또는 
 *			new 클래스명( ) {	
 *				메서드 선언
 *			};
 *			new OnClickListener( ) {	
 *				메서드 선언
 *			};
 *		}
 *	}
 */
interface OnclickListener {
	public void onClick();
}

class InterSub implements OnclickListener {
	@Override
	public void onClick() {
		System.out.println("재정의 된 메서드");
	}
}

class InterSub2 implements OnclickListener {
	@Override
	public void onClick() {
		System.out.println("Sub2 클릭됨");
	}
}


public class Test {
	public void setOnClickListener(OnclickListener a) {
		a.onClick();
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		
		// OnclickListener 타입 생성하기
		OnclickListener a = new InterSub();
		t.setOnClickListener(a);
		
		OnclickListener b = new InterSub2();
		t.setOnClickListener(b);
		
		t.setOnClickListener(new OnclickListener() {
			public void onClick() {
				System.out.println("익명(임시) 클래스");
			}
		});
	}
}
