package prob2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class TestStudent {
	public static void main(String[] args) throws Exception {
		Document doc = DocumentFactory.getInstance().createDocument();
		Element classElement = doc.addElement("class");
		addStudent(classElement, "393", "dinkar", "kad", "dinkar", "85");
		addStudent(classElement, "493", "Vaneet", "Gupta", "vinni", "95");
		addStudent(classElement, "593", "jasvir", "singn", "jazz", "90");

		FileOutputStream fos = new FileOutputStream(
				"C:\\Users\\User\\Desktop\\test-soa\\Dom4j\\src\\main\\java\\prob2\\simple.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(fos, format);
		writer.write(doc);
		writer.close();
		fos.close();
	}

	private static void addStudent(Element classElement, String rollNo, String firstName, String lastName,
			String nickName, String marks) {
		Element studentElement = classElement.addElement("student");
		studentElement.addAttribute("rollno", rollNo);
		studentElement.addElement("firstname").addText(firstName);
		studentElement.addElement("lastname").addText(lastName);
		studentElement.addElement("nickname").addText(nickName);
		studentElement.addElement("marks").addText(marks);

	}
}
