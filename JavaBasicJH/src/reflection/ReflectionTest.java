package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

public class ReflectionTest {
	/**
	 * 클래스 객체 정보를 얻는 방법 : 3가지
	 */
	private static void test01() throws Exception {
		// 1. 클래스 이름.class 클래스의 static 필드인 class 이용
		Class<?> clz = Dog.class;
		
		// 2. Class.forName("패키지명.클래스명")
		Class<?> clz2 = Class.forName("reflection.Dog");
		
		// 3. 
		Dog d = new Dog();
		Class<?> clz3 = d.getClass();
		
		System.out.println(clz == clz2);
		System.out.println(clz2 == clz3);
		System.out.println(clz == clz3);
		
		System.out.println(clz.getSimpleName());
		System.out.println(clz.getName());
		
	}

	
	/**
	 *	Class 의 메서드 정보 접근하는 방법 
	 */
	private static void test02() throws Exception {
		// Dog 클래스 정보
		Class<?> clz = Dog.class;
		Method[] mArr = clz.getDeclaredMethods();
		System.out.println("메서드 정보 출력");
		for (Method method : mArr) {
			System.out.println("--------------------------");
			System.out.println("매서드 이름 : " + method.getName());
			
			Class<?> rClz = method.getReturnType();
			System.out.println("반환타입 이름 : " + rClz.getName());
			
			Parameter[] p = method.getParameters();
			for (Parameter param : p) {
				Type t = param.getParameterizedType();
				System.out.println("파라미터 : " + t.getTypeName());
			}
			System.out.println("--------------------------");
		}
		
		/*
		// Dog 클래스에 있는 setName이라는 메소드 정보
		Method method = clz.getDeclaredMethod("setName", String.class);
		System.out.println("메서드 정보 출력");
		System.out.println("--------------------------");
		System.out.println("매서드 이름 : " + method.getName());
		
		// Dog 클래스에 있는 setName이라는 메소드 에서 반환타입 정보
		Class<?> rClz = method.getReturnType();
		System.out.println("반환타입 이름 : " + rClz.getName());
		
		// Dog 클래스에 있는 setName이라는 메소드 에서 파라미터 정보
		Parameter[] p = method.getParameters();
		for (Parameter param : p) {
			Type t = param.getParameterizedType();
			System.out.println("파라미터 : " + t.getTypeName());
		}
		System.out.println("--------------------------");
		*/
	}
	
	/**
	 *	리플렉션을 이용한 객체 생성 
	 */
	private static void test03() throws Exception {
		Class<?> clz = Dog.class;
		
		Object obj = clz.newInstance();
		Dog dog = (Dog)obj;
		dog.setName("쫑");
		System.out.println(dog.getName());
	}
	
	/**
	 *	리플렉션을 이용한 메서드 실행 
	 */
	private static void test04() throws Exception {
		/*	
		 * 	Dog d = new Dog();
		 * 	d.setName("쫑");
		 * 	String name = d.getName();
		 * 	System.out.println("강아지의 이름 :  " + name);
		 */
		Class<?> clz = Dog.class;
		Object obj = clz.newInstance();
		
		Method m1 = clz.getDeclaredMethod("setName", String.class);
		m1.invoke(obj, "쫑");
		
		Method m2 = clz.getDeclaredMethod("getName");
		String name = (String) m2.invoke(obj);
		System.out.println(name);
	}
	
	public static void main(String[] args) throws Exception {
//		test01();
		test02();
//		test03();
//		test04();
		
		
		sum();
		sum(100);
		sum(100, 200);
		sum(new int[] {100, 200, 300});
		sum(new int[] {100, 200, 300, 400});
	}

	private static void sum(int...arr) {}
	
	/*
	private static void sum(int i) {}
	private static void sum(int i, int j) {}
	private static void sum(int[] arr) {}
	*/
	
}
