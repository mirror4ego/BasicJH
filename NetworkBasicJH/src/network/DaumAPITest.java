package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class DaumAPITest {
	final static String ApiKey="f40a84256f9289bc0afd4a350068c648";
	public static void main(String[] args) throws IOException {
		String requestUrl = "https://apis.daum.net/search/cafe";
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어 : ");
		String searchText = sc.nextLine();
		System.out.print("OUTPUT(1.json 2.xml) : ");
		int output = Integer.parseInt(sc.nextLine());
		String outputType = "xml";
		if (output==1) {
			outputType = "json";
		}
		String request = requestUrl + "?" + "apikey=" + ApiKey + "&q=" + searchText+ "&output="+outputType;
		URL url = new URL(request);
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
