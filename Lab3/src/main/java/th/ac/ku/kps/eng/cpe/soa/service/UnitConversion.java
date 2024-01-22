package th.ac.ku.kps.eng.cpe.soa.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface UnitConversion {
	@WebMethod
	double c2f(double degrees);

	@WebMethod
	double cm2in(double cm);

	@WebMethod
	double f2c(double degrees);

	@WebMethod
	double in2cm(double in);
}
