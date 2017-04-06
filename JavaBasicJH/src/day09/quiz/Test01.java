package day09.quiz;

class TestQuiz {
//	static TestQuiz tq = new TestQuiz();
//	private static TestQuiz tq = new TestQuiz();
	private static TestQuiz tq = null;
	public static TestQuiz getInstance(){
		if (tq == null) {
			tq = new TestQuiz();
		}
		return tq;
	}
	private TestQuiz() {}
	public void msg() {
		System.out.println("성공");
	}	
	
}
	
	// 이 프로그램이 동작될수 있게 코드를 추가하여 Test01 클래스에서 객체 변수를 얻을수 있게 작성한다.
	// 단, 생성자 추가는 안된다.
	// 위의 코드는 변경하면 안된다.


public class Test01 {
	public static void main(String[] args) {
		TestQuiz tq = TestQuiz.getInstance();
		tq.msg();
	}
}
