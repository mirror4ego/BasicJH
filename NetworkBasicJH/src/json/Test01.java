package json;

import java.util.ArrayList;

import com.google.gson.Gson;

public class Test01 {
	private static void test01() {
		Member m = new Member();
		m.setName("홍길동");
		m.setAge(25);
		
		// 맴버 객체를 json코드로 직접 변경
		String result = "";
		result += "{";
		result += "\"name\":\"" + m.getName() + "\"";
		result += ",\"age\":\"" + m.getAge() + "\"";
		result += "}";
		System.out.println(result);
	}
	
	private static void test02() {
		Member m = new Member();
		m.setName("홍길동");
		m.setAge(25);
		
		// 맴버 객체를 json코드로 라이브러리를 통해 변경
		
		Gson gson = new Gson();
		String result = gson.toJson(m);
		System.out.println(result);
				
	}
	
	private static void test03() {
		Member m = new Member();
		m.setName("홍길동");
		m.setAge(25);
		ArrayList<String> hobbys = new ArrayList<>();
		hobbys.add("영화감상");
		hobbys.add("음악감상");
		hobbys.add("독서");
		m.setHobbys(hobbys);
		
		// 맴버 객체를 json코드로 라이브러리를 통해 변경
		
		Gson gson = new Gson();
		String result = gson.toJson(m);
		System.out.println(result);
		
	}
	
	private static void test04() {
		Member m = new Member();
		m.setName("홍길동");
		m.setAge(25);
		ArrayList<String> hobbys = new ArrayList<>();
		hobbys.add("영화감상");
		hobbys.add("음악감상");
		hobbys.add("독서");
		m.setHobbys(hobbys);
		
		Address a = new Address();
		a.setPostNo("12345");
		a.setBasicAddr("서울 특별시 강남구 역삼동");
		a.setDetailAddr("비트캠프 6층");
		
		m.setAddr(a);
		
		
		// 맴버 객체를 json코드로 라이브러리를 통해 변경
		
		Gson gson = new Gson();
		String result = gson.toJson(m);
		System.out.println(result);
		
	}
	
	private static void test05() {
		String json = "{\"name\":\"홍길동\",\"age\":25}";
		Gson gson = new Gson();
		Member m = gson.fromJson(json, Member.class);
		System.out.println(m.getName());
		System.out.println(m.getAge());
	}
	
	private static void test06() {
		String json = "{\"name\":\"홍길동\",\"age\":25,\"hobbys\":[\"영화감상\",\"음악감상\",\"독서\"]}";
		Gson gson = new Gson();
		Member m = gson.fromJson(json, Member.class);
		System.out.println(m.getName());
		System.out.println(m.getAge());
		System.out.println(m.getHobbys());
	}
	
	private static void test07() {
		String json = "{\"name\":\"홍길동\",\"age\":25,\"hobbys\":[\"영화감상\",\"음악감상\",\"독서\"],\"addr\":{\"postNo\":\"12345\",\"basicAddr\":\"서울 특별시 강남구 역삼동\",\"detailAddr\":\"비트캠프 6층\"}}";
		Gson gson = new Gson();
		Member m = gson.fromJson(json, Member.class);
		Address a = m.getAddr();
		System.out.println(m.getName());
		System.out.println(m.getAge());
		System.out.println(m.getHobbys());
		System.out.println(a.getPostNo());
		System.out.println(a.getBasicAddr());
		System.out.println(a.getDetailAddr());
	}

	public static void main(String[] args) {
		// 객체를 json 으로 직접 변환 연습
//		test01();
		
		// 객체를 json 으로 라이브러리를 통한 변환 연습
//		test02();
		
		// json 에서 배열 형태 처리 방법
//		test03();
		
		// json 에서 객체 형태 처리 방법
//		test04();
		
		// json에서 파싱하기
//		test05();
		
		// json에서 파싱하기 배열
//		test06();
		
		// json에서 파싱하기 클래스
		test07();
		
		
		
		
	}
}
