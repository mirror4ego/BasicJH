package day12.quiz;

import java.util.Scanner;

public class JuminService{
	public void execute() throws JuminNumberException  {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호를 입력하세요 : ");
		String jNum = sc.nextLine();
		jNum = jNum.replace("-", "");
		if (jNum.length() != 13) {
			throw new JuminNumberException(jNum);			
		} else if (jNum.matches(".*[a-zA-z].*")){
			throw new JuminNumberException(jNum, true);
		} else {
		System.out.println("올바른 주민번호를 입력하였습니다.");
		}
	}
}
