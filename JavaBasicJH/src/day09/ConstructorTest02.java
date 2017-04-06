/**
 * 디폴트 생성자(Default Constructor)
 * - 개발자가 클래스 정의시 명시적으로 생성자를 정의하지 않은 경우 컴파일러가 기본 생성자를 자동으로 정의한다.
 * - 기본생성자의 형태는 클래스명과 동일하고 매개변수가 없는 형태임  클래스명() {}
 * 
 *  코드 작성시
 *  기본 생성자 형태가 아닌 생성자를 별도로 정의시
 *  기본 생성자 형태도 같이 정의해 준다.
 */
package day09;

class ConsTest {
	// 생성자가 정의 되지 않았으므로 컴파일러가 생성자 정의
	// 자동 제공되는 생성자 형태
	// ConsTest() {}
	ConsTest() {}
	ConsTest(int i) {}
	
}

public class ConstructorTest02 {
	public static void main(String[] args) {
		ConsTest ct = new ConsTest();
	}
}
