package network;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DaumAPITest02 {
	final static String ApiKey = "f40a84256f9289bc0afd4a350068c648";

	public static void main(String[] args) throws IOException {
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
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		List<ItemVO> itemList = new ArrayList<>();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document dom = builder.parse(in);
			NodeList list = dom.getElementsByTagName("item");

			for (int i = 0; i < list.getLength(); i++) {
				ItemVO iv = new ItemVO();
				Node cNode = list.item(i);
				NodeList cList = cNode.getChildNodes();
				int cLength = cList.getLength();
				for (int j = 0; j < cLength; j++) {
					Node chNode = cList.item(j);
					if ("#text".equals(chNode.getNodeName())) {
						continue;
					}
					String value = chNode.getTextContent();
					switch (chNode.getNodeName()) {
					case "title":
						iv.setTitle(value);
						break;
					case "description":
						iv.setDescription(value);
						break;
					case "link":
						iv.setLink(value);
						break;
					case "cafeName":
						iv.setCafeName(value);
						break;
					case "cafeUrl":
						iv.setCafeUrl(value);
						break;
					case "pubDate":
						Date pubdate = new SimpleDateFormat("yyyyMMddhhmmss").parse(value);
						iv.setPubDate(pubdate);
						break;
					case "cmt_count":
						iv.setCmtCount(Integer.parseInt(value));
						break;
					}
				}
				itemList.add(iv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (ItemVO iv : itemList) {
			System.out.println("----------------------------------------------");
			System.out.println("제목\t:" + iv.getTitle());
			System.out.println("내용\t:" + iv.getDescription());
			System.out.println("주소링크 \t:" + iv.getLink());
			System.out.println("카페명\t:" + iv.getCafeName());
			System.out.println("카페주소\t:" + iv.getCafeUrl());
			System.out.println("작성일시\t:" + new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(iv.getPubDate()));
			System.out.println("조회수\t:" + iv.getCmtCount());
			System.out.println("----------------------------------------------");
		}
	}
}
