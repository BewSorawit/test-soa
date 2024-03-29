package order.controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import order.dao.OrderDAO;
import order.entity.Order;

public class OrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");

		List<Order> allOrders = OrderDAO.getAllOrders();

		ByteArrayOutputStream op = new ByteArrayOutputStream();

		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.writeValue(op, allOrders);

		byte[] data = op.toByteArray();
		out.write(new String(data).toString());

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");

		String body = getBody(req);
		System.out.println("Request Body:\n" + body);

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Order newOrder = objectMapper.readValue(body, Order.class);
			ArrayList<Order> orders = OrderDAO.getAllOrders();
			orders.add(newOrder);
			out.write(objectMapper.writeValueAsString(orders));

		} catch (Exception e) {
			out.write(e.getMessage());
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");

		String body = getBody(req);
		System.out.println("Request Body:\n" + body);
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Order updatedOrder = objectMapper.readValue(body, Order.class);
			boolean success = OrderDAO.updateOrder(updatedOrder);

			if (success) {
				// If the update is successful, send a success response
				out.write("{\"success\": true}");
			} else {
				// If the update fails, send an appropriate error response
				out.write("{\"success\": false, \"error\": \"Failed to update the order\"}");
			}

		} catch (Exception e) {
			out.write("{\"success\": false, \"error\": \"" + e.getMessage() + "\"}");
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");

		String orderIdToDelete = req.getParameter("orderId"); // Assuming you pass orderId as a parameter

		try {
			if (orderIdToDelete != null) {
				boolean success = OrderDAO.deleteOrder(orderIdToDelete);

				if (success) {
					// If the deletion is successful, send a success response
					out.write("{\"success\": true}");
				} else {
					// If the deletion fails, send an appropriate error response
					out.write("{\"success\": false, \"error\": \"Failed to delete the order\"}");
				}
			} else {
				// If orderId is not provided in the request parameters
				out.write("{\"success\": false, \"error\": \"orderId is required for deletion\"}");
			}
		} catch (Exception e) {
			out.write("{\"success\": false, \"error\": \"" + e.getMessage() + "\"}");
		}
	}

	public static String getBody(HttpServletRequest request) throws IOException {

		String body = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;

		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}

		body = stringBuilder.toString();
		return body;
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Allow", "GET, POST, PUT, PATCH, DELETE");
	}

}
