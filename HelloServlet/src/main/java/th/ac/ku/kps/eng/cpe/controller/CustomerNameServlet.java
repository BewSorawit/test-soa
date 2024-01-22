package th.ac.ku.kps.eng.cpe.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import th.ac.ku.kps.eng.cpe.dao.CustomerDAO;
import th.ac.ku.kps.eng.cpe.entity.Customer;

public class CustomerNameServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		String[] value = req.getParameterValues("name");
		if (value != null) {
			ArrayList<Customer> listOfCustomer = CustomerDAO.getAllCustomers();
			for (int i = 0; i < value.length; i++) {
				String paramValue = value[i];
//				out.write(paramValue + '\n');
				for (int j = 0; j < listOfCustomer.size(); j++) {
					Customer c = listOfCustomer.get(j);
					if (c.getName().equals(paramValue)) {
						ByteArrayOutputStream op = new ByteArrayOutputStream();
						ObjectMapper mapper = new ObjectMapper();
						mapper.writeValue(op, c);
						byte[] data = op.toByteArray();
						out.write(new String(data).toString());
					}
				}
			}
		} else {
			out.write("No 'name' parameter provided in the request");
		}

		out.close();
	}
	
	

}
