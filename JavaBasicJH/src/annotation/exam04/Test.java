package annotation.exam04;

@MyTarget
public class Test {
	
	@MyTarget
	private String name;
	
	@MyTarget
	public void call() {}
	
	@MyTarget
	public void call(@MyTarget String name) {}
}
