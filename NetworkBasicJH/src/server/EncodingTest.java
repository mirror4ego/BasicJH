package server;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodingTest {
	public static void main(String[] args) throws Exception {
		String name = "홍길동";
		String encodeName = URLEncoder.encode(name, "UTF-8");
		System.out.println(encodeName);
		String decodeName = URLDecoder.decode(encodeName, "UTF-8");
		System.out.println(decodeName);
	}
}
