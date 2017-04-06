package xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// XML파싱 후 ArrayList에 담기

public class Test02 {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		List<FamilyVO> fList = new ArrayList<>();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document dom = builder.parse("src/xml/family.xml");
			NodeList list = dom.getElementsByTagName("family");

			for (int i = 0; i < list.getLength(); i++) {
				FamilyVO fv = new FamilyVO();
				Node cNode = list.item(i);
				String nName = cNode.getNodeName();
				NodeList cList = cNode.getChildNodes();
				int cLength = cList.getLength();
				for (int j = 0; j < cLength; j++) {
					Node chNode = cList.item(j);
					if ("#text".equals(nName)) {
						continue;
					}
					String value = chNode.getTextContent();
					switch (chNode.getNodeName()) {
					case "father":
						fv.setFather(value);
						break;
					case "mother":
						fv.setMother(value);
						break;
					case "me":
						fv.setMe(value);
						break;
					}
				}
				fList.add(fv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (FamilyVO fv : fList) {
			System.out.println("father : " + fv.getFather());
			System.out.println("mother : " + fv.getMother());
			System.out.println("me : " + fv.getMe());
		}
	}
}
