package day14;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("id", "hong");
		map.put("name", "홍");
		map.put("email", "hong@a.com");
		
		System.out.println(map.size());
		
		System.out.println(map.get("id"));
		
		// 맵에 해당하는 키가 없을 경우 null 이 반환된다.
		System.out.println(map.get("addr"));
		
		// 키값 벨류값 따로 가져오기
		Set<String> keys = map.keySet();
		for (String key : keys) {
			String value = map.get(key);
			System.out.println(key);
			System.out.println(value);
		}
		
		// 엔트리(키&벨류쌍) 같이 가져오기
		Set<Entry<String, String>> set = map.entrySet();
		for (Entry val : set) {
			System.out.println(val);
		}
		
		System.out.println(map.keySet());	// 전체 키값을 반환
		System.out.println(map.values());	// 전체 벨류값을 반환 
		System.out.println(map.entrySet());	// 전체 키와 벨류쌍을 반환
	
		
		
		
	}
}
