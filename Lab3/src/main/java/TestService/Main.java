package TestService;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import jakarta.xml.ws.Service;
import th.ac.ku.kps.eng.cpe.soa.service.UnitConversion;

public class Main {
	public static void main(String[] args) throws MalformedURLException {
		// Specify the URL of the WSDL for the web service
        URL url = new URL("http://localhost:8080/UC?wsdl");
        
        // Specify the qualified name for the service and port
        QName qname = new QName("http://service.soa.cpe.eng.kps.ku.ac.th/", "UnitConversionImplService");

        // Create a JAX-WS Service instance
        Service service = Service.create(url, qname);

        // Specify the qualified name for the port and get a reference to the service interface
        qname = new QName("http://service.soa.cpe.eng.kps.ku.ac.th/", "UnitConversionImplPort");
        UnitConversion uc = service.getPort(qname, UnitConversion.class);

        // Call methods on the UnitConversion service and print the results
        System.out.printf("DC to DF: 37 DC = %f DF%n", uc.c2f(37.0));
        System.out.printf("CM to IN: 10 CM = %f IN%n", uc.cm2in(10));
        System.out.printf("DF to DC: 212 DF = %f DC%n", uc.f2c(212.0));
        System.out.printf("IN to CM: 10 IN = %f CM%n", uc.in2cm(10));
    

	}
}
