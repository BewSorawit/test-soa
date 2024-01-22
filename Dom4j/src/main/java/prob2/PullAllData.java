package prob2;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PullAllData {
	public static void main(String[] args) throws Exception {
		File xml = new File("C:\\Users\\User\\Desktop\\test-soa\\Dom4j\\src\\main\\java\\prob2\\simple.xml");
		SAXReader reader = new SAXReader();
		Document doc = reader.read(xml);
		Element root = doc.getRootElement();

		System.out.println("Root element :" + root.getName());
		System.out.println("----------------------------\n");

////		While loop
//		Iterator<Element> iterator = root.elementIterator();
//        while (iterator.hasNext()) {
//            Element element = iterator.next();
//            System.out.println("Element Name: " + element.getName());
//
//            // ใช้ Iterator เพื่อวนลูปทุก Element ใน element ปัจจุบัน
//            Iterator<Element> childIterator = element.elementIterator();
//            while (childIterator.hasNext()) {
//                Element childElement = childIterator.next();
//                System.out.println("  - " + childElement.getName() + ": " + childElement.getText());
//            }
//        }
//		for loop
		List<Element> elements = root.elements();
		for (Element element : elements) {
			System.out.println("Element Name: " + element.getName());
			List<Element> childElements = element.elements();
			for (Element childElement : childElements) {
				System.out.println("  - " + childElement.getName() + ": " + childElement.getText());
			}
		}
	}
}
