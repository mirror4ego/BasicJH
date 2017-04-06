package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

public class Test01 {
	final static String ApiKey = "f40a84256f9289bc0afd4a350068c648";

	public static String show() throws IOException {
		String requestUrl = "https://apis.daum.net/search/cafe";
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어 : ");
		String searchText = sc.nextLine();
		System.out.print("OUTPUT(1.json 2.xml) : ");
		int output = Integer.parseInt(sc.nextLine());
		String outputType = "xml";
		if (output == 1) {
			outputType = "json";
		}
		String request = requestUrl + "?" + "apikey=" + ApiKey + "&q=" + searchText + "&output=" + outputType;

		URL url = new URL(request);
		InputStream in = url.openStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		String json = "";
		while (true) {
			String data = br.readLine();
			if (data == null)
				break;
			json += data;
		}
		return json;
	}

	public static void main(String[] args) throws IOException {
		String json = show();
		Gson gson = new Gson();
		Cafe cf = gson.fromJson(json, Cafe.class);
		ArrayList<Item> ItemList = cf.getChannel().getItem();
		for (Item i : ItemList) {
			System.out.println("--------------------------------------");
			System.out.println("카페이름 : " + i.getCafeName());
			System.out.println("카페URL : " + i.getCafeUrl());
			System.out.println("요약 : " + i.getDescription());
			System.out.println("등록일 : " + i.getPubDate());
			System.out.println("타이틀 : " + i.getTitle());
			System.out.println("--------------------------------------");
		}

	}
}
