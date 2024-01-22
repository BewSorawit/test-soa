package order.controller;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import order.dao.OrderDAO;
import order.entity.Order;

public class OrderNameServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");

		// Get the search query parameter from the request
		String searchName = req.getParameter("name");
		System.out.println("Search Name: " + searchName);
		if (searchName != null && !searchName.isEmpty()) {
			// Search for orders by name
			List<Order> matchingOrders = OrderDAO.getOrdersByName(searchName);

			// Convert the matching orders to JSON and send the response
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.writeValue(out, matchingOrders);

		} else {
			// If no search parameter provided, return an empty response
			out.write("[]");
		}
	}
}
