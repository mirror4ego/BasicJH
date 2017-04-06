package day12.quiz;

public class JuminNumberException extends Exception {
	public JuminNumberException(String jNum, boolean b) {
		super(jNum + "중에 문자가 있습니다.");
	}
	
	public JuminNumberException(String jNum) {
		super(jNum + "은 13자리가 아닙니다.");
	}
}
