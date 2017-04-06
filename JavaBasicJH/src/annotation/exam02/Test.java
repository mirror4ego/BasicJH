package annotation.exam02;

@Marker
public class Test {
	
	// Single Value 일 경우
	// 속성명이 value 인 경우
	// 생략이 가능함
	@Type1(value = "test")
	@Type2(name = "test")
	public void call() {}
	
	@Type1("test")
//	@Type2("test")
	public void call2() {}
}
