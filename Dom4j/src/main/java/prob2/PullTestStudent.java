package prob2;

import java.io.*;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

public class PullTestStudent {
	public static void main(String[] args) {
		try {
			File inputFile = new File("C:\\Users\\User\\Desktop\\test-soa\\Dom4j\\src\\main\\java\\prob2\\simple.xml");
			SAXReader reader = new SAXReader();
			Document document = reader.read(inputFile);

			System.out.println("Root element :" + document.getRootElement().getName());
			java.util.List<org.dom4j.Node> nodes = document.selectNodes("/class/student[@rollno = '493']");
			System.out.println("----------------------------");

			for (org.dom4j.Node node : nodes) {
				System.out.println("\nCurrent Element :" + node.getName());
				System.out.println("Student roll no : " + node.valueOf("@rollno"));
				System.out.println("First Name : " + node.selectSingleNode("firstname").getText());
				System.out.println("Last Name : " + node.selectSingleNode("lastname").getText());
				System.out.println("First Name : " + node.selectSingleNode("nickname").getText());
				System.out.println("Marks : " + node.selectSingleNode("marks").getText());
			}

		} catch (

		DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
