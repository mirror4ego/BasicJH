package annotation.exam05;

@ClassAnno("클래스 설정")
@RuntimeAnno1("런타임 설정")
public class AnnoApply {
	@RuntimeAnno2(id = "tester", msg = "Hi~~")
	public void info() {}
}
