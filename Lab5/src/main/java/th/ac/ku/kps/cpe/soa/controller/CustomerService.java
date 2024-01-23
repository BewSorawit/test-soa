package th.ac.ku.kps.cpe.soa.controller;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import DAO.CustomerDAO;
import entity.Customer;

@Path("/services")
public class CustomerService {
	CustomerDAO cusDao = new CustomerDAO();

	@GET
	@Path("/customers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getUsers() {
		return cusDao.getAllCustomers();
	}

	@GET
	@Path("/customers/{param}")
	public Customer getCustomerByname(@PathParam("param") String name) {
		return cusDao.getCustomerByName(name);
	}

	@POST
	@Path("/customers/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCustomer(Customer cus) throws IOException {
		int i = cusDao.addCustomer(cus);
		if (i == 1)
			return Response.status(201).entity(" createsuccessfully").build();
		else
			return Response.status(201).entity(" create fail").build();
	}

}