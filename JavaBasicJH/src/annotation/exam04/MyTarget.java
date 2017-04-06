package annotation.exam04;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//@Target(ElementType.TYPE)	// 클래스(인터페이스, Enum..) 위쪽에 선언
//@Target(ElementType.METHOD) // 메소드 위쪽에 선언
//@Target(ElementType.FIELD) // 멤버변수 위쪽에 선언
//@Target(ElementType.PARAMETER) // 매개변수 앞쪽에 선언
//@Target({ElementType.TYPE, ElementType.METHOD})  // 여러개 줄때는 배열 형태로 줘야 한다.
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})  // 여러개 줄때는 배열 형태로 줘야 한다.
public @interface MyTarget {}
