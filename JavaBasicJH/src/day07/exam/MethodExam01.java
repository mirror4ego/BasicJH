package day07.exam;

public class MethodExam01 {
	public static void main(String[] args) {
		MethodUtil m = new MethodUtil();		
		System.out.println(m.isUpperChar('a'));
		System.out.println(m.isLowerChar('a'));
		System.out.println(m.max(3,5));
		System.out.println(m.min(3,5));
		System.out.println(m.abs(-3));
	}
}
