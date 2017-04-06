package day13.generic;
/*
 * 	Box1의 장점
 * 	- 여러가지 종류의 데이터를 담을 수 있다.
 *
 *	Box1의 단점
 *	- 데이터를 추출할 때 항상 형변환 연산자를 이용해서 사용해야 함
 *	- 데이터를 원하는 형태만 받을 수 없기 때문에 컴파일 시에 잘못된 데이터가 입력된 것을 확인 할 수 없다.
 */

public class BoxTest01 {
	public static void main(String[] args) {
		Box1 box = new Box1();
		box.setData("문자열");
		box.setData(100);
		String data1 = (String)box.getData();
		
		Box1 box2 = new Box1();
		box2.setData(100);
		
		
	}
}
