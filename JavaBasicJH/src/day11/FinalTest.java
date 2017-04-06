package day11;

/* final */ class FinalSuper {
	public /* final */ void print() {}
}

class FinalSub extends FinalSuper {
	public void print() {
		System.out.println("재정의된 메서드입니다.");
	}
}

public class FinalTest {
	public static void main(String[] args) {
		
	}
}
