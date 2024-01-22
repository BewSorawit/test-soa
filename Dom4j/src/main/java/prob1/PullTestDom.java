package prob1;

import java.io.*;
import java.util.Iterator;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

public class PullTestDom {
	public static void main(String[] args) throws Exception {
		File xml = new File("C:\\Users\\User\\Desktop\\test-soa\\Dom4j\\src\\main\\java\\prob1\\simple.xml");
		SAXReader reader = new SAXReader();
		Document doc = reader.read(xml);
		Element root = doc.getRootElement();

		Iterator i = root.elements().iterator();

		while (i.hasNext()) {
			Element e = (Element) i.next();
			System.out.println(e.getPath());
			System.out.println(e.getName());
			System.out.println(e.getData());
		}

	}
}
