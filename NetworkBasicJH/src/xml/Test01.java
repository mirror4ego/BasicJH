package xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// XML파싱

public class Test01 {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			// DocumentBuilder : Dom Parser(xml 문서를 파싱하는 역할 수행)
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			// xml 문서를 읽어서 메모리에 올리기
			Document dom = builder.parse("src/xml/family.xml"); // 매개변수에 스트림도 올수 있음
			NodeList list = dom.getElementsByTagName("family");
			System.out.println("family 수 : " + list.getLength()); // family항목의 개수
			for (int i = 0; i < list.getLength(); i++) {
				Node cNode = list.item(i);
				String nName = cNode.getNodeName();
				System.out.println("node name : " + nName);
				NodeList cList = cNode.getChildNodes();
				int cLength = cList.getLength();
				System.out.println("family의 child 노드 수" + cLength); // enter 키값도 text노드로 본다.
			
				for (int j = 0; j < cLength; j++) { 
					Node chNode = cList.item(j);
					if ("#text".equals(chNode.getNodeName())) {
						continue;
					}
					String value = chNode.getTextContent();
					System.out.println(chNode.getNodeName() + "'s value : "+ value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
