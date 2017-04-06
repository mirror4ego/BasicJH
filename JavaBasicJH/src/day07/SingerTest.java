package day07;

public class SingerTest {
	public static void main(String[] args) {
		Singer s = new Singer();
//		s. name = "로이킴";		
		s.setName("로이킴");
//		s.age = 17;
		s.setAge(17);
		
		System.out.println("이름 : " + s.getName());
		System.out.println("나이 : " + s.getAge());
		
	}
}
