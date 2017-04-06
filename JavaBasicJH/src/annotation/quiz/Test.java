package annotation.quiz;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("경로 입력 : ");
		String uri = sc.nextLine();
		
		Class<?> clz = BoardController.class;
		Object obj = clz.newInstance();
		Method[] mArr = clz.getDeclaredMethods();
		
		boolean isExist = false;
		for (Method method: mArr) {
			RequestMapping rAnno = method.getAnnotation(RequestMapping.class);
			if (rAnno == null) continue;				
			if (!rAnno.value().equals(uri)) continue;
			method.invoke(obj);
			isExist = true;
			break;
		}	
		
		if (!isExist) {
			System.out.println("존재하지 않는 URL 입니다.");
		}
		
	}
}
