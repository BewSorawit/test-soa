package prob1;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import jakarta.xml.bind.*;

public class MainXSD {
	public static void main(String[] args) throws JAXBException, IOException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		SchemaOutputResolver sor = new SchemaOutputResolver() {

			@Override
			public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
				File file = new File("C:\\Users\\User\\Desktop\\test-soa\\Lab2\\src\\main\\java\\prob1\\customer.xsd");
				StreamResult result = new StreamResult(file);
				result.setSystemId(file.toURI().toURL().toString());
				return result;
			}
		};
		jaxbContext.generateSchema(sor);
	}
}
