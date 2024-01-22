package prob1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class TestDom {
	public static void main(String[] args) throws Exception {
		Document doc = DocumentFactory.getInstance().createDocument();
		Element root = doc.addElement("root");
		root.addAttribute("myAttribute", "myValue");
		Element elem = root.addElement("myElem");
		elem.addText("Hello World");

		FileOutputStream fos = new FileOutputStream(
				"C:\\Users\\User\\Desktop\\test-soa\\Dom4j\\src\\main\\java\\prob1\\simple.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(fos, format);
		writer.write(doc);
		writer.close();
		fos.close();
	}

}
