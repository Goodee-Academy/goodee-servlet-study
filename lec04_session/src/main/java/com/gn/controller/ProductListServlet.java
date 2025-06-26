package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gn.dto.Product;

@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public ProductListServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1001, "키보드", 25000));
		list.add(new Product(1002, "마우스", 15000));
		list.add(new Product(1003, "모니터", 180000));
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("productList") == null) {
			session = request.getSession(true);
			session.setMaxInactiveInterval(60 * 30);
			session.setAttribute("productList", list);
			session.setAttribute("myProduct", new ArrayList<Product>());
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./views/productPage.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
