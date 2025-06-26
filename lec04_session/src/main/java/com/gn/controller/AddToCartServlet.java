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

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public AddToCartServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		
		List<Product> productList = (ArrayList<Product>) session.getAttribute("productList");
		List<Product> myList = (ArrayList<Product>) session.getAttribute("myProduct");
		
		String code = request.getParameter("product");
		for (Product product : productList) {
			if (product.getCode() == Integer.parseInt(code)) {
				myList.add(product);
			}
		}
		
		session.setAttribute("myProduct", myList);
		
		response.sendRedirect("/productList");
	}

}
