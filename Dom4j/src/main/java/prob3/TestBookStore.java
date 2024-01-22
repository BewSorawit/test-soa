package prob3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class TestBookStore {
	public static void main(String[] args) throws Exception {
		BookStore b = new BookStore();
		b.setIsbn("0123456001");
		b.setTitle("Java For Dummies");
		b.setAuthor("Tan Ah Teck");
		b.setCatagory("Programming");
		b.setYear(2009);
		b.setEdition((byte) 7);
		b.setPrice(19.99);

		
		Document doc = DocumentFactory.getInstance().createDocument();
		Element bookstoreElement = doc.addElement("bookstore");

		addBook(bookstoreElement, b);
		
		FileOutputStream fos = new FileOutputStream(
				"C:\\Users\\User\\Desktop\\test-soa\\Dom4j\\src\\main\\java\\prob3\\bookstore.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(fos, format);
		writer.write(doc);
		writer.close();
		fos.close();

	}

	private static void addBook(Element bookstoreElement, BookStore book) {
		Element bookElement = bookstoreElement.addElement("book");
		bookElement.addAttribute("ISBN", book.getIsbn());
		bookElement.addElement("title").addText(book.getTitle());
		bookElement.addElement("author").addText(book.getAuthor());
		bookElement.addElement("category").addText(book.getCatagory());
		bookElement.addElement("year").addText(Integer.toString(book.getYear()));
		bookElement.addElement("edition").addText(Byte.toString(book.getEdition()));
		bookElement.addElement("price").addText(Double.toString(book.getPrice()));
	}

}
