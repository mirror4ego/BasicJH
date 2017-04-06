package network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.daum.net");
		InputStream in = url.openStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		while (true) {
			String ch = br.readLine();
				
			if (ch == null)
				break;
			System.out.println(ch);
			
		}
	}
}
