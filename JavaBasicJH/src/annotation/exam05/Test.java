package annotation.exam05;

import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) throws Exception {
		
		Class<?> clz = AnnoApply.class;
		
		Method method = clz.getDeclaredMethod("info");
		RuntimeAnno2 anno2 = method.getAnnotation(RuntimeAnno2.class);
		System.out.println("id : " + anno2.id());
		System.out.println("msg : " + anno2.msg());
		
		/*
		// 클래스에 선언된 특정 어노테이션 가져오기
		RuntimeAnno1 anno1 = clz.getAnnotation(RuntimeAnno1.class);
		ClassAnno anno2 = clz.getAnnotation(ClassAnno.class);
		
		System.out.println(anno1 + "," + anno1.value());
		System.out.println(anno2);
		*/
		
		/*
		// 전체 설정된 어노테이션 확인
		Annotation [] annoArr = clz.getAnnotations();
		System.out.println("Class에 선언된 어노테이션");
		System.out.println("=================================================================");
		for (Annotation anno : annoArr) {
			System.out.println(anno);
			System.out.println(((RuntimeAnno1)anno).value());
		}
		System.out.println("=================================================================");
		*/
	}
}
