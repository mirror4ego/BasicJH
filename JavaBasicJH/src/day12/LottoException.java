package day12;

// 예외관련 클래스
public class LottoException extends Exception {
	
	public LottoException() {
		super(" 잘못된 로또 번호입니다."); //Exception
	}
	
	public LottoException(int no) {
		super(no + " 잘못된 로또 번호입니다."); //Exception
	}
}
