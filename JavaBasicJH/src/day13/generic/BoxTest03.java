package day13.generic;

public class BoxTest03 {
	public static void main(String[] args) {
		Box3<String, Integer> b = new Box3<String, Integer>("사과", 1);
		String key = b.getKey();
		int value = b.getValue();
		System.out.println(key);
		System.out.println(value);
		
		// 1.7부터 가능
		Box3<String, Integer> b2 = new Box3<>("배", 2);
		String key2 = b2.getKey();
		int value2 = b2.getValue();
		System.out.println(key2);
		System.out.println(value2);
		
		/*
		List<String> list = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		List<Map<String, String>> listMap = new ArrayList<>();
		*/
	}
}
